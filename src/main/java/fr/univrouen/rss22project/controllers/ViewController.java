package fr.univrouen.rss22project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@Controller
public class ViewController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String pageAcceuil() {
        return "Home";
    }

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String pageHelp() {
        return "Help";
    }

    @GetMapping("/create_item")
    public String createItem() {
        return "create_item";
    }

    @GetMapping("/items_list")
    public String getItemsList() {
        return "items_list";
    }

    @GetMapping("/item_details/{guid}")
    public String itemDetails(Model model, @PathVariable UUID guid) {
        model.addAttribute("guid", guid);
        return "item_details";
    }

}
