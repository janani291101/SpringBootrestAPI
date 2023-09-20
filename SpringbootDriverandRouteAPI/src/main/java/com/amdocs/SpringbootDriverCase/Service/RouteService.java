package com.amdocs.SpringbootDriverCase.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.amdocs.SpringbootDriverCase.Repository.DriverRepository;
import com.amdocs.SpringbootDriverCase.Repository.RouteRepository;
import com.amdocs.SpringbootDriverCase.exception.DriverNotFoundException;
import com.amdocs.SpringbootDriverCase.model.DriverEntity;
import com.amdocs.SpringbootDriverCase.model.RouteEntity;


@Service
public class RouteService {
	
private RouteRepository routerepo;
private DriverRepository driverrepo;
	


	@Autowired
	public RouteService(RouteRepository routerepo, DriverRepository driverrepo) {
	super();
	this.routerepo = routerepo;
	this.driverrepo = driverrepo;
}


	//crud operations
	//savebook data
	//insert query is generated at runtime by server using hibernate and jpa
	public RouteEntity saveRoute(RouteEntity route,Integer driverid) throws DriverNotFoundException{
		DriverEntity driver1= driverrepo.findById(driverid).orElse(null);
		if(driver1!=null)
		{
			route.setDrivers(driver1);
		return routerepo.save(route); 
		}
		else
		{
			throw new DriverNotFoundException("Driver does not Exist");
		}
	}
	

	public List<RouteEntity> getAllRoutes()
	{
		return routerepo.findAll();
	}
	
	public 	RouteEntity getRouteById(int routeid)
	{
		return routerepo.findById(routeid).orElse(null);
	}

	public RouteEntity updateRoute(int routeid, RouteEntity route)
	{
		RouteEntity existingroute=routerepo.findById(routeid).orElse(null);
		
		if(existingroute!=null)
		{
			existingroute.setBoarding_point(route.getBoarding_point());
			existingroute.setDeparture_point(route.getDeparture_point());
			existingroute.setTravelendDate(route.getTravelendDate());
			existingroute.setTravelstartDate(route.getTravelstartDate());
		return routerepo.save(existingroute);
		}
		return null;
	}
	
	public void deleteRoute(int routeid)
	{
		 routerepo.deleteById(routeid);
	}

}
