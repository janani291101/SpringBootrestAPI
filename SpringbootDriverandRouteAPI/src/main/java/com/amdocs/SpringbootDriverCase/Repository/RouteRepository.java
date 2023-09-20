package com.amdocs.SpringbootDriverCase.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.amdocs.SpringbootDriverCase.model.DriverEntity;
import com.amdocs.SpringbootDriverCase.model.RouteEntity;



@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Integer> {
	

}
