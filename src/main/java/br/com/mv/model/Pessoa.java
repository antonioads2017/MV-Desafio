package br.com.mv.model;

import br.com.mv.model.enums.TipoPessoa;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipo;
    @Column(nullable = false)
    private Date dataCadastro;
    @Column(nullable = true)
    private Date dataAtualizacao;
    @Column(unique = true)
    private String email;
    private String contato;
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;

    @OneToOne(mappedBy = "pessoa")
    private PessoaFisica pessoaFisica;

    @OneToOne(mappedBy = "pessoa")
    private PessoaJuridica pessoaJuridica;

    @OneToMany(mappedBy = "cliente")
    private List<Conta> contas;

}
