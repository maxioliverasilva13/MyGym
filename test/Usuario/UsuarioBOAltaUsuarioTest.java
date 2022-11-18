/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Usuario;

import Socio.SocioBO;
import Socio.dtos.SocioCreateDTO;
import Socio.exceptions.SocioNotExist;
import Usuario.dtos.UsuarioCreateDTO;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mandi
 */
public class UsuarioBOAltaUsuarioTest {

    public UsuarioBOAltaUsuarioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of create method, of class UsuarioBO.
     */
    @Test
    public void testCreate() {
        UsuarioBO instance = new UsuarioBO();
        SocioBO isocio = new SocioBO();

        System.out.println("\n--- Test Alta Usuario (Socio) ---");
        UsuarioCreateDTO userCreate = new SocioCreateDTO("Pepe", "Farias", "pf123", "asd".toCharArray(), "pfarias@gmail.com", new Date(2001, 6, 22), null);

        try {
            instance.create(userCreate);
            assertTrue(true);
        } catch (Exception e) {
            if (e.getMessage().contains("ya existe un usuario con este nickname")) {
                assertTrue(true);
            } else {
                fail(e.getMessage());
            }
        }
    }
}
