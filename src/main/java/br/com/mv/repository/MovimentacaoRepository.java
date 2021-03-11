package br.com.mv.repository;

import br.com.mv.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao,Integer> {
}
