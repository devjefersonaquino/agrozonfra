package br.com.agrozonfra.services;

import br.com.agrozonfra.entity.Insumo;
import br.com.agrozonfra.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    public Insumo createInsumo (Insumo insumo){
        return insumoRepository.save(insumo);
    }

    public List<Insumo> listAllInsumo(){
        return insumoRepository.findAll();
    }

    public Insumo findById (Long id){
        Optional<Insumo> insumo = insumoRepository.findById(id);
        return insumoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Insumo updateInsumo(Insumo insumo, Long id){
        findById(id);
        insumo.setId(id);
        return insumoRepository.save(insumo);
    }

    public void deleteInsumo(Long id){
        findById(id);
        insumoRepository.deleteById(id);
    }
}
