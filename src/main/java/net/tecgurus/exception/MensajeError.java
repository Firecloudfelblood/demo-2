package net.tecgurus.exception;

public class MensajeError {
	private String objeto;
	private String campo;
	private String mensaje;
	private String valorRechasado;
	
	
	
	public MensajeError() {
		super();
	}
	public MensajeError(String objeto, String campo, String mensaje, String valorRechasado) {
		super();
		this.objeto = objeto;
		this.campo = campo;
		this.mensaje = mensaje;
		this.valorRechasado = valorRechasado;
	}
	public String getObjeto() {
		return objeto;
	}
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getValorRechasado() {
		return valorRechasado;
	}
	public void setValorRechasado(String valorRechasado) {
		this.valorRechasado = valorRechasado;
	}
	
	

}
