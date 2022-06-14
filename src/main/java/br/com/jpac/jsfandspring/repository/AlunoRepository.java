package br.com.jpac.jsfandspring.repository;

import br.com.jpac.jsfandspring.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
