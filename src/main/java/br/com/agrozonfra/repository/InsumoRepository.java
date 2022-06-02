package br.com.agrozonfra.repository;

import br.com.agrozonfra.entity.Insumo;
import br.com.agrozonfra.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long> {
}
