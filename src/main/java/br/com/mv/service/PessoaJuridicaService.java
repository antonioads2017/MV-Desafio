package br.com.mv.service;

import br.com.mv.exception.ResourceNotFoundException;
import br.com.mv.model.Conta;
import br.com.mv.model.Pessoa;
import br.com.mv.model.PessoaJuridica;
import br.com.mv.repository.ContaRepository;
import br.com.mv.repository.PessoaJuridicaRepository;
import br.com.mv.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class PessoaJuridicaService {


    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    private PessoaService pessoaService;

    public PessoaJuridica getPessoaJuridica (String cnpj){
        PessoaJuridica pessoaJuridica = pessoaJuridicaRepository.findById(cnpj).get();
        if(pessoaJuridica!=null){
            return pessoaJuridica;
        }else{
            throw new ResourceNotFoundException("Pessoa Juridica nao encontrado");
        }
    }


    public void registerClient(int id, String cnpjEmpresa){
        Pessoa client = pessoaService.getPessoa(id);
        PessoaJuridica empresa = getPessoaJuridica(cnpjEmpresa);
        empresa.getClientes().add(client);
    }



}
