package com.example.driverLicense.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.driverLicense.models.License;
import com.example.driverLicense.models.Person;
import com.example.driverLicense.services.LicenseService;
import com.example.driverLicense.services.PersonService;

@Controller
public class MainController {
	
    private final PersonService personService;
    private final LicenseService licenseService;
    
    public MainController(PersonService personService, LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }

	@GetMapping("/persons")
    public String index(Model model) {
        List<Person> persons = personService.allPersons();
        model.addAttribute("persons", persons);
        System.out.println("I am here");
        return "index.jsp";
    }
	
    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "new.jsp";
    }
	
	@GetMapping("/persons/new")
    @RequestMapping(value="/persons/create", method=RequestMethod.POST)
	  public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		
		System.out.println("I SHOULD BE CREATING");
		if (result.hasErrors()) {
			return "redirect:/persons";
		} else {
		    personService.createPerson(person);
		    return "redirect:/persons";
		}
	}
	
	@RequestMapping("/persons/new/license")
	 public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.allPersons();
	    model.addAttribute("persons", persons);
        return "newLicense.jsp";
    }
	
	@GetMapping("/persons/new/license")
    @RequestMapping(value="/persons/license/create", method=RequestMethod.POST)
	  public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		System.out.println("I SHOULD BE CREATING A LICENSE");
		if (result.hasErrors()) {
			System.out.println("THERE IS AN ERROR CREATING A LICENSE");
			System.out.println(result.getAllErrors());
			return "redirect:/persons";
		} else {
			license.setNumber(License.getNextLicenseNumber());
		    licenseService.createLicense(license);
		    
		    System.out.println("REDIRECTING BACK HOME, LICENSE SHOULD BE CREATED");
		    return "redirect:/persons";
		}
	}
	
	@RequestMapping("/persons/{id}")
    public String showPerson(@PathVariable("id") Long id, Model model) {
		Person person = personService.findPerson(id);
		model.addAttribute("person", person);
        return "show.jsp";
    }
	
}
