package br.com.senai.comercio194.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.comercio194.entity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{
    
}
