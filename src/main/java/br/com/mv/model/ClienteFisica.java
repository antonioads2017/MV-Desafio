package br.com.mv.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ClienteFisica extends Cliente {

    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private Date dNascimento;


}
