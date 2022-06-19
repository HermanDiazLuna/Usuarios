package net.hdiaz.usuarios.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.hdiaz.usuarios.entities.Usuario;
import net.hdiaz.usuarios.exceptions.UsuarioExceptions;
import net.hdiaz.usuarios.repositories.UsuarioRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	@Transactional
	public Usuario newUser(Usuario usuario) {
		
		return repository.save(usuario);
	}

	@Override
	@Transactional
	public Usuario updateUser(Usuario usuario, Long id) {
		Usuario usuBd = repository.getById(id);
		if (usuBd != null) {
			usuBd.setIdentificacion(usuario.getIdentificacion());
			usuBd.setNombre(usuario.getNombre());
			usuBd.setTelefono(usuario.getTelefono());
		}else {
			throw new UsuarioExceptions("ERROR, no existe el usuario");
		}
		return repository.save(usuBd);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario getByUser(Long idUsuario) {
		
			Optional<Usuario> op = repository.findById(idUsuario);
			
			if (!op.isPresent()) {
				throw new UsuarioExceptions("ERROR, El usuario no existe en la base de datos");
			}else {
				return op.get();
			}
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> getUsers() {
		
		List<Usuario> listaUsuarios = repository.findAll();
		return listaUsuarios;

	}

	@Override
	@Transactional
	public void deleteUser(Long idUsuario) {
		
		Optional<Usuario> op = repository.findById(idUsuario);
		
		if (op.isPresent()) {
			repository.deleteById(idUsuario);
		}else {
			throw new UsuarioExceptions("ERROR, El usuario no existe en la base de datos");
		}
		
	}

	
	

}
