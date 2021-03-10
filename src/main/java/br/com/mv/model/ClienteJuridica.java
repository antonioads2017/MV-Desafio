package br.com.mv.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteJuridica extends Cliente {

    private String cnpj;
    private String nomeFantasia;
    private String nomeEmpresarial;



}
