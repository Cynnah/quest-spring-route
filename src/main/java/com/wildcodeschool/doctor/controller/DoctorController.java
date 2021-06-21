package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {
	
    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable int number, String name) {
    	
    	if (number >= 1 && number <= 12) {
    		throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Error 303, See other");
    	} else if (number == 13) {
    		Doctor Jodie = new Doctor(13, "Jodie Whittaker");
    		return Jodie;
    	}else if (number > 12) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error 404, Impossible de récupérer l'incarnation" + number +".");
        }
        return null;
    }
}
 