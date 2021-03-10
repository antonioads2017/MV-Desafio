package br.com.mv.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {

    private int id;
    private String nome;
    private Date dataCadastro;
    private Date dataAtualizacao;
    private String email;
    private String contato;
    private Endereco endereco;


}
