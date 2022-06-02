package br.com.agrozonfra.services;

import br.com.agrozonfra.entity.Fornecedor;
import br.com.agrozonfra.repository.FornecedorRepository;
import br.com.agrozonfra.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor createFornecedor (Fornecedor fornecedor){
       return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listAllFornecedor(){
        return fornecedorRepository.findAll();
    }

    public Fornecedor findById (Long id){
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Fornecedor updateFornecedor(Fornecedor fornecedor, Long id){
        findById(id);
        fornecedor.setId(id);
        return fornecedorRepository.save(fornecedor);
    }

    public void deleteFornecedor(Long id){
        findById(id);
        fornecedorRepository.deleteById(id);
    }

}
