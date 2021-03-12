package br.com.mv.repository;

import br.com.mv.model.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica,String> {
}
