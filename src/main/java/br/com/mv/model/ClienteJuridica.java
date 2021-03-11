package br.com.mv.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ClienteJuridica extends Cliente {

    @Column(unique = true)
    private String cnpj;
    @Column(nullable = false)
    private String nomeFantasia;
    @Column(nullable = false)
    private String nomeEmpresarial;



}
