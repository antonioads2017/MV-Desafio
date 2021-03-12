package br.com.mv.repository;

import br.com.mv.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnderecoRepository extends JpaRepository <Endereco,Integer> {

    @Query("SELECT e FROM Endereco e WHERE e.cliente.id=:id_people")
    List<Endereco> findEnderecoPerPeople (@Param("id_people") int id);
}
