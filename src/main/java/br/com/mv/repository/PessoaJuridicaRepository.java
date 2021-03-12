package br.com.mv.repository;

import br.com.mv.model.Pessoa;
import br.com.mv.model.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica,String> {

    @Query ("SELECT pj.clientes FROM PessoaJuridica  pj WHERE pj.cnpj=:cnpj")
    List<Pessoa> findClients (@Param("cnpj") String cnpj);


}
