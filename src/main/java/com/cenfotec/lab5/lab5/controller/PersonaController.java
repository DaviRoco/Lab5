package com.cenfotec.lab5.lab5.controller;

import com.cenfotec.lab5.lab5.domain.Journal;
import com.cenfotec.lab5.lab5.domain.Persona;
import com.cenfotec.lab5.lab5.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.Instant;
import java.util.Date;

@Controller
public class PersonaController {
    @Autowired
    PersonaService personaService;
    @RequestMapping("/getAll")
    public String indx(Model model){
        model.addAttribute("persona", personaService.getAllPersonas());
        return "index";
    }
    @RequestMapping(value = "/agregarPersona", method = RequestMethod.GET)
    public String insertar(Model model){
        model.addAttribute(new Persona());
        return "agregarEntrada";
    }

    @RequestMapping(value = "/agregarPersona", method = RequestMethod.POST)
    public String accionInsertar(Persona persona, BindingResult result, Model model){
        personaService.savePersona(persona);
        return "index";
    }
}
