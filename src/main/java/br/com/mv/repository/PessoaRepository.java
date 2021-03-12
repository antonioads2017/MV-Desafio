package br.com.mv.repository;

import br.com.mv.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {

    @Query("SELECT p FROM Pessoa p WHERE p.pessoaFisica.cpf=:numero OR p.pessoaJuridica.pessoa=:numero")
    Pessoa getPerCPFOrCNPJ (@Param("numero") String cpfOrCnpj);


}
