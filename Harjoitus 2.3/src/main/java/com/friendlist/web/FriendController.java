package com.friendlist.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.friendlist.domain.Friend;
import com.friendlist.domain.FriendRepository;


@Controller
public class FriendController {

		@Autowired
		private FriendRepository repository; 
		
	    @RequestMapping(value="/")
	    public String studentList(Model model) {	
	        model.addAttribute("friends", repository.findAll());
	    	model.addAttribute("friend", new Friend());
	        return "friendlist";
	    }
	    
	    @RequestMapping(value = "/", method = RequestMethod.POST)
	    public String save(Friend friend, Model model){
	        repository.save(friend);
	        model.addAttribute("friends", repository.findAll());
	        return "friendlist";
	    }     
	}
