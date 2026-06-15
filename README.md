# Aplicação de Geolocalização de Assistências Técnicas - Agat 

Projeto aplicado para localizar assistências técnicas na região metropolitana do recife, onde o usuário vai conseguir identificar a loja mais próxima de sua casa, possuindo o google maps no sistema

## Conhecimentos adquiridos nesse projeto 

Integração de APIS - (Interface de Programação de Aplicação), onde foi feito uma arquitetura Monólito para receber na otimização da velocidade 
entre as requisições feitas pelo comando dos usuários. As APIS foram autenticadas através de Tokens que distribui por camadas de segurança 
a geração dos dados por rotas definidas em entidades. Essas informações são geradas pelo SGDB - Sistema de Gerenciamentos de banco de dados, vinda do 
pacote Controller que é responsavel por controlar o fluxo de cadastro, alteração, listagem e exclusão dos dados. Esse pacote vai esta atrelado as camadas
dos services que vai obter a finalidade de cadastrar, alterar, listar e excuir essas informações das tabelas e atributos vindas do banco e vai passar no 
pacote model que é responsavel por criar as entidades para constituir esses resultados de informações. 

Foi usado para o projeto o Dto que obtém a ideia de consistir basicamente, 
o agrupamento de conjunto de atributos em varias classes simples de forma a otimizar a comunicação. 

## Dificuldades adquiridos nesse projeto 

1 - Como pegar dados das entidades Endereços, Assistências, Telefones e Usuarios para listar as informações

2 - Como mostrar dados dos atributos de Endereços, Assistências, Telefones e Usuarios em uma tela de visualização na web 

3 - Dificuldade em saber listar por id, dentro do Spring Boot os dados que vêm das entidade Orçamento com os atributos Assistências e Usuários. 

5 - Orientação a objeção entre os pacotes do Spring boot, sendo realizado um dto 

7 - Relacionamento de Tabelas - um para muitos  

## Tecnologias Utilizadas 

-[Java](https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR) 

-[JDBC](https://www.oracle.com/br/database/technologies/appdev/jdbc.html) 

-[Mysql](https://www.mysql.com/)

-[Jsp](https://www.ibm.com/docs/pt-br/rsas/7.5.0?topic=files-javaserver-pages-jsp-technology) 

-[Spring Boot](https://spring.io/projects/spring-boot) 

## Depedências do Spring Boot 

-[Lombok](https://imasters.com.br/back-end/projeto-lombok-escrevendo-menos-codigo-em-java) 

-[Spring Dev Tools](https://www.javatpoint.com/spring-boot-devtools) 

-[Maven](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)

-[Versão 17](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)

-[Spring Boot Start Web](https://www.javatpoint.com/spring-boot-starter-web) 

## Rotas do Spring Boot - Sistema Acadêmico - Acad Cursos

Precisa adicionar essas rotas no Postman, Insomnia ou Navegadores para ver os dados do back - end, vindas pelo banco de dados.

Entidade Endereço - localhost:8050/address 

Entidade Telefone - localhost:8050/telefone

Entidade Usuario - localhost:8050/user

Entidade Assistência - localhost:8050/assistence 

## Baixar e visualizar o Projeto 

  ```bash 
  
  $ fazer um git clone do projeto pelo terminal, através - https://github.com/ghdss-dev/agat.git
  
  $ Obter o Eclipse ou intellij instalado na sua maquina
  
  $ Ter Instalado e configurado o My Sql Workbench 
  
  $ Obter Java Jre e Jdk na versão 17.0 para ver o funcionamento do projeto e Testar ele
  
  $ Obter sua conexão ativa no Banco de dados como servidor local 
  
  $ Possuir um programa Postman ou Insmonia para copiar e colar as rotas das entidades e ver o crud completo
 
```

## Como executar o projeto no Spring Boot 

## Back end
Pré-requisitos: Java 17

```bash
# clonar repositório
git clone https://github.com/ghdss-dev/agat.git

# entrar na pasta do projeto wco
cd agat
cd back-end 

# executar o projeto
./mvnw spring-boot:run
```

