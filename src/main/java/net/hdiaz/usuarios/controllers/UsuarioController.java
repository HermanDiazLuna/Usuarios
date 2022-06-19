package net.hdiaz.usuarios.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.hdiaz.usuarios.entities.Usuario;
import net.hdiaz.usuarios.services.IUsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;	
	
	@PostMapping("/newUser")
	public ResponseEntity<?> newUser(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.newUser(usuario));
	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> updateUser(@RequestBody Usuario usuario,@PathVariable Long id) {
		return ResponseEntity.ok().body(service.updateUser(usuario, id));
	}

	@GetMapping("/getByUser/{id}")
	public ResponseEntity<?> getByUser(@PathVariable("id") Long idUsuario) {
		Usuario usuario = service.getByUser(idUsuario);
		return ResponseEntity.ok().body(usuario);
	
	}

	@GetMapping("/getUsers")
	public ResponseEntity<?> getUsers(){
		List<Usuario> listaUsuarios = service.getUsers();
		return ResponseEntity.ok().body(listaUsuarios);
	}


	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long idUsuario) {
		service.deleteUser(idUsuario);
		String regElim = "El usuario ha sido eliminado";
		return ResponseEntity.ok().body(regElim);
	
	}



}
