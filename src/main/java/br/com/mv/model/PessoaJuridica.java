package br.com.mv.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PessoaJuridica  {

    @Id
    private String cnpj;
    @Column(nullable = false)
    private String nomeFantasia;
    @Column(nullable = false)
    private String nomeEmpresarial;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @OneToMany
    private List<Pessoa> clientes;



}
