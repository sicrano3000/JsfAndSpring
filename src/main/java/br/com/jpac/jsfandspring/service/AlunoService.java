package br.com.jpac.jsfandspring.service;

import br.com.jpac.jsfandspring.model.Aluno;
import br.com.jpac.jsfandspring.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService{

    @Autowired
    private AlunoRepository repository;

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public void save(Aluno aluno) {
        repository.save(aluno);
    }

}
