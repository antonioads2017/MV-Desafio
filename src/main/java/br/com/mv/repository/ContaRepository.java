package br.com.mv.repository;

import br.com.mv.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContaRepository extends JpaRepository<Conta,String>{

    @Query("SELECT c FROM Conta c WHERE c.cliente.id=:id_client")
    List<Conta> accountsPerClient (int id_client);
}
