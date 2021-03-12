package br.com.mv.service;

import br.com.mv.exception.ResourceNotFoundException;
import br.com.mv.model.Endereco;
import br.com.mv.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    
    private EnderecoRepository repository;

    public Endereco getEndereco (int id){
        Endereco Endereco = repository.findById(id).get();

        if(Endereco!=null){
            return Endereco;
        }else{
            throw new ResourceNotFoundException("Endereço nao encontrado");
        }

    }

    public List<Endereco> list (){
        List<Endereco> Enderecos = repository.findAll();
        if (Enderecos.isEmpty()){
            throw new ResourceNotFoundException("Lista de endereços vazia ");
        }else {
            return Enderecos;
        }
    }

    public void save (Endereco Endereco){
        if(repository.findById(Endereco.getId())==null){
            repository.save(Endereco);
        }
    }
    public void update (Endereco Endereco){
        if(repository.findById(Endereco.getId())!=null){
            repository.save(Endereco);
        }else{
            throw new ResourceNotFoundException("Endereço nao encontrado para editar");
        }
    }
    
}
