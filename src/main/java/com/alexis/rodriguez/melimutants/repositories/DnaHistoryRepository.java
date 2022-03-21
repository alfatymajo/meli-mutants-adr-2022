package com.alexis.rodriguez.melimutants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexis.rodriguez.melimutants.models.DnaHistoryModel;

@Repository
public interface DnaHistoryRepository extends JpaRepository<DnaHistoryModel,Integer>{

}
