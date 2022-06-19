package net.hdiaz.usuarios.utils;

import java.util.Arrays;
import java.util.List;

import net.hdiaz.usuarios.entities.Usuario;

public class Datos {
	
	public final static List<Usuario> USUARIOS = Arrays.asList(
			new Usuario(2L, "112233", "6768706", "carlos martinez"),
			new Usuario(3L, "789", "6666369", "wilmer miranda"),
			new Usuario(4L, "666", "6813281", "angel jimenez"));

}
