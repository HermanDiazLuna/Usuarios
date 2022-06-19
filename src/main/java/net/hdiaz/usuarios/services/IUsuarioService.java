package net.hdiaz.usuarios.services;

import java.util.List;
import net.hdiaz.usuarios.entities.Usuario;

public interface IUsuarioService {
	
	Usuario newUser(Usuario usuario);
	Usuario updateUser(Usuario usuario, Long id);
	Usuario getByUser(Long idUsuario);
	List<Usuario> getUsers();
	void deleteUser(Long idUsuario);
	
}
