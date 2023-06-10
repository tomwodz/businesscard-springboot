package pl.camp.it.tomwodz.businesscard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String main(){
        return "index";
    }

    @RequestMapping(path = "/form", method = RequestMethod.GET)
    public String form(){
        return "form";
    }

    @RequestMapping(path = "/contact", method = RequestMethod.GET)
    public String contact(){
        return "contact";
    }

}
