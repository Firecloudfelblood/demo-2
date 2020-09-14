package net.tecgurus.exception;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ManejeErroresPersonalizados extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionRespuesta> manejarTodasLasExcepciones(Exception ex, WebRequest request){
		
		ExceptionRespuesta exceptionRspuesta = new ExceptionRespuesta(
				new Date(),
				null,
				ex.getMessage(),
				request.getDescription(true)
				);
		return new ResponseEntity<ExceptionRespuesta>(exceptionRspuesta, HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
			//binding result guarda errores cuando algun dato no cuadra con el dto de entrada
		BindingResult br = ex.getBindingResult();//lista de errores
		List<ObjectError> errores = br.getAllErrors();
		
		List<MensajeError> listaErrores = new ArrayList<MensajeError>();
		
		for (ObjectError oError : errores) {
			MensajeError me = new MensajeError(
					oError.getObjectName(),
					oError.getCodes()[1],
					oError.getDefaultMessage(),
					""
					);
			listaErrores.add(me);
			
		}
		ExceptionRespuesta exceptionRspuesta = new ExceptionRespuesta(
				new Date(),
				listaErrores,
				"Fallo la validacion de campos",
				"Revisar lista de errores adjunta"
				);
		
		
		return new ResponseEntity<Object> (exceptionRspuesta, HttpStatus.BAD_REQUEST);
	}
	

}
