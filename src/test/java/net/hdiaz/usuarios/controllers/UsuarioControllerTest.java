package net.hdiaz.usuarios.controllers;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import net.hdiaz.usuarios.controllers.UsuarioController;
import net.hdiaz.usuarios.entities.Usuario;
import net.hdiaz.usuarios.services.IUsuarioService;

@SpringBootTest
public class UsuarioControllerTest {

    @Mock
    private IUsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testNewUser() {
        Usuario usuario = new Usuario();
        when(usuarioService.newUser(usuario)).thenReturn(usuario);

        ResponseEntity<?> response = usuarioController.newUser(usuario);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(usuario, response.getBody());
        verify(usuarioService, times(1)).newUser(usuario);
    }

    @Test
    public void testUpdateUser() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        when(usuarioService.updateUser(usuario, 1L)).thenReturn(usuario);

        ResponseEntity<?> response = usuarioController.updateUser(usuario, 1L);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(usuario, response.getBody());
        verify(usuarioService, times(1)).updateUser(usuario, 1L);
    }

    @Test
    public void testGetByUser() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        when(usuarioService.getByUser(1L)).thenReturn(usuario);

        ResponseEntity<?> response = usuarioController.getByUser(1L);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(usuario, response.getBody());
        verify(usuarioService, times(1)).getByUser(1L);
    }

    @Test
    public void testGetUsers() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario());
        when(usuarioService.getUsers()).thenReturn(usuarios);

        ResponseEntity<?> response = usuarioController.getUsers();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(usuarios, response.getBody());
        verify(usuarioService, times(1)).getUsers();
    }

    @Test
    public void testDeleteUser() {
        ResponseEntity<?> response = usuarioController.deleteUser(1L);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("El usuario ha sido eliminado", response.getBody());
        verify(usuarioService, times(1)).deleteUser(1L);
    }
}

