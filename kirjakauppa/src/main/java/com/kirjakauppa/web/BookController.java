package com.kirjakauppa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kirjakauppa.domain.Book;
import com.kirjakauppa.domain.BookRepository;


@Controller
public class BookController {


	@Autowired
	private BookRepository repository; 
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
    
    @RequestMapping(value="/booklist")
    public String studentList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    }     
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long Id, Model model) {
    	repository.delete(Id);
        return "redirect:../booklist";
    }   
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }        
    
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> studentListRest() {	
        return (List<Book>) repository.findAll();
    }    
    
	// RESTful service to get book by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long Id) {	
    	return repository.findOne(Id);
    }    
}
