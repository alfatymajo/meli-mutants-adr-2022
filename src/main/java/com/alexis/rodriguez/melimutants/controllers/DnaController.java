package com.alexis.rodriguez.melimutants.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexis.rodriguez.melimutants.localization.MutantConstants;
import com.alexis.rodriguez.melimutants.models.DnaStatsModel;
import com.alexis.rodriguez.melimutants.repositories.DnaStatsRepository;

@RestController
@RequestMapping("/api")
public class DnaController {
	
	public static final ResponseEntity<String> responseOk = new ResponseEntity<>(MutantConstants.OK, HttpStatus.OK);
	public static final ResponseEntity<String> responseForbidden = new ResponseEntity<>(MutantConstants.FORBIDDEN, HttpStatus.FORBIDDEN);
	public static final ResponseEntity<String> responseBadRequest = new ResponseEntity<>(MutantConstants.BAD_REQUEST_MESSAGE, HttpStatus.BAD_REQUEST);
	
	@Autowired
	private DnaStatsRepository repository;
	
	@GetMapping("/stats")
	public String getStats(){
		
		DnaStatsModel response = repository.findById(1);
		
		return response.toString();
	}
	
	@RequestMapping(value = "/mutant", method = RequestMethod.POST,consumes = "text/plain")
	public ResponseEntity<String> saveDna(@RequestBody String dna) {
		
		return responseOk;
		
	}

}
