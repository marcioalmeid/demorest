package br.com.mam.demorest.service;

import br.com.mam.demorest.exception.JediNotFound;
import br.com.mam.demorest.model.Jedi;
import br.com.mam.demorest.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JediService {
    @Autowired
    private JediRepository jediRepository;

    public List<Jedi> getByName(String name){
        return this.jediRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Jedi> getAll() {
        return this.jediRepository.findAll();
    }

    public Jedi getJedi(Long id) throws JediNotFound {
        final Optional<Jedi> jedi = this.jediRepository.findById(id);
        if (jedi.isPresent()) {
            return jedi.get();
        } else {
            throw new JediNotFound();
        }
    }

    public Boolean delete(Long id) throws JediNotFound {
        Optional<Jedi> jedi = this.jediRepository.findById(id);
        if (jedi.isPresent()) {
            this.jediRepository.delete(jedi.get());
            return Boolean.TRUE;
        } else {
            throw new JediNotFound();
        }
    }

    public Jedi save(Jedi jedi) {
        return this.jediRepository.save(jedi);
    }

    public Jedi update(Long id, Jedi dto) throws JediNotFound {
        final Optional<Jedi> jediEntity = jediRepository.findById(id);
        final Jedi jedi;
        if (jediEntity.isPresent()) {
            jedi = jediEntity.get();
        } else {
            throw new JediNotFound();
        }
        jedi.setName(dto.getName());
        jedi.setLastName(dto.getLastName());
        this.jediRepository.save(jedi);
        return jedi;
    }
}
