package br.com.mv.service;

import br.com.mv.exception.ResourceExists;
import br.com.mv.exception.ResourceNotFoundException;
import br.com.mv.model.Conta;
import br.com.mv.model.Pessoa;
import br.com.mv.model.PessoaJuridica;
import br.com.mv.repository.ContaRepository;
import br.com.mv.repository.PessoaJuridicaRepository;
import br.com.mv.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PessoaJuridicaService {


    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ContaRepository contaRepository;

    public PessoaJuridica getPessoaJuridica (String cnpj){
        PessoaJuridica pessoaJuridica = pessoaJuridicaRepository.findById(cnpj).get();
        if(pessoaJuridica!=null){
            return pessoaJuridica;
        }else{
            throw new ResourceNotFoundException("Pessoa Juridica nao encontrado");
        }
    }


    public void registerClient(int id, String cnpjEmpresa) {
        PessoaJuridica empresa = pessoaJuridicaRepository.findById(cnpjEmpresa).get();
        List<Pessoa> clients = pessoaJuridicaRepository.findClients(cnpjEmpresa);
        Pessoa client = pessoaRepository.findById(id).get();
        if(!clients.contains(client)){
            clients.add(client);
            empresa.setClientes(clients);
            pessoaJuridicaRepository.save(empresa);
        }
    }

    public List<Pessoa> listarClientes (String cnpj){
        List<Pessoa> clients = pessoaJuridicaRepository.findClients(cnpj);
        return clients;
    }

    public String reportlistClientsPerCompany (String cnpj){
        String report = "Relatorio de Saldos dos Clientes: \n";
        List<Pessoa> clients = pessoaJuridicaRepository.findClients(cnpj);
        for (Pessoa client: clients){
            report+="Cliente "+client.getNome()+" desde "+client.getDataCadastro();
            List<Conta> contas = contaRepository.accountsPerClient(client.getId());
            for (Conta conta: contas){
                report+= "Conta "+conta.getNumero()+" com Saldo em "+new Date(System.currentTimeMillis())+" de: "+conta.getSaldoAtual()+"\n";
            }
        }
        return report;
    }




}
