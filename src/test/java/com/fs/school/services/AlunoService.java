package com.fs.school.services;

import java.util.List;
import com.fs.school.models.AlunoModel;
import com.fs.school.repositories.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoModel criarAluno(AlunoModel alunoModel){
         return alunoRepository.save(alunoModel);
    }

    public List<AlunoModel> buscarTodosAlunos(){
        return alunoRepository.findAll();
    }

    public void deletarAluno (Long id){
        alunoRepository.deleteById(id);
    }

}
