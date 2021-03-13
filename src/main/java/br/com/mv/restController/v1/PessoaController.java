package br.com.mv.restController.v1;

import br.com.mv.model.Pessoa;
import br.com.mv.service.PessoaService;
import br.com.mv.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/pessoa")
public class PessoaController {

    @Autowired
    private TestService testService;

    @Autowired
    private PessoaService pessoaService;

    //Deve executar esse path para alimentar o banco com pessoas de todoo tipo
    @PostMapping("/createPeoples")
    public ResponseEntity<Object> createPeoples (){
        testService.createClientX();
        testService.createClientY();
        testService.createCompany();
        return ResponseEntity.ok().build();
    }

    // Esse path é responsavel por trazer o relatorio de saldo de um cliente, com todas as contas e respectivos saldo
    @GetMapping( "cliente/cbr/{id}")
    public ResponseEntity<String> customerBalanceReport (@PathVariable("id") int id_cliente){
        String relatorio = pessoaService.customerBalanceReport(id_cliente);
        return ResponseEntity.ok(relatorio);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save (@RequestBody Pessoa pessoa){
        if (pessoa != null) {
            pessoaService.save(pessoa);
            return ResponseEntity.ok(pessoa);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Erro ao salvar");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Pessoa> get(@PathVariable("id") int id){
        Pessoa pessoa = pessoaService.getPessoa(id);
        return pessoa!=null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
    }



}
