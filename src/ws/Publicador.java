/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws;

import RegistroSitio.InterfaceRegistroSitioBO;
import Actividad.ActividadBO;
import Actividad.dtos.ActividadDTO;
import Categoria.CategoriaBO;
import Categoria.DtCategoria;
import Clase.ClaseBO;
import Clase.DtClase;
import Actividad.ActividadDao;
import Cuponera.CuponeraBo;
import Cuponera.DtCuponera;
import Exceptions.CompraCuponeraNotFoundException;
import Exceptions.CuponeraAlreadyPurchaseBySocio;
import Exceptions.MaxClasesForCuponera;
import Institucion.DtInstitucion;
import Institucion.InstitucionBO;
import Premio.PremioDao;
import Profesor.ProfesorBO;
import Profesor.dtos.ProfesorDTO;
import Registro.DtRegistro;
import Registro.RegistroBO;
import Socio.SocioBO;
import Socio.dtos.SocioDTO;
import Premio.PremioBO;
import Usuario.UsuarioBO;
import Usuario.dtos.UsuarioDTO;
import Usuario.exceptions.UnauthorizedException;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import Actividad.dtos.ActividadCreateDTO;
import Exceptions.PremioNotFoundException;
import Exceptions.RegistroNotFoundException;
import Favoritos.FavoritoDAO;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import Premio.dtos.PremioDTO;
import Profesor.dtos.ProfesorCreateDTO;
import Profesor.dtos.ProfesorEditDTO;
import PuntuacionProfesor.IPuntuacionProfesorBO;
import PuntuacionProfesor.PuntuacionProfesorBO;
import RegistroSitio.InterfaceRegistroSitioBO;
import RegistroSitio.RegistroSitioBO;
import RegistroSitio.RegistroSitioDTO;
import Socio.dtos.SocioCreateDTO;
import Socio.dtos.SocioEditDTO;
import Usuario.dtos.UsuarioCreateDTO;
import mygym.logica.usuario.dataTypes.DtPuntuacionProfesor;
import mygym.logica.usuario.dataTypes.ProfesorPuntuacionesDTO;

/**
 *
 * @author maximilianoolivera
 */
