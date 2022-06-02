package br.com.agrozonfra.controller;

import br.com.agrozonfra.entity.Fornecedor;
import br.com.agrozonfra.repository.FornecedorRepository;
import br.com.agrozonfra.repository.FornecedorRepository;
import br.com.agrozonfra.services.FornecedorService;
import br.com.agrozonfra.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> createFornecedor (@Valid @RequestBody Fornecedor fornecedor) throws Exception{
        Fornecedor newFornecedor = fornecedorService.createFornecedor(fornecedor);
        return new ResponseEntity<>(newFornecedor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listAllFornecedor (){
        return new ResponseEntity<>(fornecedorService.listAllFornecedor(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Long id){
        return ResponseEntity.ok(fornecedorService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> updateFornecedor(@RequestBody Fornecedor fornecedor, @PathVariable Long id){
        return new ResponseEntity<>(fornecedorService.updateFornecedor(fornecedor, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable Long id){
        fornecedorService.deleteFornecedor(id);
        return ResponseEntity.ok().build();
    }
}
