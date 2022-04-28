package net.hdiaz.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import net.hdiaz.usuarios.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
