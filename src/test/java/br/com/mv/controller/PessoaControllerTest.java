package br.com.mv.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.mv.model.Pessoa;
import br.com.mv.model.PessoaFisica;
import br.com.mv.model.PessoaJuridica;
import br.com.mv.model.enums.TipoPessoa;
import br.com.mv.restController.v1.PessoaController;
import br.com.mv.service.PessoaJuridicaService;
import br.com.mv.service.PessoaService;
import br.com.mv.service.TestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import io.restassured.http.ContentType;

import java.util.ArrayList;
import java.util.Date;

@WebMvcTest
public class PessoaControllerTest {

    @Autowired
    private PessoaController pessoaController;

    @MockBean
    private PessoaService pessoaService;

    @MockBean
    private PessoaJuridicaService pessoaJuridicaService;

    @MockBean
    private TestService testService;

    @BeforeEach
    public void setup(){
        standaloneSetup(this.pessoaController);
    }

    @Test
    public void returnSucess_whenGetPeople(){
        when(this.pessoaService.getPessoa(10))
        .thenReturn(new Pessoa(10,"X", TipoPessoa.FISICA,new Date(System.currentTimeMillis()),null,  "x@xpto.com.br","83-999000000",new ArrayList<>(),new PessoaFisica(),new PessoaJuridica(),new ArrayList<>()));
        given()
            .accept(ContentType.JSON)
                .when()
        .get("v1/pessoa/get/{id}",10)
            .then()
                 .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void returnNoSucess_whenGetPeople (){
        when(this.pessoaService.getPessoa(40)).thenReturn(null);
        given()
                .accept(ContentType.JSON)
                .when()
                .get("v1/pessoa/get/{id}",40)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

}
