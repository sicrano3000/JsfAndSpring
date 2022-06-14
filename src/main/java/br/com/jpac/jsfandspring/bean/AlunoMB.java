package br.com.jpac.jsfandspring.bean;

import br.com.jpac.jsfandspring.FacesMessageUtil;
import br.com.jpac.jsfandspring.model.Aluno;
import br.com.jpac.jsfandspring.service.AlunoService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.List;

@Named(value = "alunoMB")
@ViewScoped
public class AlunoMB {

    @Autowired
    private AlunoService alunoService;

    @Getter
    @Setter
    private List<Aluno> alunos;

    @Getter
    @Setter
    private Aluno alunoSelecionado;

    @Getter
    private String teste = "Olá";

    @PostConstruct
    public void init() {
        alunos = listarTodos();
    }

    public List<Aluno> listarTodos() {
       return alunoService.findAll();
    }

    public void save(Aluno aluno) {
        alunoService.save(aluno);
    }

    public void onRowEdit(RowEditEvent<Aluno> event) {
        save(event.getObject());

        FacesMessageUtil.addSuccessMessage("Aluno editado com sucesso!");
    }

    public void onRowCancel(RowEditEvent<Aluno> event) {
        FacesMessageUtil.addSuccessMessage("Edição cancelada!");
    }

}
