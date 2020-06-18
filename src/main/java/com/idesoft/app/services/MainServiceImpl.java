package com.idesoft.app.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idesoft.app.controllers.MainController;
import com.idesoft.app.model.DataDTO;
import com.idesoft.app.model.GenericResponse;
import com.idesoft.app.model.ResponseDTO;


@Service
public class MainServiceImpl implements MainService {
	
	private static Logger logger = LogManager.getLogger(MainController.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${serviceURL}")
	String URL;
	
	public ResponseEntity<GenericResponse> getByComuna(String comuna){
		
		logger.info("GET BY COMUNA SERVICE");
		GenericResponse genericResponse = new GenericResponse();
		HttpStatus status = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			
		String response = restTemplate.getForObject(URL, String.class);
		DataDTO[] lista =  mapper.readValue(response, DataDTO[].class);
		List<DataDTO> listaComuna = Arrays.asList(lista);
		
		List<ResponseDTO> outputLista = new ArrayList<ResponseDTO>();
		for(int i=0; i<listaComuna.size(); i++) {
			if(listaComuna.get(i).getComuna_nombre().equals(comuna.toUpperCase())) {
				ResponseDTO filterOutput = new ResponseDTO();
				filterOutput.setNombreLocal(listaComuna.get(i).getLocal_nombre());
				filterOutput.setLatitud(listaComuna.get(i).getLocal_lat());
				filterOutput.setLongitud(listaComuna.get(i).getLocal_lng());
				filterOutput.setDireccion(listaComuna.get(i).getLocal_direccion());
				filterOutput.setTelefono(listaComuna.get(i).getLocal_telefono());
				outputLista.add(filterOutput);
			}
		}
		
		
		
		
		genericResponse.setCode(200);
		genericResponse.setMessage("Datos encontrados");
		genericResponse.setResponse(outputLista);
		status = HttpStatus.OK;
			
		}catch(Exception ex) {
			status = HttpStatus.BAD_REQUEST;
			genericResponse.setCode(500);
			genericResponse.setMessage("Error al ejecutar servicio");
			genericResponse.setResponse(null);
		}
		
		
		
		return new ResponseEntity<GenericResponse>(genericResponse, status);
	}
	
}