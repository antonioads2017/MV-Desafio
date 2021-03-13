package br.com.mv.service;

import br.com.mv.exception.ResourceNotFoundException;
import br.com.mv.model.Conta;
import br.com.mv.model.Endereco;
import br.com.mv.model.Pessoa;
import br.com.mv.model.enums.TIpoMovimentacao;
import br.com.mv.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public Pessoa getPessoa (int id){
        Pessoa pessoa = repository.findById(id).get();

        if(pessoa!=null){
            return pessoa;
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

    public String customerBalanceReport (int id_cliente){
        Pessoa cliente = pessoaRepository.findById(id_cliente).get();
        String relatorio = "Relatorio de Saldo do Cliente "+cliente.getNome()+"\nCliente desde "+cliente.getDataCadastro().toString()+"\nEnderecos:";
        List<Endereco> enderecos = enderecoRepository.findEnderecoPerPeople(id_cliente);
        for (Endereco endereco: enderecos){
            relatorio+=endereco.getRua()+", "+endereco.getNumero()+", "+endereco.getBairro()+", "+endereco.getCidade()+", "+endereco.getEstado()+", "+endereco.getCEP()+"\n";
        }
        List<Conta> contas = contaRepository.accountsPerClient(id_cliente);
        for(Conta conta : contas){
            Long movimentationsCredit = movimentacaoRepository.countMovimentacionPerType(conta.getNumero(), TIpoMovimentacao.CREDITO);
            Long movimentationsDebit = movimentacaoRepository.countMovimentacionPerType(conta.getNumero(), TIpoMovimentacao.DEBITO);
            Long totalMovimentations = movimentacaoRepository.totalMovimentacion(conta.getNumero());
            Long sumMovimentations = movimentacaoRepository.sumTotalMovimentacion(conta.getNumero());

            relatorio+="Movimentcoes por Credito: "+movimentationsCredit;
            relatorio+="\nMovimentcoes por Debito: "+movimentationsDebit;
            relatorio+="\nTotal das movimentacoes: "+totalMovimentations;
            relatorio+="\nValor pago pelas movimentacoes: "+sumMovimentations;
            relatorio+="\nSaldo Inicial:"+conta.getSaldoInicial();
            relatorio+="\nSaldo Atual: "+conta.getSaldoAtual();

        }
        return relatorio;
    }







}
