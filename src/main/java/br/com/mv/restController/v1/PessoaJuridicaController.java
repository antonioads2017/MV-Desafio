package br.com.mv.restController.v1;

import br.com.mv.exception.ResourceExists;
import br.com.mv.model.Conta;
import br.com.mv.model.Pessoa;
import br.com.mv.service.ContaService;
import br.com.mv.service.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/juridic")
public class PessoaJuridicaController {


    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @Autowired
    private ContaService contaService;

    @PostMapping ("/empresa/{cnpj}/rClients")
    public ResponseEntity<Object> registerClients (@PathVariable("cnpj") String cnpj, @RequestParam("clientDoc") String clientDoc){
            pessoaJuridicaService.registerClient(clientDoc,cnpj);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rlc/{cnpj}")
    public ResponseEntity<String> reportlistClients (@PathVariable("cnpj") String cnpj){
        String report = "Relatorio de Saldos dos Clientes: \n";
        List<Pessoa> clients = pessoaJuridicaService.listarClientes(cnpj);
        for (Pessoa client: clients){
            report+="Cliente "+client.getNome()+" desde "+client.getDataCadastro();
            List<Conta> contas = contaService.accountPerClient(client.getId());
            for (Conta conta: contas){
                report+= "Conta "+conta.getNumero()+" com Saldo em "+new Date(System.currentTimeMillis())+" de: "+conta.getSaldoAtual()+"\n";
            }
        }
        return ResponseEntity.ok(report);
    }

}
