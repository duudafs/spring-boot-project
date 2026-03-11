package com.fs.school.controllers;


import com.fs.school.models.AlunoModel;
import com.fs.school.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/alunos")
public class AlunoController {

    @Autowired
    private  AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<ALunoModel> > findAll(){
        List<AlunoModel> requeste = alunoService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<AlunoModel> criarAluno(@RequestBody AlunoModel alunoModel){
        AlunoModel requeste = alunoService.criarAluno(alunoModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(alunoModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/id")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional <AlunoModel> buscarId(@PathVariable Long id){
        return alunoService.buscarId(id);
    }


   @PutMapping("/{id}")
    public AlunoModel atualizarAluno (@PathVariable Long id, @RequestBody AlunoModel alunoModel){
        return alunoService.atualizarAluno(id, alunoModel);

   }




}
