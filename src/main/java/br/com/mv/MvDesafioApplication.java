package br.com.mv;

import br.com.mv.model.Conta;
import br.com.mv.model.Endereco;
import br.com.mv.model.Pessoa;
import br.com.mv.model.PessoaFisica;
import br.com.mv.model.enums.TipoPessoa;
import br.com.mv.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class MvDesafioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvDesafioApplication.class, args);
    }

}
