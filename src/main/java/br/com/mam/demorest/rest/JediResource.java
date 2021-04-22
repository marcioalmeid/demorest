package br.com.mam.demorest.rest;

import br.com.mam.demorest.exception.JediNotFound;
import br.com.mam.demorest.model.Jedi;
import br.com.mam.demorest.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class JediResource {
    @Autowired
    private JediService jediService;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi() {
        return this.jediService.getAll();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) throws JediNotFound {
        Jedi jedi = this.jediService.getJedi(id);
        return ResponseEntity.ok(jedi);
    }

    @DeleteMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJedi(@PathVariable("id") Long id) throws JediNotFound {
        this.jediService.delete(id);
    }

    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@Valid @RequestBody Jedi jedi) {
        return this.jediService.save(jedi);
    }

    @PutMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id, @Valid @RequestBody Jedi dto) throws JediNotFound {
        final Jedi jediEntity = jediService.update(id, dto);
        return ResponseEntity.ok(jediEntity);
    }

}
