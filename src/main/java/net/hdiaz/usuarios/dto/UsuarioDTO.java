package net.hdiaz.usuarios.dto;

public class UsuarioDTO {

    private Long id;
    private String identificacion;
    private String telefono;
    private String nombre;

    public UsuarioDTO(Long id, String identificacion, String telefono, String nombre) {
        this.id = id;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.nombre = nombre;
    }

    public UsuarioDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
