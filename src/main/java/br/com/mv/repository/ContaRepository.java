package br.com.mv.repository;

import br.com.mv.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta,String>{
}
