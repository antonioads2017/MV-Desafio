package br.com.mv.service;

import br.com.mv.exception.ResourceNotFoundException;
import br.com.mv.model.Conta;
import br.com.mv.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;


    public Conta getConta (String numero){
        Conta Conta = repository.findById(numero).get();

        if(Conta!=null){
            return Conta;
        }else{
            throw new ResourceNotFoundException("COnta nao encontrado");
        }

    }

    public List<Conta> list (){
        List<Conta> Contas = repository.findAll();
        if (Contas.isEmpty()){
            throw new ResourceNotFoundException("Lista de Contas vazia ");
        }else {
            return Contas;
        }
    }

    public void save (Conta Conta){
        if(repository.findById(Conta.getNumero())==null){
            repository.save(Conta);
        }
    }
    public void update (Conta Conta){
        if(repository.findById(Conta.getNumero())!=null){
            repository.save(Conta);
        }else{
            throw new ResourceNotFoundException("Conta nao encontrado para editar");
        }
    }







}
