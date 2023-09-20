package com.amdocs.SpringbootDriverCase.Service;

import java.util.List;

import com.amdocs.SpringbootDriverCase.model.DriverEntity;


public interface DriverService {
	
	public boolean saveDriver(DriverEntity driver);
	
	public List<DriverEntity> getAllDrivers();
	
	public DriverEntity getDriverId(int id);

	public boolean updateDriver(DriverEntity st);

	public boolean deleteDriver(int id);

}
