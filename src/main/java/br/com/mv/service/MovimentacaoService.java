package br.com.mv.service;

import br.com.mv.exception.ResourceNotFoundException;
import br.com.mv.model.Movimentacao;
import br.com.mv.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository repository;


    public Movimentacao getMovimentacao (int protocolo){
        Movimentacao Movimentacao = repository.findById(protocolo).get();

        if(Movimentacao!=null){
            return Movimentacao;
        }else{
            throw new ResourceNotFoundException("Movimentacao com protocolo "+protocolo+ "nao encontrado");
        }

    }

    public List<Movimentacao> list (){
        List<Movimentacao> Movimentacaos = repository.findAll();
        if (Movimentacaos.isEmpty()){
            throw new ResourceNotFoundException("Lista de protocolos vazia ");
        }else {
            return Movimentacaos;
        }
    }

    public void save (Movimentacao Movimentacao){
        if(repository.findById(Movimentacao.getProtocolo())==null){
            repository.save(Movimentacao);
        }
    }
    public void update (Movimentacao Movimentacao){
        if(repository.findById(Movimentacao.getProtocolo())!=null){
            repository.save(Movimentacao);
        }else{
            throw new ResourceNotFoundException("Movimentacao com protocolo "+Movimentacao.getProtocolo()+"nao encontrado para editar");
        }
    }







}
