package harjotus.jou.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MessageController {



    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String greeting(@RequestParam (value="name")String name,@RequestParam(value="age")int age, Model model) {
        if (age < 18) {
        	return "result";
        }
        
    	model.addAttribute("name", name);
        return "hello";
    }

}