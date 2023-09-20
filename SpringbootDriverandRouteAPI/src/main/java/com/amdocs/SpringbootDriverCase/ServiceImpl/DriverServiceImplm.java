package com.amdocs.SpringbootDriverCase.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.SpringbootDriverCase.Repository.DriverRepository;
import com.amdocs.SpringbootDriverCase.Service.DriverService;
import com.amdocs.SpringbootDriverCase.model.DriverEntity;


@Service
public class DriverServiceImplm implements DriverService{
	@Autowired
	private DriverRepository driverRepo;

	@Override
	public boolean saveDriver(DriverEntity driver) {
		// TODO Auto-generated method stub

		// interact db s/w to store data into the database

		DriverEntity driverSave = driverRepo.save(driver);
		boolean flag = false;

		if (driverSave != null)
			flag = true;

		return flag;
	}

	@Override
	public List<DriverEntity> getAllDrivers() {
		// TODO Auto-generated method stub
		//select *from employee;
		List<DriverEntity> driverRecords = driverRepo.findAll();
		return driverRecords;
	}

	@Override
	public DriverEntity getDriverId(int id) {
		// TODO Auto-generated method stub
		//select *From employee where eno=?;
		Optional<DriverEntity> driverId = driverRepo.findById(id);
		DriverEntity driver = driverId.get();
		return driver;
	}
	

	@Override
	public boolean updateDriver(DriverEntity st) {
		// TODO Auto-generated method stub
		
		//Record is exist or not have to check once record is exist then update the data
		
			
		
		return saveDriver(st);
	}

	@Override
	public boolean deleteDriver(int id) {
		// TODO Auto-generated method stub
		//Record is exist or not have to check first then delete
		DriverEntity driver = getDriverId(id);
		boolean flag=false;
		if(driver!=null)
		{
			driverRepo.delete(driver);
		flag=true;	
		}
		
			
		
		return flag;
		
		
	}


}
