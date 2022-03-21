package com.alexis.rodriguez.melimutants.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.alexis.rodriguez.melimutants.localization.MutantConstants;


@Entity
@Table(name = "dna_stats")
@EntityListeners(AuditingEntityListener.class)
public class DnaStatsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "DNA_STATS_ID")	
	private int dna_stats_id;

	@Column(name = "COUNT_MUTANT_DNA")
	private int count_mutant_dna;
	
	@Column(name = "COUNT_HUMAN_DNA")
	private int count_human_dna;
	
	@Column(name = "RATIO")
	private float ratio;
	
	public DnaStatsModel() {
		
	}

	public DnaStatsModel(int dna_stats_id, int count_human_dna, int count_mutant_dna, float ratio) {
		this.dna_stats_id = dna_stats_id;
		this.count_human_dna = count_human_dna;
		this.count_mutant_dna = count_mutant_dna;
		this.ratio = ratio;
	}

	public int getDna_stats_id() {
		return dna_stats_id;
	}

	public void setDna_stats_id(int dna_stats_id) {
		this.dna_stats_id = dna_stats_id;
	}
	public int getCount_mutant_dna() {
		return count_mutant_dna;
	}
	
	public void setCount_mutant_dna(int count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}

	public int getCount_human_dna() {
		return count_human_dna;
	}

	public void setCount_human_dna(int count_human_dna) {
		this.count_human_dna = count_human_dna;
	}


	public float getRatio() {
		return ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}
	
	@Override
	public String toString() {
		JSONObject statsJsonResponse = new JSONObject();
		
		try {
			statsJsonResponse.put(MutantConstants.COUNT_MUTANT_DNA, count_mutant_dna);
			statsJsonResponse.put(MutantConstants.COUNT_HUMAN_DNA, count_human_dna);
			statsJsonResponse.put(MutantConstants.RATIO, ratio);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		return statsJsonResponse.toString();
		
		return "{\"count_mutant_dna\":"+ count_mutant_dna +",\"count_human_dna\":"+ count_human_dna +",\"ratio\":"+ratio+"}";
	}
	
		
	
}
