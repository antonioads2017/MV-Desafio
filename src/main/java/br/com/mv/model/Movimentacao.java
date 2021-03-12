package br.com.mv.model;

import br.com.mv.model.enums.TIpoMovimentacao;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Movimentacao {

    @Id
    @GeneratedValue
    private Integer protocolo;
    @Column(nullable = false)
    private Date dataMovimentacao;
    @Enumerated
    private TIpoMovimentacao tipo;
    @Column(nullable = false)
    private Float valor;
    @Column(nullable = false)
    private Float taxa;

    @ManyToOne
    @JoinColumn(name = "conta_numero")
    private Conta conta;




}
