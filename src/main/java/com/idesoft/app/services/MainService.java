package com.idesoft.app.services;

import org.springframework.http.ResponseEntity;

import com.idesoft.app.model.GenericResponse;



public interface MainService {
	
	public ResponseEntity<GenericResponse> getByComuna(String comuna);

}
