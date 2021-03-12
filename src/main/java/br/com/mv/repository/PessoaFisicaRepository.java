package br.com.mv.repository;

import br.com.mv.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica,String> {
}
