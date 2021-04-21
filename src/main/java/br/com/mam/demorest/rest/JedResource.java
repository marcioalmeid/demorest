package br.com.mam.demorest.rest;

import br.com.mam.demorest.model.Jedi;
import br.com.mam.demorest.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JedResource {
    @Autowired
    private JediRepository jediRepository;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi(){
        return this.jediRepository.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public Jedi getJedi(@RequestAttribute Long id){
        return this.jediRepository.findById(id).get();
    }

}
