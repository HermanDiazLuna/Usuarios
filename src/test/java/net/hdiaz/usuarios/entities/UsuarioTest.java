package net.hdiaz.usuarios.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.hdiaz.usuarios.entities.Usuario;

public class UsuarioTest {

    @Test
    public void testConstructorAndGettersSetters() {
        Long id = 1L;
        String identificacion = "123456789";
        String telefono = "1234567890";
        String nombre = "John Doe";

        Usuario usuario = new Usuario(id, identificacion, telefono, nombre);

        Assertions.assertEquals(id, usuario.getId());
        Assertions.assertEquals(identificacion, usuario.getIdentificacion());
        Assertions.assertEquals(telefono, usuario.getTelefono());
        Assertions.assertEquals(nombre, usuario.getNombre());

        // Test setters
        usuario.setId(2L);
        usuario.setIdentificacion("987654321");
        usuario.setTelefono("0987654321");
        usuario.setNombre("Jane Doe");

        Assertions.assertEquals(2L, usuario.getId());
        Assertions.assertEquals("987654321", usuario.getIdentificacion());
        Assertions.assertEquals("0987654321", usuario.getTelefono());
        Assertions.assertEquals("Jane Doe", usuario.getNombre());
    }
}

