package br.com.mv.service;

import antlr.collections.impl.LList;
import br.com.mv.model.Conta;
import br.com.mv.model.Endereco;
import br.com.mv.model.Pessoa;
import br.com.mv.model.PessoaFisica;
import br.com.mv.model.enums.TipoPessoa;
import br.com.mv.repository.ContaRepository;
import br.com.mv.repository.EnderecoRepository;
import br.com.mv.repository.PessoaFisicaRepository;
import br.com.mv.repository.PessoaRepository;
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

    public void createClientX(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


        Pessoa pessoa = new Pessoa();
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

    }

}
