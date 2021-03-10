package br.com.mv.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteFisica extends Cliente {

    private String cpf;
    private Date dNascimento;

}
