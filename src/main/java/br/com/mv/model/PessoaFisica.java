package br.com.mv.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PessoaFisica {

    @Id
    private String cpf;
    @Column(unique = true)
    private Date dNascimento;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;




}
