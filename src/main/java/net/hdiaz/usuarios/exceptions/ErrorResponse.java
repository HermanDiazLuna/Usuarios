package net.hdiaz.usuarios.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorResponse {
	private Integer status;
	private String msj;
	private String fecha;
	
	public ErrorResponse(Integer status, String msj) {
		this.status = status;
		this.msj = msj;
		this.fecha = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a").format(LocalDateTime.now());
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public String getMsj() {
		return msj;
	}
	
	public String getFecha() {
		return fecha;
	}
}
