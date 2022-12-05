/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Premio;

import Clase.Clase;
import EntityManajer.InterfaceEntityManager;
import Clase.ClaseDao;
import Exceptions.ClaseNotFoundException;
import Exceptions.PremioNotFoundException;
import javax.persistence.EntityManager;
import Premio.dtos.PremioDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Registro.Registro;
import Socio.Socio;
import Socio.dtos.SocioDTO;
import java.util.Random;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import Socio.SocioDAO;

/**
 *
 * @author maximilianoolivera
 */
public class PremioDao implements InterfacePremioDao {

    EntityManager em = InterfaceEntityManager.getInstance();
    ClaseDao claseDao = new ClaseDao();

    public PremioDao() {
        InterfaceEntityManager.getInstance();
    }
    
    public void insertarPremio(int idClase, String nombre, int cantidadSorteado) {
        try {
            Clase clase = claseDao.existe(idClase);
            Premio premio = new Premio();
            premio.setDescripcion(nombre);
            premio.setCantidadSorteados(cantidadSorteado);
            premio.setFechaCreacion(new Date());
            premio.setFueSorteado(false);
            premio.setClase(clase);
            em.getTransaction().begin();
            em.persist(premio);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("InsertarPremio-PremioDao");
            System.out.println(e.getMessage());
        }
    }

    public Premio existe(int id) throws PremioNotFoundException {
        Premio premio = em.find(Premio.class, id);
        if (premio == null) {
            throw new PremioNotFoundException("El premio no existe");
        }
        return premio;
    }

    @Override
    public List<SocioDTO> realizarSorteo(int idPremio) {
        try {
            Premio premio = existe(idPremio);
            if (premio.getClase().getRegistros().size() == 0) {
                throw new PremioNotFoundException("No puedes sortear si aun no tienens ningun alumno");
            }
            List<SocioDTO> usuarios = new ArrayList<>();
            List<SocioDTO> usuariosSorteados = new ArrayList<>();

            Clase clase = premio.getClase();
            if (clase == null) {
                throw new ClaseNotFoundException("Clase no encontrada");
            }
            Random rand = new Random();

            clase.getRegistros().forEach((Registro reg) -> {
                usuarios.add(reg.getSocio().getDtSocio());
            });

            int cantidadSorteados = premio.getCantidadSorteados() >= usuarios.size() ? usuarios.size() : premio.getCantidadSorteados();
            for (int i = 0; i < cantidadSorteados; i++) {
                int randomIndex = rand.nextInt(usuarios.size());
                SocioDTO randomElement = usuarios.get(randomIndex);
                usuariosSorteados.add(usuarios.get(randomIndex));
                usuarios.remove(randomIndex);
            }
            System.out.println("xd1");
            usuariosSorteados.forEach((SocioDTO socio) -> {
                List<Registro> lista = em.createNativeQuery("select * from registro r where r.CLASE_ID=" + premio.getClase().getId() + " and r.SOCIO_id=" + socio.getId(), Registro.class).getResultList();
                System.out.println(lista);

                if (lista.size() > 0) {
                    Registro r = lista.get(0);
                    em.getTransaction().begin();
                    r.agregarPremio(premio);
                    premio.agregarRegistro(r);
                    premio.setFueSorteado(true);
                    em.getTransaction().commit();
                    System.out.println("sii");
                }

            });

            return usuariosSorteados;

        } catch (PremioNotFoundException ex) {
            System.out.println("RealizarSorteo - PrmeioDao");
            System.out.println(ex.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<PremioDTO> premiosOfUser(int idSocio) {
        List<PremioDTO> premiosToReturn = new ArrayList<>();
        List<Premio> lista = em.createNativeQuery("select prem.ID, prem.CANTIDADSORTEADOS, prem.DESCRIPCION, prem.FECHACREACION, prem.FUESORTEADO, prem.CLASEOFPREMIO_ID from registro_premio rp inner join premio prem on prem.ID = rp.premios_ID where EXISTS (select * from registro r where r.id = rp.registros_ID and r.SOCIO_ID = " + idSocio + " ) ORDER BY prem.FECHACREACION DESC;", Premio.class).getResultList();
        if (lista.size() > 0) {
            lista.forEach((Premio premio) -> {
                premiosToReturn.add(premio.getDtPremio());
            });
        }
        return premiosToReturn;
    }

    private static void addEmptyLine(Document paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    @Override
    public File imprimirPremio(int idPremio, int idSocio) {
        try {
            SocioDAO socDao = new SocioDAO();
            Premio prem = existe(idPremio);
            Socio soc = socDao.getById(idSocio);

            File file = new File("hello_world.pdf");
            PdfWriter pdfWriter = new PdfWriter(file);

            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            // Image img = Image.getInstance("blablabla.jpg");  

            Document document = new Document(pdfDocument);
            Calendar cal = Calendar.getInstance();
            cal.setTime(prem.getFechaCreacion());
            cal.add(Calendar.DATE, 30);

            Paragraph titlePargraph = new Paragraph("Comprobante de sorteo para la clase " + prem.getClase().getNombre());
            Paragraph premioNombre = new Paragraph("Premio: " + prem.getDescripcion());
            Paragraph premioCant = new Paragraph("Cantidad Ganadores: " + prem.getCantidadSorteados());
            Paragraph premioActividad = new Paragraph("Actividad :" + prem.getClase().getActividad().getNombre());
            Paragraph ganadorName = new Paragraph("Ganador: " + soc.getNombre() + " - NickName:" + soc.getNickname());
            
            SimpleDateFormat formatValidez = new SimpleDateFormat("MM/dd/yyyy");
            Paragraph validez = new Paragraph("Valido hasta :" + formatValidez.format(cal.getTime()));

            document.add(titlePargraph);
            addEmptyLine(document, 3);
            document.add(premioNombre);
            document.add(premioCant);
            document.add(premioActividad);
             document.add(ganadorName);
            addEmptyLine(document, 1);
            document.add(validez);

            document.close();

            pdfWriter.close();

            System.out.println("PDF creado");
            return file;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (PremioNotFoundException ex) {
            System.out.println("PremioDao - generarPdf");
            System.out.println(ex.getMessage());
        }

        return null;
    }

}
