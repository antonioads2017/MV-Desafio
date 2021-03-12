package br.com.mv.repository;

import br.com.mv.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository <Endereco,Integer> {
}
