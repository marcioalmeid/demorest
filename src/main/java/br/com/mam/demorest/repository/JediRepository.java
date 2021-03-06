package br.com.mam.demorest.repository;

import br.com.mam.demorest.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JediRepository extends JpaRepository <Jedi, Long>{

    List<Jedi> findByNameContainingIgnoreCase(final String name);
}
