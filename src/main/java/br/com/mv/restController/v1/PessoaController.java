package br.com.mv.restController.v1;

import br.com.mv.service.PessoaService;
import br.com.mv.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/pessoa")
public class PessoaController {

    @Autowired
    private TestService testService;

    @GetMapping("/criarX")
    public ResponseEntity<Object> createClienteX (){
        testService.createClientX();
        return ResponseEntity.ok().build();
    }

}
