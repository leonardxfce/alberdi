package modelos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsuarioTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testComprobarUsuarioVacio(){
        Usuario user= new Usuario("","");
        boolean result = user.comprobarUsuario(user);
        assertEquals(false,result);
    }
    @Test
    public void testComprobarUsuarioRelleno(){
        Usuario user= new Usuario("coso","unodostres");
        boolean result = user.comprobarUsuario(user);
        assertEquals(true,result);
    }
    @Test
    public void testComprobarContraseña(){
        Usuario user = new Usuario("coso","coso");
        boolean result = user.comprobarUsuario(user);
        assertEquals(false,result);
    }
}