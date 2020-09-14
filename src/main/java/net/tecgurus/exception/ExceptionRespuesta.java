package net.tecgurus.exception;

import java.util.Date;
import java.util.List;

public class ExceptionRespuesta {
	
	private Date timestamp;
	private List<MensajeError> mensajesError;
	private String MensajeGeneral;
	private String detallesGenerales;
	
	
	
	
	public ExceptionRespuesta() {
		super();
	}
	public ExceptionRespuesta(Date timestamp, List<MensajeError> mensajesError, String mensajeGeneral,
			String detallesGenerales) {
		super();
		this.timestamp = timestamp;
		this.mensajesError = mensajesError;
		MensajeGeneral = mensajeGeneral;
		this.detallesGenerales = detallesGenerales;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public List<MensajeError> getMensajesError() {
		return mensajesError;
	}
	public void setMensajesError(List<MensajeError> mensajesError) {
		this.mensajesError = mensajesError;
	}
	public String getMensajeGeneral() {
		return MensajeGeneral;
	}
	public void setMensajeGeneral(String mensajeGeneral) {
		MensajeGeneral = mensajeGeneral;
	}
	public String getDetallesGenerales() {
		return detallesGenerales;
	}
	public void setDetallesGenerales(String detallesGenerales) {
		this.detallesGenerales = detallesGenerales;
	}
	
	

}
