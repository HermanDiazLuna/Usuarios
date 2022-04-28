package net.hdiaz.usuarios;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import net.hdiaz.usuarios.entities.Usuario;
import net.hdiaz.usuarios.repositories.UsuarioRepository;
import net.hdiaz.usuarios.services.IUsuarioService;

@SpringBootTest
class UsuariosApplicationTests {
		

	@Test
	void contextLoads() {
	}
}
