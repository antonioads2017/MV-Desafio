package br.com.mv.service;

import br.com.mv.exception.ResourceNotFoundException;
import br.com.mv.model.ClienteFisica;
import br.com.mv.repository.ClienteFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteFisicaService {

    @Autowired
    private ClienteFisicaRepository repository;


    public ClienteFisica getClienteFisica (int id){
        ClienteFisica clienteFisica = repository.findById(id).get();

        if(clienteFisica!=null){
            return clienteFisica;
        }else{
            throw new ResourceNotFoundException("Cliente pessoa física nao encontrado");
        }

    }

    public List<ClienteFisica> list (){
        List<ClienteFisica> clienteFisicas = repository.findAll();
        if (clienteFisicas.isEmpty()){
            throw new ResourceNotFoundException("Lista de Clientes pessoas fisicas vazia ");
        }else {
            return clienteFisicas;
        }
    }

    public void save (ClienteFisica clienteFisica){
        if(repository.findById(clienteFisica.getId())==null){
            repository.save(clienteFisica);
        }
    }
    public void update (ClienteFisica clienteFisica){
        if(repository.findById(clienteFisica.getId())!=null){
            repository.save(clienteFisica);
        }else{
            throw new ResourceNotFoundException("Cliente pessoa física nao encontrado para editar");
        }
    }







}
