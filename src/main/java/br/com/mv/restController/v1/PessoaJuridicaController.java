package br.com.mv.restController.v1;


import br.com.mv.service.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("v1/juridic")
public class PessoaJuridicaController {


    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    //Path responsavel para registrar clientes na empresa determinanda
    @PostMapping ("/empresa/{cnpj}/rClients")
    public ResponseEntity<Object> registerClients (@PathVariable("cnpj") String cnpj, @RequestParam("client_id") int client_id){
            pessoaJuridicaService.registerClient(client_id,cnpj);
        return ResponseEntity.ok().build();
    }

    //Path para relatorio de todos os clientes de uma empresa
    @GetMapping("/rlc/{cnpj}")
    public ResponseEntity<String> reportlistClients (@PathVariable("cnpj") String cnpj){
        return ResponseEntity.ok(pessoaJuridicaService.reportlistClientsPerCompany(cnpj));
    }

}
