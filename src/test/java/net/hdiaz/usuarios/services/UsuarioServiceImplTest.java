package net.hdiaz.usuarios.services;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import net.hdiaz.usuarios.entities.Usuario;
import net.hdiaz.usuarios.exceptions.UsuarioExceptions;
import net.hdiaz.usuarios.repositories.UsuarioRepository;
import net.hdiaz.usuarios.services.UsuarioServiceImpl;

@SpringBootTest
public class UsuarioServiceImplTest {

	@Mock
	private UsuarioRepository usuarioRepository;

	@InjectMocks
	private UsuarioServiceImpl usuarioService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNewUser() {
		Usuario usuario = new Usuario();
		when(usuarioRepository.save(usuario)).thenReturn(usuario);

		Usuario result = usuarioService.newUser(usuario);

		Assertions.assertNotNull(result);
		verify(usuarioRepository, times(1)).save(usuario);
	}

	@Test
	public void testUpdateUser() {
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		when(usuarioRepository.getById(1L)).thenReturn(usuario);
		when(usuarioRepository.save(usuario)).thenReturn(usuario);

		Usuario updatedUsuario = new Usuario();
		updatedUsuario.setNombre("Nuevo Nombre");

		Usuario result = usuarioService.updateUser(updatedUsuario, 1L);

		Assertions.assertEquals("Nuevo Nombre", result.getNombre());
		verify(usuarioRepository, times(1)).getById(1L);
		verify(usuarioRepository, times(1)).save(usuario);
	}

	@Test
	public void testGetByUser() {
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

		Usuario result = usuarioService.getByUser(1L);

		Assertions.assertNotNull(result);
		verify(usuarioRepository, times(1)).findById(1L);
	}

	@Test
	public void testGetByUserNotFound() {
		when(usuarioRepository.findById(1L)).thenReturn(Optional.empty());

		Assertions.assertThrows(UsuarioExceptions.class, () -> {
			usuarioService.getByUser(1L);
		});
		verify(usuarioRepository, times(1)).findById(1L);
	}

	@Test
	public void testGetUsers() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario());
		usuarios.add(new Usuario());
		when(usuarioRepository.findAll()).thenReturn(usuarios);

		List<Usuario> result = usuarioService.getUsers();

		Assertions.assertEquals(2, result.size());
		verify(usuarioRepository, times(1)).findAll();
	}

	@Test
	public void testDeleteUser() {
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

		usuarioService.deleteUser(1L);

		verify(usuarioRepository, times(1)).deleteById(1L);
	}

	@Test
	public void testDeleteUserNotFound() {
		when(usuarioRepository.findById(1L)).thenReturn(Optional.empty());

		Assertions.assertThrows(UsuarioExceptions.class, () -> {
			usuarioService.deleteUser(1L);
		});
		verify(usuarioRepository, times(0)).deleteById(1L);
	}
}
