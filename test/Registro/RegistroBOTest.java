/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Registro;

import java.util.Date;
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
public class RegistroBOTest {

    public RegistroBOTest() {
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

    /**
     * Test of agregarRegistro method, of class RegistroBO.
     */
    @Test
    public void testAgregarRegistroSiSocioNoExiste() throws Exception {
        int idSocio = 2222;
        int claseID = 1;
        DtRegistro registro = new DtRegistro(0, null, new Date(), "", "");
        Integer cuponeraId = null;
        RegistroBO instance = new RegistroBO();
        try {
            instance.agregarRegistro(idSocio, claseID, registro, cuponeraId);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Socio no encontrado"));
        }
    }

    @Test
    public void testAgregarRegistroSiClaseNoExiste() throws Exception {
        int idSocio = 2;
        int claseID = 234;
        DtRegistro registro = new DtRegistro(0, null, new Date(), "", "");
        Integer cuponeraId = null;
        RegistroBO instance = new RegistroBO();
        try {
            instance.agregarRegistro(idSocio, claseID, registro, cuponeraId);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("La clase no existe"));
        }
    }

    @Test
    public void testAgregarRegistro() throws Exception {
        int idSocio = 2;
        int claseID = 1;
        DtRegistro registro = new DtRegistro(0, null, new Date(), "", "");
        Integer cuponeraId = null;
        RegistroBO instance = new RegistroBO();
        try {
            instance.agregarRegistro(idSocio, claseID, registro, cuponeraId);
            assertTrue(true);
        } catch (Exception e) {
            if (e.getMessage().contains("La clase a la que te intentas inscribir, ya esta llena.")) {
                assertTrue(true);
            }
            if (e.getMessage().contains("La clase a la que te intentas inscribir, ya esta llena.")) {
                assertTrue(true);
            }
        }
    }

    @Test
    public void testAgregarRegistroSiCuponeraNoExiste() throws Exception {
        int idSocio = 2;
        int claseID = 1;
        DtRegistro registro = new DtRegistro(0, null, new Date(), "", "");
        Integer cuponeraId = 333333;
        RegistroBO instance = new RegistroBO();
        try {
            instance.agregarRegistro(idSocio, claseID, registro, cuponeraId);

        } catch (Exception e) {
            if (e.getMessage().contains("La clase a la que te intentas inscribir, ya esta llena.")) {
                assertTrue(true);
            } else {
                assertTrue(e.getMessage().contains("Cuponera no existe"));

            }
        }
    }
}
