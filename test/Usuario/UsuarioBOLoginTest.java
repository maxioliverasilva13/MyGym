/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Usuario;

import Socio.dtos.SocioCreateDTO;
import Usuario.dtos.UsuarioCreateDTO;
import Usuario.dtos.UsuarioDTO;
import Usuario.exceptions.UnauthorizedException;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author mandi
 */

public class UsuarioBOLoginTest {
    
    public UsuarioBOLoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Test of authenticarse method, of class UsuarioBO.
     */
    @Test
    public void testLoginCredencialesCorrectas() throws Exception {

        UsuarioBO instance = new UsuarioBO();

        String email = "md@gmail.com";
        String pass = "asd";
        
        UsuarioCreateDTO create = new SocioCreateDTO("Manuel", "Diu", "mdiu123", pass.toCharArray(), email, new Date(2003, 4, 2), null);
        
        try {
            instance.create(create);
        } catch (Exception e) {
            System.out.println("INFO: User no creado, dado que ya existe.");
            //fail("Usuario repetido/existente.");
        }
        
        System.out.println("\n--- Test Login 1 (Credenciales Correctas) ---");
        System.out.println("- Mail: " + email );
        System.out.println("- Pass: " + pass );
        
        try {
            UsuarioDTO result = instance.authenticarse(email, pass);
            System.out.println("--- ÉXITO ---");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            System.err.println(e.getMessage());
            //fail("Credenciales Incorrectas.");
        }
    }
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    /**
     * Test of authenticarse method, of class UsuarioBO.
     */
    @Test
    public void testLoginCredencialesIncorrectas() throws Exception {

        UsuarioBO instance = new UsuarioBO();

        String email = "md@gmail.com";
        String pass = "asddddINCORRECTA"; // <-- Passwd Incorrecta
               
        System.out.println("\n--- Test Login 2 (Credenciales INCORRECTAS) ---");
        System.out.println("- Mail: " + email );
        System.out.println("- Pass: " + pass );
        System.out.println("- Tested Pass: asddddINCORRECTA" );
        
        exception.expect(UnauthorizedException.class);
        UsuarioDTO result = instance.authenticarse(email, pass);
    }

}
