/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Socio;

import Registro.Registro;
import Socio.dtos.SocioDTO;
import Socio.dtos.SocioEditDTO;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedri
 */
public class SocioBOTest {
    
    public SocioBOTest() {
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
     * Test of consultarSocio method, of class SocioBO.
     */
    @Test
    public void testConsultarSocioSiExiste() {
        System.out.println("consultarSocio");
        int id = 1;
        SocioBO instance = new SocioBO();
        SocioDTO expResult = null;
        SocioDTO result = instance.consultarSocio(id);
        assertTrue(result != null);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    @Test
    public void testConsultarSocioNoExiste() {
        System.out.println("consultarSocio");
        int id = 2;
        SocioBO instance = new SocioBO();
        SocioDTO expResult = null;
        try {
        SocioDTO result = instance.consultarSocio(id);
        assertTrue(result == null);
        // TODO review the generated test code and remove the default call to fail.
        }catch(Exception error) {
         assertTrue(error.getMessage()== "El socio no existe");   
        }
    }
    
}
