package br.com.mv.repository;

import br.com.mv.model.Movimentacao;
import br.com.mv.model.enums.TIpoMovimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao,Integer> {

    @Query("SELECT count(m) FROM Movimentacao m WHERE m.conta.numero= :numero AND m.tipo = :tipo")
    Long countMovimentacionPerType (@Param("numero") String numeroConta, @Param("tipo")TIpoMovimentacao tipo);

    @Query("SELECT count(m) FROM Movimentacao m WHERE m.conta.numero= :numero")
    Long totalMovimentacion (@Param("numero") String numeroConta);

    @Query("SELECT sum(m.taxa) FROM Movimentacao m WHERE m.conta.numero=:numero")
    Long sumTotalMovimentacion (@Param("numero") String numeroConta);

    @Query("SELECT m FROM Movimentacao m WHERE m.conta.numero=:numero")
    List<Movimentacao> movimentationsPerAccount(@Param("numero") String numeroConta);

}
