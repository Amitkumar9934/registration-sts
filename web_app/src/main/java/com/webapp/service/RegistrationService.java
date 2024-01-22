package com.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.entity.Registration;
import com.webapp.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepo;
	
	public void saveRegistration(Registration registration) {
		registrationRepo.save(registration);
	}

	public List<Registration> getAllRegistrations() {
		List<Registration> regs = registrationRepo.findAll();
		return regs;
	}
	
	public void deleteRegById(long id) {
		registrationRepo.deleteById(id);
	}

	public Registration getRegistrationById(long id) {
		Registration reg = registrationRepo.findById(id).get();
		return reg;
	}

}
