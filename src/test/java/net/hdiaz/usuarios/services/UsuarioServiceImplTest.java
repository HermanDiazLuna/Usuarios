package net.hdiaz.usuarios.services;

<<<<<<< HEAD
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
=======
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import net.hdiaz.usuarios.entities.Usuario;
import net.hdiaz.usuarios.repositories.UsuarioRepository;

@SpringBootTest
public class UsuarioServiceImplTest {
	
	@InjectMocks
	UsuarioServiceImpl usuarios;
	
	@Mock
	UsuarioRepository repository;
	
	List<Usuario> listausuarios = new ArrayList<Usuario>();
	
	@BeforeAll
	private static void primera() {
		System.out.println("inicio de la clase Test");
	}
		
	@Test
	public void getUsersTest() {
		
		List<Usuario> listUsuario = cargarUsuarios();
		
		when(repository.findAll()).thenReturn(listUsuario);
		
		List<Usuario> lista = repository.findAll();
		
		/*espectativa - esperado*/
		
		assertEquals(3, lista.size());
		
		assertFalse(lista.size() > 5);
		
		assertFalse(lista.isEmpty());
		
		assertTrue(lista.size() < 4);
		
		verify(repository, times(1)).findAll();
		
	}
	
	@Test
	public void getByUserTest() {
		
		Usuario user = new Usuario();
		user.setId(1L);
		user.setIdentificacion("123");
		user.setNombre("pablo perez");
		user.setTelefono("3215554488");
		
		Optional<Usuario> op = Optional.of(user);
		
		when(repository.findById(1L)).thenReturn(op);
		
		Optional<Usuario> userReturn = repository.findById(1L);
		
		assertNotNull(userReturn);
		
		assertEquals(1L, user.getId());
		assertEquals("123", user.getIdentificacion());
		assertEquals("pablo perez", user.getNombre());
		assertEquals("3215554488", user.getTelefono());
		
		verify(repository, times(1)).findById(1L);
		
		
	}
	
	@Test
	public void updateUserTest() {
		/**Usuario que retorna la busqueda*/
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setIdentificacion("456");
		usuario.setNombre("luis diaz");
		usuario.setTelefono("6660825");
		
		
		when(repository.getById(1L)).thenReturn(usuario);
		Usuario usuBuscado = repository.getById(1L);
		
		assertNotNull(usuBuscado);
		assertEquals("456",usuBuscado.getIdentificacion());
		
		
		
		Usuario usuarioEditado = new Usuario(1L, "456", "6533541", "luis perez");
		when(repository.save(usuarioEditado)).thenReturn(usuarioEditado);
		
		Usuario usuarioGuardado = repository.save(usuarioEditado);
		
		assertNotNull(usuarioGuardado);
		assertEquals("456", usuarioGuardado.getIdentificacion());
		assertEquals("6533541", usuarioGuardado.getTelefono());
		assertEquals("luis perez", usuarioGuardado.getNombre());
		
		
		
	}
	
	@Test
	@DisplayName(value = "test nuevo usuario")
	public void newUserTest() {
		
		/**usuario a guardar*/
		Usuario usuario = new Usuario();
		usuario.setId(null);
		usuario.setIdentificacion("1234");
		usuario.setNombre("xxx");
		usuario.setTelefono("6668887");
		
		/**Answer retorna el objeto que pasamos como parametro modificado*/
		when(repository.save(usuario)).then(new Answer<Usuario>() {
			
			Long secuencia = 8L;	
			
			@Override
			public Usuario answer(InvocationOnMock invocation) throws Throwable {
				Usuario usu = invocation.getArgument(0);
				usu.setId(secuencia);
				return usu;
			}
			
		});
		
		
		Usuario usu = repository.save(usuario);
		assertNotNull(usu);
		assertEquals(8L, usu.getId());
		assertEquals("1234", usu.getIdentificacion() );
		assertEquals("xxx", usu.getNombre());
		assertEquals("6668887", usu.getTelefono());
		
		
	}
	
	public List<Usuario> cargarUsuarios() {
		
		Usuario usu1 = new Usuario();
		usu1.setId(Long.valueOf(1));
		usu1.setNombre("juan");
		usu1.setIdentificacion("123");
		usu1.setTelefono("666555");
		
		Usuario usu2 = new Usuario();
		usu2.setId(Long.valueOf(2));
		usu2.setNombre("felipe");
		usu2.setIdentificacion("100");
		usu2.setTelefono("456789");
		
		Usuario usu3 = new Usuario();
		usu3.setId(Long.valueOf(3));
		usu3.setNombre("maria");
		usu3.setIdentificacion("800");
		usu3.setTelefono("111145");
		
		listausuarios.add(usu1);
		listausuarios.add(usu2);
		listausuarios.add(usu3);
		return listausuarios;
	}
	
	@Test
	public void deleteUserTest() {
		
		/**Listar todos*/
		List<Usuario> listUsuario = cargarUsuarios();
		when(repository.findAll()).thenReturn(listUsuario);
		List<Usuario> lista = repository.findAll();
		
		/** recorrer un arreglo*/
		lista.forEach(a-> System.out.println("list before --> "+a.getNombre()));
		
		
		repository.deleteById(2L);
		
		
		when(repository.findAll()).thenReturn(listUsuario);
		
		List<Usuario> lista2 = repository.findAll().stream().filter(u-> u.getId() != 2).collect(Collectors.toList());
		
		lista2.forEach(subList-> System.out.println("list after --> "+subList.getNombre()));
		
		
		
	}
	
	@AfterAll
	private static void ultima() {
		System.out.println("fin del test de la clase");
	}
	

>>>>>>> 53657587a698dde4650baf3a55e57db3e7b3f1f7
}
