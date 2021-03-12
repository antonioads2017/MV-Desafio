package br.com.mv.service;

import br.com.mv.exception.ResourceNotFoundException;
import br.com.mv.model.ClienteJuridica;
import br.com.mv.repository.ClienteJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteJuridicaService {

    @Autowired
    private ClienteJuridicaRepository repository;


    public ClienteJuridica getClienteJuridica (int id){
        ClienteJuridica clienteJuridica = repository.findById(id).get();

        if(clienteJuridica!=null){
            return clienteJuridica;
        }else{
            throw new ResourceNotFoundException("Cliente pessoa juridica nao encontrado");
        }

    }

    public List<ClienteJuridica> list (){
        List<ClienteJuridica> clienteJuridicas = repository.findAll();
        if (clienteJuridicas.isEmpty()){
            throw new ResourceNotFoundException("Lista de Clientes pessoas Juridicas vazia ");
        }else {
            return clienteJuridicas;
        }
    }

    public void save (ClienteJuridica clienteJuridica){
        if(repository.findById(clienteJuridica.getId())==null){
            repository.save(clienteJuridica);
        }
    }
    public void update (ClienteJuridica clienteJuridica){
        if(repository.findById(clienteJuridica.getId())!=null){
            repository.save(clienteJuridica);
        }else{
            throw new ResourceNotFoundException("Cliente pessoa juridica nao encontrado para editar");
        }
    }







}
