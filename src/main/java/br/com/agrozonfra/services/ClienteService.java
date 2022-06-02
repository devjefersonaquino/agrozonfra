package br.com.agrozonfra.services;

import br.com.agrozonfra.entity.Cliente;
import br.com.agrozonfra.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente createCliente (Cliente cliente){
       return clienteRepository.save(cliente);
    }

    public List<Cliente> listAllCliente(){
        return clienteRepository.findAll();
    }

    public Cliente findById (Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Cliente updateCliente(Cliente cliente, Long id){
        findById(id);
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id){
        findById(id);
        clienteRepository.deleteById(id);
    }

}
