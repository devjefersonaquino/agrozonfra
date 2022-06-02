package br.com.agrozonfra.controller;

import br.com.agrozonfra.entity.Insumo;
import br.com.agrozonfra.repository.InsumoRepository;
import br.com.agrozonfra.services.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/insumos")
public class InsumoController {


    @Autowired
    private InsumoRepository insumoRepository;

    @Autowired
    private InsumoService insumoService;

    @PostMapping
    public ResponseEntity<Insumo> createInsumo (@Valid @RequestBody Insumo insumo) throws Exception{
        Insumo newInsumo = insumoService.createInsumo(insumo);
        return new ResponseEntity<>(newInsumo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Insumo>> listAllInsumo (){
        return new ResponseEntity<>(insumoService.listAllInsumo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Insumo> findById(@PathVariable Long id){
        return ResponseEntity.ok(insumoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Insumo> updateInsumo(@RequestBody Insumo insumo, @PathVariable Long id){
        return new ResponseEntity<>(insumoService.updateInsumo(insumo, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteInsumo(@PathVariable Long id){
        insumoService.deleteInsumo(id);
        return ResponseEntity.ok().build();
    }
}
