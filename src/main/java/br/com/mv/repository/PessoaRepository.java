package br.com.mv.repository;

import br.com.mv.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {
}
