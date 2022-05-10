package fr.univrouen.rss22project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String pageAcceuil(Model model) {
        return "Home";
    }

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String pageHelp(Model model) {
        return "Help";
    }

    @GetMapping("/create_item")
    public String insertItem(Model model) {
        return "create_item";
    }


}
