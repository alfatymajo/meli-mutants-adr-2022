package com.alexis.rodriguez.melimutants.controllers;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexis.rodriguez.melimutants.localization.MutantConstants;
import com.alexis.rodriguez.melimutants.models.DnaHistoryModel;
import com.alexis.rodriguez.melimutants.models.DnaStatsModel;
import com.alexis.rodriguez.melimutants.repositories.DnaHistoryRepository;
import com.alexis.rodriguez.melimutants.repositories.DnaStatsRepository;
import com.alexis.rodriguez.melimutants.utils.MutantUtils;
import com.meli.mutants.exceptions.InvalidDNAContentException;
import com.meli.mutants.exceptions.InvalidDNADimensionException;
import com.meli.mutants.home.ServiceHome;
import com.meli.mutants.utils.DNAUtils;
import com.meli.mutants.utils.DNAValidations;

@RestController
@RequestMapping("/api")
public class DnaController {
	
	public static final ResponseEntity<String> responseOk = new ResponseEntity<>(MutantConstants.OK, HttpStatus.OK);
	public static final ResponseEntity<String> responseForbidden = new ResponseEntity<>(MutantConstants.FORBIDDEN, HttpStatus.FORBIDDEN);
	public static final ResponseEntity<String> responseBadRequest = new ResponseEntity<>(MutantConstants.BAD_REQUEST_MESSAGE, HttpStatus.BAD_REQUEST);
	
	@Autowired
	private DnaStatsRepository statsRepository;
	
	@Autowired
	private DnaHistoryRepository historyRepository;
	
	@GetMapping("/stats")
	public String getStats(){
		
		DnaStatsModel response = statsRepository.findById(1);
		
		return response.toString();
	}
	
	@RequestMapping(value = "/mutant", method = RequestMethod.POST,consumes = "text/plain")
	public ResponseEntity<String> saveDna(@RequestBody String request) {
		
		boolean isMutantDna = false;
		
		String[] requestDna = MutantUtils.extractDnaFromRequest(request);
		
		if  (requestDna == null) {
			return responseBadRequest;
		}
		
		String[] dnaToConsult = DNAUtils.DNAToUpperCase(requestDna);
		
		try {
			DNAValidations.checkDnaFormat(dnaToConsult);
		} catch (InvalidDNADimensionException e) {
			return responseBadRequest;
		} catch (InvalidDNAContentException e) {
			return responseBadRequest;
		}
		
		isMutantDna = ServiceHome.isMutant(dnaToConsult);
		
		DnaHistoryModel dnaToPersist = new DnaHistoryModel();
		
		dnaToPersist.setDna_json_request(request);
		
		JSONArray jsonArray = MutantUtils.extractJsonArrayFromRequest(request);
		dnaToPersist.setDna_array(jsonArray.toString());
		
		if (isMutantDna){
			dnaToPersist.setDna_mutant(MutantConstants.YES);
			
			historyRepository.save(dnaToPersist);
			return responseOk;
		}
		
		dnaToPersist.setDna_mutant(MutantConstants.NO);
		
		historyRepository.save(dnaToPersist);
		
		return responseForbidden;
		
	}

}
