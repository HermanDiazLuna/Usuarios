package net.hdiaz.usuarios.mappers;

import net.hdiaz.usuarios.dto.UsuarioDTO;
import net.hdiaz.usuarios.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {
    public static Usuario toEntity(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();

        usuario.setId(usuarioDTO.getId());
        usuario.setIdentificacion(usuarioDTO.getIdentificacion());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setNombre(usuarioDTO.getNombre());

        return usuario;
    }

    public static UsuarioDTO toUsuarioDTO(Usuario usuario) {

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setIdentificacion(usuario.getIdentificacion());
        usuarioDTO.setTelefono(usuarioDTO.getTelefono());
        usuarioDTO.setNombre(usuarioDTO.getNombre());

        return usuarioDTO;

    }

    public static List<UsuarioDTO> toListDto(List<Usuario> listaUsuario){

        List<UsuarioDTO> listaUsuarioDTO = new ArrayList<>();

        for(Usuario usuario: listaUsuario) {

            UsuarioDTO usuarioDTO = new UsuarioDTO();

            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setIdentificacion(usuarioDTO.getIdentificacion());
            usuarioDTO.setTelefono(usuarioDTO.getTelefono());
            usuarioDTO.setNombre(usuarioDTO.getNombre());


        }
        return listaUsuarioDTO;
    }
}
