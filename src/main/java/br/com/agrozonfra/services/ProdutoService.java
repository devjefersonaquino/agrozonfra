package br.com.agrozonfra.services;

import br.com.agrozonfra.entity.Produto;
import br.com.agrozonfra.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto createProduto (Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listAllProduto(){
        return produtoRepository.findAll();
    }

    public Produto findById (Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Produto updateProduto(Produto produto, Long id){
        findById(id);
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    public void deleteProduto(Long id){
        findById(id);
        produtoRepository.deleteById(id);
    }
}
