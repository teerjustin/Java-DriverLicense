package com.example.driverLicense.services;

import org.springframework.stereotype.Service;

import com.example.driverLicense.models.License;
import com.example.driverLicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public License createLicense(License b) {
		return licenseRepository.save(b);
	}
}
