/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Cuponera;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maximilianoolivera
 */
public class CuponeraBoTest {

    public CuponeraBoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {

    }

    public void checkIfAlreadyPurchase(Exception ex) {
        assertTrue(ex.getMessage().contains("El socio ya tiene esta cuponera"));
    }

    @Test
    public void testComprarCuponeraSiUsuarioNoExiste() throws Exception {
        int socioID = 255;
        int IdCuponera = 1;
        int idActividad = 1;
        CuponeraBo instance = new CuponeraBo();

        try {
            instance.comprarCuponera(socioID, IdCuponera, idActividad);
            assertTrue(false);
        } catch (Exception ex) {
            assertTrue(ex.getMessage().contains("El socio no existe"));
        }
    }

    @Test
    public void testComprarCuponeraSiCuponeraNoExiste() throws Exception {
        int socioID = 2;
        int IdCuponera = 222;
        int idActividad = 1;
        CuponeraBo instance = new CuponeraBo();

        try {
            instance.comprarCuponera(socioID, IdCuponera, idActividad);
            assertTrue(false);
        } catch (Exception ex) {
            assertTrue(ex.getMessage().contains("La cuponera no existe"));
        }
    }

    @Test
    public void testComprarCuponeraSiActividadNoPerteneceACuponera() throws Exception {
        int socioID = 2;
        int idCuponera = 1;
        int idActividad = 2;
        CuponeraBo instance = new CuponeraBo();

        try {
            instance.comprarCuponera(socioID, idCuponera, idActividad);
            assertTrue(false);
        } catch (Exception ex) {
            if (ex.getMessage().contains("Cuponera X Actividad no encontrada")) {
                assertTrue(ex.getMessage().contains("Cuponera X Actividad no encontrada"));

            } else {
                checkIfAlreadyPurchase(ex);
            }
        }
    }

    @Test
    public void testComprarCuponeraSiActividadNoExiste() throws Exception {
        int socioID = 2;
        int idCuponera = 1;
        int idActividad = 255;
        CuponeraBo instance = new CuponeraBo();

        try {
            instance.comprarCuponera(socioID, idCuponera, idActividad);
            assertTrue(false);
        } catch (Exception ex) {
            if (ex.getMessage().contains("La actividad no existe.")) {
                assertTrue(ex.getMessage().contains("La actividad no existe."));
            } else {
                checkIfAlreadyPurchase(ex);
            }
        }
    }

    @Test
    public void testComprarCuponera() throws Exception {
        int socioID = 2;
        int idCuponera = 1;
        int idActividad = 1;
        CuponeraBo instance = new CuponeraBo();

        try {
            instance.comprarCuponera(socioID, idCuponera, idActividad);
            assertTrue(true);
        } catch (Exception ex) {
            if (ex.getMessage().contains("Ya compraste esta cuponera")) {
                assertTrue(ex.getMessage().contains("Ya compraste esta cuponera"));
            } else {
                checkIfAlreadyPurchase(ex);
            }
        }
    }

    @Test
    public void testConsultarCuponeraSiNoExiste() throws Exception {
        int idCuponera = 222;
        CuponeraBo instance = new CuponeraBo();

        try {
            instance.consultarCuponera(idCuponera);
            assertTrue(true);
        } catch (Exception ex) {
            assertTrue(ex.getMessage().contains("Cuponera no encontrada"));
        }
    }

    @Test
    public void testConsultarCuponeraSiExiste() throws Exception {
        int idCuponera = 1;
        CuponeraBo instance = new CuponeraBo();

        try {
            DtCuponera cup = instance.consultarCuponera(idCuponera);
            assertTrue(cup != null);
        } catch (Exception ex) {
            assertTrue(false);
        }
    }
}
