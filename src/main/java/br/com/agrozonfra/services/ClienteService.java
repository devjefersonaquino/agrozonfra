package br.com.agrozonfra.services;

import br.com.agrozonfra.entity.Cliente;
import br.com.agrozonfra.exceptionhandler.ClienteNotFoundException;
import br.com.agrozonfra.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return cliente.orElseThrow(() -> new ClienteNotFoundException());
    }

    public Cliente updateCliente(Cliente cliente, Long id){
        findById(id);
        Cliente updateCliente = clienteRepository.getById(id);
        BeanUtils.copyProperties(cliente, updateCliente, "id");
        return clienteRepository.save(updateCliente);
    }

    public void deleteCliente(Long id){
        findById(id);
        clienteRepository.deleteById(id);
    }

}