@javax.jws.WebService(serviceName = "Publicador")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Publicador {

    UsuarioBO userBO = new UsuarioBO();
    ProfesorBO profeBO = new ProfesorBO();
    SocioBO socioBO = new SocioBO();
    ClaseBO claseBO = new ClaseBO();
    RegistroBO regBO = new RegistroBO();
    CuponeraBo cupBO = new CuponeraBo();
    ActividadBO actBO = new ActividadBO();
    PremioDao premDao = new PremioDao();
    InstitucionBO insBO = new InstitucionBO();
    CategoriaBO catBO = new CategoriaBO();
    PremioBO premBO = new PremioBO();
    ActividadDao actDao = new ActividadDao();
    FavoritoDAO favDao = new FavoritoDAO();
    IPuntuacionProfesorBO puntuacionProfBO = new PuntuacionProfesorBO();
    RegistroSitioBO regSitioBO = new RegistroSitioBO();

    public Endpoint endpoint = null;

    public void publicar() {
        // TODO Auto-generated method stub
        String url = "http://localhost:2222/ws/publicador";
        endpoint = Endpoint.publish(url, this);
    }

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " 2222!";
    }

    @WebMethod(operationName = "login")
    public UsuarioDTO login(@WebParam(name = "email") String email, @WebParam(name = "password") String password) throws UnauthorizedException {
        return userBO.authenticarse(email, password);
    }

    @WebMethod(operationName = "getProfesorById")
    public ProfesorDTO getProfesorById(@WebParam(name = "userId") int userId) {
        return profeBO.getProfesorById(userId);
    }

    @WebMethod(operationName = "consultarSocio")
    public SocioDTO consultarSocio(@WebParam(name = "userId") int userId) {
        return socioBO.consultarSocio(userId);
    }

    @WebMethod(operationName = "getTipoById")
    public String getTipoById(@WebParam(name = "userId") int userId) {
        return userBO.getTipoById(userId);
    }

    @WebMethod(operationName = "consultarClase")
    public DtClase consultarClase(@WebParam(name = "claseId") int claseId) {
        return claseBO.consultarClase(claseId);
    }

    @WebMethod(operationName = "agregarRegistro")
    public void agregarRegistro(@WebParam(name = "socioID") int socioId, @WebParam(name = "claseID") int claseId, @WebParam(name = "registro") DtRegistro registro, @WebParam(name = "cuponeraId") int cuponeraId) throws MaxClasesForCuponera, CompraCuponeraNotFoundException {
        regBO.agregarRegistro(socioId, claseId, registro, cuponeraId);
    }

    @WebMethod(operationName = "agregarRegistroSinCuponera")
    public void agregarRegistroSinCuponera(@WebParam(name = "socioID") int socioId, @WebParam(name = "claseID") int claseId, @WebParam(name = "registro") DtRegistro registro) throws MaxClasesForCuponera, CompraCuponeraNotFoundException {
        regBO.agregarRegistro(socioId, claseId, registro, null);
    }

    @WebMethod(operationName = "comprarCuponera")
    public void comprarCuponera(@WebParam(name = "socioID") int socioId, @WebParam(name = "cuponeraId") int cuponeraId, @WebParam(name = "actividadId") int actividadId) throws CuponeraAlreadyPurchaseBySocio {
        cupBO.comprarCuponera(socioId, cuponeraId, actividadId);
    }

    @WebMethod(operationName = "getUserByEmail")
    public UsuarioDTO getUserByEmail(@WebParam(name = "email") String email) {
        return userBO.getByEmail(email);
    }

    @WebMethod(operationName = "getUserByNickname")
    public UsuarioDTO getUserByNickname(@WebParam(name = "nickname") String nickname) {
        return userBO.getByNickname(nickname);
    }

    @WebMethod(operationName = "consultarCuponera")
    public DtCuponera consultarCuponera(@WebParam(name = "cuponeraId") int cuponeraId) {
        return cupBO.consultarCuponera(cuponeraId);
    }

    @WebMethod(operationName = "cambiarEstadoActividad")
    public void cambiarEstadoActividad(@WebParam(name = "actividadId") int actividadId, @WebParam(name = "estado") String estado) {
        actBO.cambiarEstado(actividadId, estado);
    }

    @WebMethod(operationName = "imprimirPremio")
    public File imprimirPremio(@WebParam(name = "premioId") int premioId, @WebParam(name = "userId") int userId) {
        return premDao.imprimirPremio(premioId, userId);
    }

    @WebMethod(operationName = "listarUsuarios")
    public UsuarioDTO[] listarUsuarios() {
        HashMap<Integer, UsuarioDTO> usuariosDts = userBO.listarUsuarios();
        UsuarioDTO[] usuarios = new UsuarioDTO[usuariosDts.size()];
        SimpleIntegerProperty index = new SimpleIntegerProperty();
        userBO.listarUsuarios().forEach((Integer i, UsuarioDTO user) -> {
            usuarios[index.get()] = user;
            index.set(index.get() + 1);
        });
        return usuarios;
    }

    @WebMethod(operationName = "getActividadesAceptadasSize")
    public int getActividadesAceptadasSize() {
        return actBO.getActividadesAceptadasSize();
    }

    @WebMethod(operationName = "listarInstituciones")
    public DtInstitucion[] listarInstituciones() {
        HashMap<Integer, DtInstitucion> institucionesAll = insBO.listarInstituciones();

        DtInstitucion[] instituciones = new DtInstitucion[institucionesAll.size()];
        SimpleIntegerProperty index = new SimpleIntegerProperty();
        institucionesAll.forEach((Integer i, DtInstitucion inst) -> {
            instituciones[index.get()] = inst;
            index.set(index.get() + 1);
        });
        return instituciones;
    }

    @WebMethod(operationName = "getActividadesWithLimitAndAccepted")
    public ActividadDTO[] getActividadesWithLimitAndAccepted(@WebParam(name = "size") int size) {
        HashMap<Integer, ActividadDTO> actividadesAll = actBO.getActividadesWithLimitAndAccepted(size);

        ActividadDTO[] actividades = new ActividadDTO[actividadesAll.size()];
        SimpleIntegerProperty index = new SimpleIntegerProperty();
        actividadesAll.forEach((Integer i, ActividadDTO act) -> {
            actividades[index.get()] = act;
            index.set(index.get() + 1);
        });
        return actividades;
    }

    @WebMethod(operationName = "listarCategorias")
    public DtCategoria[] listarCategorias() {
        HashMap<Integer, DtCategoria> allCategorias = catBO.listarCategorias();

        DtCategoria[] categorias = new DtCategoria[allCategorias.size()];
        SimpleIntegerProperty index = new SimpleIntegerProperty();
        allCategorias.forEach((Integer i, DtCategoria act) -> {
            categorias[index.get()] = act;
            index.set(index.get() + 1);
        });
        return categorias;
    }

    @WebMethod(operationName = "createWithCategorias")
    public void createWithCategorias(@WebParam(name = "actInfo") ActividadCreateDTO actInfo, @WebParam(name = "instId") int instId, @WebParam(name = "profId") int profId, @WebParam(name = "categorias") String categoriasJson) {
        Gson json = new Gson();
        Type listCategoriasType = new TypeToken<List<DtCategoria>>() {
        }.getType();
        List<DtCategoria> categorias = (List<DtCategoria>) json.fromJson(categoriasJson, listCategoriasType);
        actBO.crearWithCategorias(actInfo, instId, profId, categorias);
    }

    @WebMethod(operationName = "insertarClase")
    public void insertarClase(@WebParam(name = "actId") int actId, @WebParam(name = "claseInfo") DtClase claseInfo) {
        claseBO.insertarClase(actId, claseInfo);
    }

    @WebMethod(operationName = "insertarClaseAndPremio")
    public void insertarClaseAndPremio(@WebParam(name = "actId") int actId, @WebParam(name = "claseInfo") DtClase claseInfo, @WebParam(name = "premioName") String premioName, @WebParam(name = "premioCant") int premioCant) {
        claseBO.insertarClaseAndPremio(actId, claseInfo, premioName, premioCant);
    }

    @WebMethod(operationName = "listarCuponerasBySocio")
    public DtCuponera[] listarCuponerasBySocio(@WebParam(name = "idSocio") int idSocio) {
        HashMap<Integer, DtCuponera> allCuponeras = cupBO.listarCuponerasBySocio(idSocio);

        DtCuponera[] categorias = new DtCuponera[allCuponeras.size()];
        SimpleIntegerProperty index = new SimpleIntegerProperty();
        allCuponeras.forEach((Integer i, DtCuponera cup) -> {
            categorias[index.get()] = cup;
            index.set(index.get() + 1);
        });
        return categorias;
    }

    @WebMethod(operationName = "premioById")
    public PremioDTO premioById(@WebParam(name = "premioId") int premioId) throws PremioNotFoundException {
        return premDao.existe(premioId).getDtPremio();
    }

    @WebMethod(operationName = "getRegistroById")
    public DtRegistro getRegistroById(@WebParam(name = "regId") int regId) {
        return regBO.getById(regId);
    }

    @WebMethod(operationName = "getSeguidoresByUser")
    public int getSeguidoresByUser(@WebParam(name = "userId") int userId) {
        return userBO.getSeguidores(userId);
    }

    @WebMethod(operationName = "getSeguidosByUser")
    public int getSeguidosByUser(@WebParam(name = "userId") int userId) {
        return userBO.getSeguidos(userId);
    }

    @WebMethod(operationName = "consultarSigueUsuario")
    public boolean consultarSigueUsuario(@WebParam(name = "personOneId") int personOneId, @WebParam(name = "personTwoId") int personTwoId) {
        return userBO.consultarSigueUsuario(personOneId, personTwoId);
    }

    @WebMethod(operationName = "seguirUsuario")
    public void seguirUsuario(@WebParam(name = "personOneId") int personOneId, @WebParam(name = "personTwoId") int personTwoId) {
        userBO.seguirAUsuario(personOneId, personTwoId);
    }

    @WebMethod(operationName = "dejarSeguirUsuario")
    public void dejarSeguirUsuario(@WebParam(name = "personOneId") int personOneId, @WebParam(name = "personTwoId") int personTwoId) {
        userBO.dejarSeguirUsuario(personOneId, personTwoId);
    }

    @WebMethod(operationName = "listarActividadesByProfesor")
    public ActividadDTO[] listarActividadesByProfesor(@WebParam(name = "profeId") int profeId) {
        HashMap<Integer, ActividadDTO> allActividades = actBO.listarActividadesByProfesor(profeId);

        ActividadDTO[] actividades = new ActividadDTO[allActividades.size()];
        SimpleIntegerProperty index = new SimpleIntegerProperty();
        allActividades.forEach((Integer i, ActividadDTO act) -> {
            actividades[index.get()] = act;
            index.set(index.get() + 1);
        });
        return actividades;
    }

    @WebMethod(operationName = "listarCuponerasAdquiridasBySocio")
    public DtCuponera[] listarCuponerasAdquiridasBySocio(@WebParam(name = "profeId") int profeId) {
        HashMap<Integer, DtCuponera> allCuponeras = cupBO.listarCuponerasAdquiridasBySocio(profeId);

        DtCuponera[] cuponeras = new DtCuponera[allCuponeras.size()];
        SimpleIntegerProperty index = new SimpleIntegerProperty();
        allCuponeras.forEach((Integer i, DtCuponera act) -> {
            cuponeras[index.get()] = act;
            index.set(index.get() + 1);
        });
        return cuponeras;
    }

    @WebMethod(operationName = "premiosOfUser")
    public PremioDTO[] premiosOfUser(@WebParam(name = "socioId") int socioId) {
        List<PremioDTO> allPremios = premBO.premiosOfUser(socioId);

        PremioDTO[] premios = new PremioDTO[allPremios.size()];
        SimpleIntegerProperty index = new SimpleIntegerProperty();
        allPremios.forEach((PremioDTO prem) -> {
            premios[index.get()] = prem;
            index.set(index.get() + 1);
        });
        return premios;
    }

    @WebMethod(operationName = "getActividadById")
    public ActividadDTO getActividadById(@WebParam(name = "actId") int actId) {
        return actDao.getById(actId).getDtActividad();
    }

    @WebMethod(operationName = "toggleFavoritoActividad")
    public boolean toggleFavoritoActividad(@WebParam(name = "actId") int actId, @WebParam(name = "socioId") int socioId) {
        return favDao.toggleFavoritoActividad(actId, socioId);
    }

    @WebMethod(operationName = "listarCuponerasDisponiblesBySocio")
    public DtCuponera[] listarCuponerasDisponiblesBySocio(@WebParam(name = "idSocio") int idSocio, @WebParam(name = "actId") int actId) {
        HashMap<Integer, DtCuponera> allCuponeras = cupBO.listarCuponerasDisponiblesBySocio(idSocio, actId);

        DtCuponera[] categorias = new DtCuponera[allCuponeras.size()];
        SimpleIntegerProperty index = new SimpleIntegerProperty();
        allCuponeras.forEach((Integer i, DtCuponera cup) -> {
            categorias[index.get()] = cup;
            index.set(index.get() + 1);
        });
        return categorias;
    }

    @WebMethod(operationName = "existeInstitucion")
    public DtInstitucion existeInstitucion(@WebParam(name = "instId") int instId) {
        return insBO.existeInstitucion(instId);
    }

    @WebMethod(operationName = "listarActividadesByInstitucionAndEstado")
    public ActividadDTO[] listarActividadesByInstitucionAndEstado(@WebParam(name = "instId") int instId, @WebParam(name = "estado") String estado) {
        HashMap<Integer, ActividadDTO> allActividades = actBO.listarActividades(instId, estado);

        ActividadDTO[] actividades = new ActividadDTO[allActividades.size()];
        SimpleIntegerProperty index = new SimpleIntegerProperty();
        allActividades.forEach((Integer i, ActividadDTO act) -> {
            actividades[index.get()] = act;
            index.set(index.get() + 1);
        });
        return actividades;
    }

    @WebMethod(operationName = "listarActividadesByCategorias")
    public ActividadDTO[] listarActividadesByCategorias(@WebParam(name = "categorias") String categorias, @WebParam(name = "estado") String estado) {
        Gson json = new Gson();
        Type listCategoriasType = new TypeToken<List<String>>() {
        }.getType();
        List<String> categoriasList = (List<String>) json.fromJson(categorias, listCategoriasType);

        HashMap<Integer, ActividadDTO> allActividades = actBO.listarActividadesByCategoria(categoriasList, estado);

        ActividadDTO[] actividades = new ActividadDTO[allActividades.size()];
        SimpleIntegerProperty index = new SimpleIntegerProperty();
        allActividades.forEach((Integer i, ActividadDTO act) -> {
            actividades[index.get()] = act;
            index.set(index.get() + 1);
        });
        return actividades;
    }

    @WebMethod(operationName = "getValoracionByClass")
    public double getValoracionByClass(@WebParam(name = "claseId") int claseId) {
        return profeBO.getValoracionByClass(claseId);
    }

    @WebMethod(operationName = "getCantValoracionByClass")
    public int getCantValoracionByClass(@WebParam(name = "claseId") int claseId) {
        return profeBO.getCantValoracionByClass(claseId);
    }

    @WebMethod(operationName = "getValoracionesGeneralesByProfe")
    public ProfesorPuntuacionesDTO getValoracionesGeneralesByProfe(@WebParam(name = "profeId") int profeId) {
        return profeBO.getValoracionesGenerales(profeId);
    }

    @WebMethod(operationName = "createPuntuacionProfesor")
    public DtPuntuacionProfesor createPuntuacionProfesor(@WebParam(name = "puntuacion") int puntuacion, @WebParam(name = "socioId") int socioId, @WebParam(name = "registroIdInt") int registroIdInt) throws RegistroNotFoundException, Exception {
        return puntuacionProfBO.create(puntuacion, socioId, registroIdInt);
    }

    @WebMethod(operationName = "editProfeInfo")
    public void editProfeInfo(@WebParam(name = "userId") int userId, @WebParam(name = "data") ProfesorEditDTO data, @WebParam(name = "newPasword") String newPasword) {
        if (newPasword != "") {
            data.setPassword(newPasword.toCharArray());
        }
        profeBO.editProfesorById(userId, data);
    }

    @WebMethod(operationName = "editSocioInfo")
    public void editSocioInfo(@WebParam(name = "userId") int userId, @WebParam(name = "data") SocioEditDTO data, @WebParam(name = "newPasword") String newPasword) {
        if (newPasword != "") {
            data.setPassword(newPasword.toCharArray());
        }
        socioBO.editar(userId, data);
    }

    @WebMethod(operationName = "crearRegistroSitio")
    public void crearRegistroSitio(@WebParam(name = "ip") String ip, @WebParam(name = "url") String url, @WebParam(name = "browser") String browser, @WebParam(name = "os") String os) {
        RegistroSitioDTO reg = new RegistroSitioDTO(ip, url, browser, os);
        regSitioBO.insertar(reg);
    }

    @WebMethod(operationName = "realizarSorteo")
    public SocioDTO[] realizarSorteo(@WebParam(name = "idPremio") int idPremio) {
        List<SocioDTO> resultadosList = premBO.realizarSorteo(idPremio);

        SocioDTO[] resultados = new SocioDTO[resultadosList.size()];
        SimpleIntegerProperty index = new SimpleIntegerProperty();
        resultadosList.forEach((SocioDTO soc) -> {
            resultados[index.get()] = soc;
            index.set(index.get() + 1);
        });
        return resultados;
    }

    @WebMethod(operationName = "crearSocio")
    public void crearSocio(@WebParam(name = "data") SocioCreateDTO data, @WebParam(name = "password") String password) {
        data.setPassword(password.toCharArray());
        userBO.create(data);
    }

    @WebMethod(operationName = "crearProfe")
    public void crearProfe(@WebParam(name = "data") ProfesorCreateDTO data, @WebParam(name = "password") String password) {
        data.setPassword(password.toCharArray());
        userBO.create(data);
    }
}
