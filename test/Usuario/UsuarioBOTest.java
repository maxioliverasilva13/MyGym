/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Usuario;

import Exceptions.UsuarioASeguirNotFoundException;
import Usuario.dtos.UsuarioCreateDTO;
import Usuario.dtos.UsuarioDTO;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author maximilianoolivera
 */
public class UsuarioBOTest {

    public UsuarioBOTest() {
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

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testSeguirAMiMismo() {
        int myId = 0;
        int idUsuario = 0;

        UsuarioBO instance = new UsuarioBO();
        try {
            instance.seguirAUsuario(myId, idUsuario);
            assertTrue(true);
        } catch (Exception ex) {
            assertTrue(ex.getMessage().contains("No te puedes seguir a ti mismo"));
        }
    }

    @Test
    public void testSeguirAOtroUsuarioQueNoExiste() {
        int myId = 1;
        int idUsuario = 555;
        UsuarioBO instance = new UsuarioBO();
        try {
            instance.seguirAUsuario(myId, idUsuario);
            assertTrue(true);
        } catch (Exception ex) {
            assertTrue(ex.getMessage().contains("El usuario que voy a seguir no existe"));
        }
    }
    
    

    @Test
    public void testSeguirAOtroUsuarioYYoNoExisto() {
        int myId = 155;
        int idUsuario = 1;
        UsuarioBO instance = new UsuarioBO();
        try {
            instance.seguirAUsuario(myId, idUsuario);
            assertTrue(true);
        } catch (Exception ex) {
            assertTrue(ex.getMessage().contains("El usuario que va a seguir no existe"));
        }
    }
    
      @Test
    public void testSeguirAUsuario() {
        int myId = 1;
        int idUsuario = 2;
        UsuarioBO instance = new UsuarioBO();
        try {
            instance.seguirAUsuario(myId, idUsuario);
            assertTrue(true);
        } catch (Exception ex) {
            assertTrue(ex.getMessage().contains("Ya sigues a este usuario"));
        }
    }

}
