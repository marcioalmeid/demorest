package br.com.mam.demorest.repository;

import br.com.mam.demorest.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {
    final List<Jedi> jediList = new ArrayList<Jedi>();
    public List<Jedi> getAllJedi(){
        return jediList;
    }

    public void add(final Jedi jedi){
        this.jediList.add(jedi);
    }

}
