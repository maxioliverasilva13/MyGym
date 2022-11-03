/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Profesor;

import Actividad.Actividad;
import Institucion.DtInstitucion;
import Profesor.dtos.ProfesorDTO;
import Profesor.dtos.ProfesorEditDTO;
import Socio.SocioBO;
import Socio.dtos.SocioDTO;
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
public class ProfesorBOTest {
    
    public ProfesorBOTest() {
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
     * Test of getProfesorById method, of class ProfesorBO.
     */
    @Test
    public void testGetProfesorByIdSiExiste() {
        System.out.println("getProfesorById");
        int id = 3;
        ProfesorBO instance = new ProfesorBO();
        ProfesorDTO expResult = null;
        ProfesorDTO result = instance.getProfesorById(id);
        assertTrue(result != null);
    }
    
    public void testGetProfesorByIdNoExiste() {
        System.out.println("getProfesorById");
        int id = 2;
        ProfesorBO instance = new ProfesorBO();
        ProfesorDTO expResult = null;
        try {
        ProfesorDTO result = instance.getProfesorById(id);
        assertTrue(result == null);
        // TODO review the generated test code and remove the default call to fail.
        }catch(Exception error) {
         assertTrue(error.getMessage()== "El profesor no existe");   
        }
    }

    
}
