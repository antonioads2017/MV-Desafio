package br.com.mv.service;

import br.com.mv.exception.ResourceNotFoundException;
import br.com.mv.model.Conta;
import br.com.mv.model.Endereco;
import br.com.mv.model.Pessoa;
import br.com.mv.model.PessoaFisica;
import br.com.mv.model.enums.TipoPessoa;
import br.com.mv.repository.PessoaRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;


    public Pessoa getPessoa (int id){
        Pessoa Pessoa = repository.findById(id).get();

        if(Pessoa!=null){
            return Pessoa;
        }else{
            throw new ResourceNotFoundException("Pessoa nao encontrado");
        }

    }
    public List<Pessoa> list (){
        List<Pessoa> Pessoas = repository.findAll();
        if (Pessoas.isEmpty()){
            throw new ResourceNotFoundException("Lista de Pessoas vazia ");
        }else {
            return Pessoas;
        }
    }

    public void save (Pessoa Pessoa){
        if(repository.findById(Pessoa.getId())==null){
            repository.save(Pessoa);
        }
    }
    public void update (Pessoa Pessoa){
        if(repository.findById(Pessoa.getId())!=null){
            repository.save(Pessoa);
        }else{
            throw new ResourceNotFoundException("Pessoa nao encontrado para editar");
        }
    }







}
