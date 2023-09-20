package com.amdocs.SpringbootDriverCase.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.SpringbootDriverCase.ServiceImpl.DriverServiceImplm;
import com.amdocs.SpringbootDriverCase.model.DriverEntity;



@Controller
public class DriverController {
	
	
	@Autowired
	private DriverServiceImplm DriverService;
	
	@RequestMapping("/")
	public String loadForm(Model model)
	{
		DriverEntity driver=new DriverEntity();
		model.addAttribute("driver", driver);
		
		return "driver";
	}
	
	@RequestMapping("/insert")
	public String handledriverForm(@ModelAttribute("driver")DriverEntity driver,Model model)
	{
		
		//intract to service layer
		boolean saveDriver = DriverService.saveDriver(driver);
		
		String msg="";
		
		if(saveDriver)
			msg="Data Inserted SuccessFully";
		else
			msg="Data Not Inserted SuccessFully";
		
		model.addAttribute("msg", msg);
		return "driver";
	}
	
	
	@RequestMapping("/viewAll")
	public String viewAllDrivers(Model model)
	{
		//fetch the data from the database ,can interact service layer
		List<DriverEntity> allDrivers = DriverService.getAllDrivers();
		
		model.addAttribute("drivers", allDrivers);
		return "view";
	}
	
	@RequestMapping("/deleteDriver")
	public String deleteDriver(@RequestParam("eid")int id)
	{
		boolean flag = DriverService.deleteDriver(id);
		
		if(flag)
		return "redirect:/viewAll";
		else
		return "redirect:/viewAll";
	}
	
	
	@RequestMapping("/editDriver")
	public String editDriver(@RequestParam("eid")   int id,Model model)
	{
		DriverEntity driver = DriverService.getDriverId(id);
		
		model.addAttribute("driver", driver);
		return "editdriver";
	}
	
	@RequestMapping("/update")
	public String updateDriver(DriverEntity driver)
	{
		boolean updateDriver = DriverService.updateDriver(driver);
		
		return "redirect:/viewAll";

	}
	
	

}
