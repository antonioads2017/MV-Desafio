package br.com.mv.service;

import br.com.mv.exception.ResourceNotFoundException;
import br.com.mv.model.Conta;
import br.com.mv.model.Movimentacao;
import br.com.mv.model.enums.TIpoMovimentacao;
import br.com.mv.repository.ContaRepository;
import br.com.mv.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private ContaService contaService;



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

    public void throwMovimentation (Movimentacao movimentacao){
            Long numMovimentacoes = repository.totalMovimentacion(movimentacao.getConta().getNumero());
            if(numMovimentacoes<=10){
                movimentacao.setTaxa(1.0F);
            }else if (numMovimentacoes<=20&&numMovimentacoes>10){
                movimentacao.setTaxa(0.75F);
            }else {
                movimentacao.setTaxa(1.0F);
            }
            Conta conta = contaService.getConta(movimentacao.getConta().getNumero());

            if(movimentacao.getTipo()== TIpoMovimentacao.CREDITO){
                if(numMovimentacoes==0){
                    conta.setSaldoAtual(movimentacao.getValor()-movimentacao.getTaxa());
                }
                conta.setSaldoAtual((conta.getSaldoAtual()+movimentacao.getValor())-movimentacao.getTaxa());
            }else{
                conta.setSaldoAtual((conta.getSaldoAtual()-movimentacao.getValor())-movimentacao.getTaxa());
            }
            repository.save(movimentacao);
            contaService.update(conta);
        }

}
