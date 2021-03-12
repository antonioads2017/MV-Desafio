package br.com.mv.model;

import br.com.mv.model.enums.TipoCliente;
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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @Enumerated
    private TipoCliente tipo;
    @Column(nullable = false)
    private Date dataCadastro;
    @Column(nullable = true)
    private Date dataAtualizacao;
    @Column(unique = true)
    private String email;
    private String contato;
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "cliente")
    private List<Conta> contas;

}
