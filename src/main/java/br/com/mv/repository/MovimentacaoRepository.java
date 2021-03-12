package br.com.mv.repository;

import br.com.mv.model.Movimentacao;
import br.com.mv.model.enums.TIpoMovimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao,Integer> {

    @Query("SELECT count(*) FROM Movimentacao m WHERE m.conta= :numero AND m.tipo = :tipo")
    Long countMovimentacionPerType (@Param("numero") String numeroConta, @Param("tipo")TIpoMovimentacao tipo);

    @Query("SELECT count(*) FROM Movimentacao m WHERE m.conta= :numero")
    Long totalMovimentacion (@Param("numero") String numeroConta);

    @Query("SELECT sum(m.taxa) FROM Movimentacao m WHERE m.conta=:numero")
    Long sumTotalMovimentacion (@Param("numero") String numeroConta);


}
