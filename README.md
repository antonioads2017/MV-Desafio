# MV Desafio Desenvolvedor Backend Java
## CÉLULA FINANCEIRO E CONTROLADORIA

#### INSTRUCOES DE USO LOGO ABAIXO!

Projeto bem simples para controlar as receitas e as despesas de vários clientes, a empresa (XPTO)
precisa controlar as receitas e as despesas de diversos clientes (X, Y, Z) que podem ser PJ ou PF.

Além de manter os clientes (Y, X, Z) é preciso fazer o controle da receita da empresa (XPTO)
com relação as movimentações dos clientes (X, Y, Z).

#### Padrão utilizado no projeto foi MVC(Model, View, Controller);

Utilizei praticas de quando eu paguei a cadeira de Aplicações para Web e Desenvolvimento de Aplicações Corporativas, aprendi a orgazinar as estrutuas basicas de um sistema e aos poucos criando a logica para melhor atender os requisitos, o tempo nao deixou concluir todos os relatorios, com DTOS, testes unitarios, coloquei um pouco de cada para entender um pouco da forma que codifico, garanto que ainda tem muito pra sair da mente desse mero desenvolvedor, espero que gostem!

#### Framework Spring Boot
#### IDE: Intellij 2020.3
#### Banco de Dados: Postgresql 9 usando JPA para mapeamento.
#### Junit para testes
#### Consultas e funçoes SQL usados nos repositorys.
#### Lombok para melhor codificação dos models
#### Sistema Operacional Linux Mint 20


### **Instrucoes para iniciar o Projeto:**
##### Utilizar **PostMan** ou app semelhante para testar os endpoints! 
##### Sempre iniciando o path com http://localhost:8090/

* Criar banco no Posgresql de acordo com application.properties dentro de resources
* Abrir projeto na IDE e execuat MvDesafioApplication;
* Executar o path v1/pessoa/createPeoples para alimentar o banco com tres entidades de pessoa;
* Executar o path v1/juridic/empresa/{cnpj}/rCLients para registrar dois clientes numa empresa;

### Com isso o banco ta alimentado para gerar os dois relatorios principais:

#### Relatorio de Saldo de um Cliente - v1/pessoa/cliente/cbr/{id} onde id é a chave do cliente, sera exibido assim:

Relatorio de Saldo do Cliente X
Cliente desde 2021-03-12 21:16:43.025
Enderecos:Rua dos Alfeneiros, 204, Bancarios, Joao pessoa, Paraiba, 589000-000
Movimentcoes por Credito: 1
Movimentcoes por Debito: 0
Total das movimentacoes: 1
Valor pago pelas movimentacoes: 1
Saldo Inicial:2000.0
Saldo Atual: 1999.0

#### Relatorio de Todos os clientes de uma empresa - v1/juridic/rlc/{cnpj}, sera exibido assim:

Relatorio de Saldos dos Clientes: 
Cliente X desde 2021-03-12 21:16:43.025Conta 22093-0 com Saldo em Fri Mar 12 21:45:03 BRT 2021 de: 1999.0

##### Utilizei a saida em JSON e no Services gerando em String os relatorios, existe formas como utilizar DTOŚ, mais ai o tempo nao deixou eu concluir tudo.

