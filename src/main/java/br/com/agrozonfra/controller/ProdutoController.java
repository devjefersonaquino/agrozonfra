package br.com.agrozonfra.controller;

import br.com.agrozonfra.entity.Cliente;
import br.com.agrozonfra.entity.Produto;
import br.com.agrozonfra.repository.ClienteRepository;
import br.com.agrozonfra.repository.ProdutoRepository;
import br.com.agrozonfra.services.ClienteService;
import br.com.agrozonfra.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> createProduto (@Valid @RequestBody Produto produto) throws Exception{
        Produto newProduto = produtoService.createProduto(produto);
        return new ResponseEntity<>(newProduto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listAllProduto (){
        return new ResponseEntity<>(produtoService.listAllProduto(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto, @PathVariable Long id){
        return new ResponseEntity<>(produtoService.updateProduto(produto, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id){
        produtoService.deleteProduto(id);
        return ResponseEntity.ok().build();
    }
}
