package br.com.mam.demorest.controller;

import br.com.mam.demorest.model.Jedi;
import br.com.mam.demorest.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class JediController {
    @Autowired
    private JediRepository jediRepository;

    @GetMapping("/")
    public String redirect() {
        return "redirect:jedi";
    }

    @GetMapping("/jedi")
    public ModelAndView jedi() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");
        modelAndView.addObject("allJedi", jediRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/new-jedi")
    public ModelAndView newJedi() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");
        modelAndView.addObject("jedi", new Jedi());
        return modelAndView;
    }


    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "new-jedi";
        }
        jediRepository.save(jedi);
        redirectAttributes.addFlashAttribute("message", "Jedi cadastrado com sucesso.");
        return "redirect:jedi";
    }


    @GetMapping("/search")
    public ModelAndView searchJedi(@RequestParam("name") String name){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");
        modelAndView.addObject("allJedi", this.jediRepository.findByNameContainingIgnoreCase(name));
        return modelAndView;
    }

}
