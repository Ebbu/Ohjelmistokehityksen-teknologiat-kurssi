package com.kirjakauppa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kirjakauppa.domain.Kirja;
import com.kirjakauppa.domain.KirjaRepository;


@Controller
public class BookController {


	@Autowired
	private KirjaRepository repository; 
	
    //Etusivu kirjalistalla 
    @RequestMapping(value="/")
    public String studentList2(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

	
	//Login sivusto. @RequestMapping(value="/login")
    @RequestMapping(value="/login")
    public String login() {	
        return "login"; 
    }	
    
    //Hakee kaikki kirjat.
    @RequestMapping(value="/booklist")
    public String studentList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
    //Tallennetaan uusi kirja
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Kirja());
        return "addbook";
    } 
    
    //Poistetaan kirja ID:n perusteella, joka tulee urlin mukana.
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long Id, Model model) {
    	repository.delete(Id);
        return "redirect:../booklist";
    }   
    
    //Tallennetaan kirja
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Kirja book){
        repository.save(book);
        return "redirect:booklist";
    }        
    
    //Haetaan kaikki kirjat repositorystä.
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Kirja> studentListRest() {	
        return (List<Kirja>) repository.findAll();
    }    
    
	// Hae kirja ID:n perusteella, joka lähetetään osoiterivin kautta.
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Kirja findBookRest(@PathVariable("id") Long Id) {	
    	return repository.findOne(Id);
    }    
}
