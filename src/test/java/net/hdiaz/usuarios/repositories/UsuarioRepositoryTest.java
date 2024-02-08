package net.hdiaz.usuarios.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.hdiaz.usuarios.services.UsuarioServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import net.hdiaz.usuarios.entities.Usuario;
import net.hdiaz.usuarios.repositories.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UsuarioRepositoryTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Test
    public void testFindAll() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1L, "123", "123456789", "John Doe"));
        usuarios.add(new Usuario(2L, "456", "987654321", "Jane Doe"));

        when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> result = usuarioRepository.findAll();

        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getNombre());
        assertEquals("Jane Doe", result.get(1).getNombre());
    }

    @Test
    public void testFindById() {
        Usuario usuario = new Usuario(1L, "123", "123456789", "John Doe");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<Usuario> result = usuarioRepository.findById(1L);

        assertEquals(usuario, result.get());
    }
}

