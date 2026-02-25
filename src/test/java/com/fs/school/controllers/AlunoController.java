package com.fs.school.controllers;


import com.fs.school.models.AlunoModel;
import com.fs.school.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/alunos")
public class AlunoController {

    @Autowired
    private  AlunoService alunoService;

    @PostMapping
    public AlunoModel criarAluno(AlunoModel alunoModel){
        return alunoService.criarAluno(alunoModel);
    }

    @GetMapping
    public List<AlunoModel> buscarTodosALunos(){
        return alunoService.buscarTodosAlunos();
    }

    @DeleteMapping("/id")
    public void deletarAluno(Long id){
        alunoService.deletarAluno(id);
    }

}
