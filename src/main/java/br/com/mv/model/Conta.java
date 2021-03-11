package br.com.mv.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Conta {

    @Column(nullable = false)
    private String agencia;
    @Id
    private String numero;
    @Column(nullable = false)
    private Date dataCadastro;
    @Column(nullable = false)
    private Float saldoInicial;
    @Column(nullable = false)
    private Float saldoAtual;

    @OneToMany
    private List<Movimentacao> movimentacoes;



}
