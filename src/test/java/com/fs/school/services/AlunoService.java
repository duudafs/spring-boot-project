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

    public List<AlunoModel> findAll(){
        return alunoRepository.findAll();
    }

    public AlunoModel criarAluno(AlunoModel alunoModel){
         return alunoRepository.save(alunoModel);
    }

    public AlunoModel buscarId (Long id){
        return alunoRepository.findById(id).get();
    }
    public void deletarAluno (Long id){
        alunoRepository.deleteById(id);
    }

    public AlunoModel atualizarAluno (Long id, AlunoModel alunoModel){
        AlunoModel newAluno = alunoRepository.findById(id).get();
        newAluno.setNome(alunoModel.getNome());
        return alunoRepository.save(newAluno);
    }

}


