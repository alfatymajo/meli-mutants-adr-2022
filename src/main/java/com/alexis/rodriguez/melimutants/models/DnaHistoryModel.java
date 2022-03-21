package com.alexis.rodriguez.melimutants.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "dna_history")
@EntityListeners(AuditingEntityListener.class)
public class DnaHistoryModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "DNA_ID")	
	private int dna_id;
		
	@Column(name = "DNA_JSON_REQUEST")
	private String dna_json_request;
	
	
	@Column(name = "DNA_ARRAY")
	private String dna_array;
	
	
	@Column(name = "DNA_MUTANT")
	private String dna_mutant;
	
	public DnaHistoryModel() {
		
	}

	public DnaHistoryModel(String dna_json_request, String dna_array, String dna_mutant) {
		this.dna_json_request = dna_json_request;
		this.dna_array = dna_array;
		this.dna_mutant = dna_mutant;
	}

	public int getDna_id() {
		return dna_id;
	}

	public void setDna_id(int dna_id) {
		this.dna_id = dna_id;
	}

	public String getDna_json_request() {
		return dna_json_request;
	}

	public void setDna_json_request(String dna_json_request) {
		this.dna_json_request = dna_json_request;
	}

	public String getDna_array() {
		return dna_array;
	}

	public void setDna_array(String dna_array) {
		this.dna_array = dna_array;
	}

	public String getDna_mutant() {
		return dna_mutant;
	}

	public void setDna_mutant(String dna_mutant) {
		this.dna_mutant = dna_mutant;
	}
	
	
	
	
}
