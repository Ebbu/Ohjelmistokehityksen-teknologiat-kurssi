package com.example.Imsolost.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import com.example.Imsolost.domain.OppilasRepo;
//import com.example.Imsolost.domain.Oppilas;

	@Controller
	public class OppilasController {
		@Autowired
		private OppilasRepo repository; 
		
	    @RequestMapping(value="/hello", method = RequestMethod.GET)
	    public String studentList(Model model) {	
	        model.addAttribute("students", repository.findAll());
	        return "studentlist";
	    }
	       
	 
	    
    
	}
