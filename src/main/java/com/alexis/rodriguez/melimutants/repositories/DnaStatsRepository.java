package com.alexis.rodriguez.melimutants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alexis.rodriguez.melimutants.models.DnaStatsModel;

@Repository
public interface DnaStatsRepository extends JpaRepository<DnaStatsModel, Integer>{
	
	DnaStatsModel findById(@Param("DNA_STATS_ID") int dna_stats_id);

}
