package net.tecgurus.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.tecgurus.controller.dto.UsuarioDto;

@RestController
public class ClienteRestController {
	
	
	@GetMapping("/usuarios/todos/remoto")
	public Collection<UsuarioDto> consultarUsuariosRemoto() {
		
		
		//connexion por red
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers =  new HttpHeaders();
		
		ResponseEntity<Collection<UsuarioDto>> response = 
				rest.exchange(
						"http://192.168.0.21:8080/usuario/todos/", 					//url request
						HttpMethod.GET, 											//Metodo HTTP
						new HttpEntity<>(headers),									//cabeceras
						new ParameterizedTypeReference<Collection<UsuarioDto>>() {} //wrapper de la respuesta
						);
		
		System.out.println("Codigo de respuesta HTTP: "+ response.getStatusCode()); //400, 500, 404, 200
		return response.getBody();
		
		
	}
	@PutMapping("/usuario/remoto/{id}")
	public UsuarioDto actualizarRemoto(@PathVariable Integer id, @Valid @RequestBody UsuarioDto usuario) throws Exception {
		
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		//enviar headers
		headers.setContentType(MediaType.APPLICATION_JSON);
		//enviar body y cabecera en ese orden
		HttpEntity<UsuarioDto> requestContent = new HttpEntity<UsuarioDto>(usuario, headers);
		Map<String, Integer> uriVariables = new HashMap<String, Integer>();
		uriVariables.put("id", id);
		
		
		ResponseEntity<UsuarioDto> response =
				rest.exchange("http://192.168.0.21:8080/usuario2/{id}", 
						HttpMethod.PUT,
						requestContent,
						new ParameterizedTypeReference<UsuarioDto>() {},
						uriVariables
						);
		if(response.getStatusCode() != (HttpStatus.ACCEPTED)) {
			throw new Exception("Los datos ingresados no son correctos");
		}
		System.out.println("Codigo de respuesta HTTP: "+ response.getStatusCode());
		return response.getBody();
	}

}
