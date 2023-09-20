package com.amdocs.SpringbootDriverCase.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.SpringbootDriverCase.model.DriverEntity;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Integer> {
	

}
