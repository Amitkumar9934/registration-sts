package com.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.dto.RegistrationDto;
import com.webapp.entity.Registration;
import com.webapp.service.RegistrationService;
import com.webapp.util.EmailService;

@Controller
public class RegistrationController {
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RegistrationService registrationService;
	
	 //http://localhost:8080/view-registration-page
	//Handler Methods
	@RequestMapping("/view-registration-page")
	public String viewsRegistrationPage() {
		return "new_registration";
	}
	
	@RequestMapping("/saveReg")
	public String saveReg(RegistrationDto dto,Model model) {
		
		Registration registration = new Registration();
		registration.setFirstName(dto.getFirstName());
		//registration.setLastName(dto.getLastName());
		registration.setEmail(dto.getEmail());
		//registration.setMobile(dto.getMobile());
		registrationService.saveRegistration(registration);
		
		
		emailService.sendEmail(dto.getEmail(),"Welcome","test");
		
		return "new_registration";
	}
	//http://localhost:8080/getAllReg
	@RequestMapping("/getAllReg")
	public String getAllRegistrations(Model model) {
		List<Registration> reg = registrationService.getAllRegistrations();
		System.out.println(reg);
		model.addAttribute("registrations", reg);
		return "list_registrations";
	}
	
	@RequestMapping("/delete")
	public String deleteRegById(@RequestParam("id") long id, Model model) {
		registrationService.deleteRegById(id);
		List<Registration> reg = registrationService.getAllRegistrations();
		model.addAttribute("registrations", reg);
		return "list_registrations";
	}
	
	@RequestMapping("getRegistrationById")
	public String getRegistrationById(@RequestParam("id") long id, Model model) {
		Registration registration = registrationService.getRegistrationById(id);
		model.addAttribute("reg", registration);
		return"update_registration";
	}
	
	@RequestMapping("/updateReg")
	public String updateRegistration(
			RegistrationDto dto,
			Model model
			) {
		Registration registration = new Registration();
		registration.setId(dto.getId());
		registration.setFirstName(dto.getFirstName());
		//registration.setLastName(dto.getLastName());
		registration.setEmail(dto.getEmail());
		//registration.setMobile(dto.getMobile());
		
		registrationService.saveRegistration(registration);
		
		List<Registration> reg = registrationService.getAllRegistrations();
		model.addAttribute("registrations", reg);
		return "list_registrations";
		}

}
