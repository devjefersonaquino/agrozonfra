package br.com.agrozonfra.repository;

import br.com.agrozonfra.entity.Cliente;
import br.com.agrozonfra.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
