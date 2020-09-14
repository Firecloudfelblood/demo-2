package net.tecgurus.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class UsuarioDto {
	
	@NotEmpty(message = "Nombre no pude ser vacio")
	private String name;
	@Email(message = "Correo no valido")
	private String email;
	private String direccion;
	@Positive(message = "Debe ser un numero positivo")
	private Integer edad;
	
	
	
	public UsuarioDto() {
		super();
	}

	public UsuarioDto(String name, String email, String direccion, Integer edad) {
		super();
		this.name = name;
		this.email = email;
		this.direccion = direccion;
		this.edad = edad;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	

}
