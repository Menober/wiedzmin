package com.heroku.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {


    private OptionRepository repository;

    @Autowired
    public HomeController(OptionRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) {
        return "home";
    }

    @RequestMapping(value = "/zaloguj", method = RequestMethod.POST)
    public String home(Model model, @RequestParam("name") String name) {
        model.addAttribute("name", name);
        return "board";
    }

    @RequestMapping(value = "/glosuj", method = RequestMethod.POST)
    public String glosuj(ModelMap model,BindingResult result, @ModelAttribute("name") String name, @ModelAttribute("button") String button) {

        if (!button.contains("refresh")) {
            Option option = null;
            List<Option> options = repository.findAll();
            for (Option option1 : options) {
                if (option1.getOwner().equals(name))
                    option = option1;
            }
            if (option != null) {
                option.setValue(button);
            } else {
                option = new Option();
                option.setOwner(name);
                option.setValue(button);
            }
            repository.save(option);
        }
        if (button.contains("clear")) {
            repository.deleteAll();
        }

        List<Option> options = repository.findAll();
        options.sort(Comparator.comparing(Option::getOwner));
        model.addAttribute("options", options);
        model.addAttribute("name", name);
        return "board";
    }

}
