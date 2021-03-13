package br.com.mv.service;

import antlr.collections.impl.LList;
import br.com.mv.model.*;
import br.com.mv.model.enums.TIpoMovimentacao;
import br.com.mv.model.enums.TipoPessoa;
import br.com.mv.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TestService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public void createClientX(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


        Pessoa pessoa = new Pessoa();
        pessoa.setId(10);
        pessoa.setNome("X");
        pessoa.setTipo(TipoPessoa.FISICA);
        pessoa.setDataCadastro(new Date(System.currentTimeMillis()));
        pessoa.setEmail("x@xpto.com.br");
        pessoa.setContato("83-999000000");
        pessoaRepository.save(pessoa);


        Endereco endereco1 = new Endereco();
        endereco1.setCEP("589000-000");
        endereco1.setRua("Rua dos Alfeneiros");
        endereco1.setNumero(204);
        endereco1.setCidade("Joao pessoa");
        endereco1.setBairro("Bancarios");
        endereco1.setComplemento("apto26");
        endereco1.setEstado("Paraiba");
        endereco1.setCliente(pessoa);

        enderecoRepository.save(endereco1);

        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setCpf("111-111-111-01");
        try {
            pessoaFisica.setDNascimento(formato.parse("28/04/1998"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        pessoaFisica.setPessoa(pessoa);
        pessoaFisicaRepository.save(pessoaFisica);


        Conta conta1 = new Conta();
        conta1.setNumero("22093-0");
        conta1.setDataCadastro(new Date(System.currentTimeMillis()));
        conta1.setSaldoInicial(2000.00F);
        conta1.setSaldoAtual(conta1.getSaldoInicial());
        conta1.setCliente(pessoa);

        contaRepository.save(conta1);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDataMovimentacao(new Date(System.currentTimeMillis()));
        movimentacao.setTipo(TIpoMovimentacao.CREDITO);
        movimentacao.setValor(conta1.getSaldoAtual());
        movimentacao.setConta(conta1);

        Long numMovimentacoes = movimentacaoRepository.totalMovimentacion(movimentacao.getConta().getNumero());
        if(numMovimentacoes<=10){
            movimentacao.setTaxa(1.0F);
        }else if (numMovimentacoes<=20&&numMovimentacoes>10){
            movimentacao.setTaxa(0.75F);
        }else {
            movimentacao.setTaxa(1.0F);
        }

        //Como aqui é o primeiro movimento da conta, so desconta a taxa
        if(movimentacao.getTipo()== TIpoMovimentacao.CREDITO){
            conta1.setSaldoAtual((conta1.getSaldoAtual()-movimentacao.getTaxa()));
        }else{
            conta1.setSaldoAtual((conta1.getSaldoAtual()-movimentacao.getValor())-movimentacao.getTaxa());
        }
        movimentacaoRepository.save(movimentacao);
        contaRepository.save(conta1);
    }

    public void createClientY(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


        Pessoa pessoa = new Pessoa();
        pessoa.setId(20);
        pessoa.setNome("Y");
        pessoa.setTipo(TipoPessoa.FISICA);
        pessoa.setDataCadastro(new Date(System.currentTimeMillis()));
        pessoa.setEmail("y@xpto.com.br");
        pessoa.setContato("88-888000000");
        pessoaRepository.save(pessoa);


        Endereco endereco1 = new Endereco();
        endereco1.setCEP("58970-000");
        endereco1.setRua("Avenida Solon");
        endereco1.setNumero(204);
        endereco1.setCidade("Conceicao");
        endereco1.setBairro("Centro");
        endereco1.setComplemento("casa");
        endereco1.setEstado("Paraiba");
        endereco1.setCliente(pessoa);

        enderecoRepository.save(endereco1);

        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setCpf("222-222-222-01");
        try {
            pessoaFisica.setDNascimento(formato.parse("22/02/1980"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        pessoaFisica.setPessoa(pessoa);
        pessoaFisicaRepository.save(pessoaFisica);


        Conta conta1 = new Conta();
        conta1.setNumero("2808-0");
        conta1.setDataCadastro(new Date(System.currentTimeMillis()));
        conta1.setSaldoInicial(3000.00F);
        conta1.setSaldoAtual(conta1.getSaldoInicial());
        conta1.setCliente(pessoa);

        contaRepository.save(conta1);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDataMovimentacao(new Date(System.currentTimeMillis()));
        movimentacao.setTipo(TIpoMovimentacao.CREDITO);
        movimentacao.setValor(conta1.getSaldoAtual());
        movimentacao.setConta(conta1);

        Long numMovimentacoes = movimentacaoRepository.totalMovimentacion(movimentacao.getConta().getNumero());
        if(numMovimentacoes<=10){
            movimentacao.setTaxa(1.0F);
        }else if (numMovimentacoes<=20&&numMovimentacoes>10){
            movimentacao.setTaxa(0.75F);
        }else {
            movimentacao.setTaxa(1.0F);
        }

        //Como aqui é o primeiro movimento da conta, so desconta a taxa
        if(movimentacao.getTipo()== TIpoMovimentacao.CREDITO){
            conta1.setSaldoAtual((conta1.getSaldoAtual()-movimentacao.getTaxa()));
        }else{
            conta1.setSaldoAtual((conta1.getSaldoAtual()-movimentacao.getValor())-movimentacao.getTaxa());
        }
        movimentacaoRepository.save(movimentacao);
        contaRepository.save(conta1);
    }


    public void createCompany (){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


        Pessoa pessoa = new Pessoa();
        pessoa.setId(30);
        pessoa.setNome("XPTO");
        pessoa.setTipo(TipoPessoa.JURIDICA);
        pessoa.setDataCadastro(new Date(System.currentTimeMillis()));
        pessoa.setEmail("xpto@xpto.com.br");
        pessoa.setContato("11-777000000");
        pessoaRepository.save(pessoa);


        Endereco endereco1 = new Endereco();
        endereco1.setCEP("11250-000");
        endereco1.setRua("Avenida Brasil");
        endereco1.setNumero(1050);
        endereco1.setCidade("Rio de Janeiro");
        endereco1.setBairro("Centro");
        endereco1.setComplemento("andar 18 ");
        endereco1.setEstado("Rio de Janeiro");
        endereco1.setCliente(pessoa);

        enderecoRepository.save(endereco1);

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCnpj("01321303000179");
        pessoaJuridica.setNomeFantasia("Xpress Solutions");
        pessoaJuridica.setNomeEmpresarial("MV Company");
        pessoaJuridica.setPessoa(pessoa);

        pessoaJuridicaRepository.save(pessoaJuridica);




    }

}
