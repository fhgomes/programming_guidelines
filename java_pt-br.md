
Estas as diretrizes de desenvolvimento de software que utilizo nos meus times e projetos


# Premissas:

1. Estas regras se aplicam a novos serviços e não se aplicam necessariamente a serviços legados que tem regras próprias
2. Gosto de trabalhar com CleanCode e SOLID no desenvolvimento e também no Code Review.
3. Isso nos diz que temos que estar olhando atentamente para um código explicativo e com responsabilidades distribuídas
4. Se um método ou lógica necessita de comentário para ser entendido, pode ser sinal de falta de legibilidade e design do mesmo  
5. O conceito de simples, básico, complexo é algo bem dinâmico quando falado em software 
6. Este deve ser um documento vivo que pode ser revisitado e incrementado a cada dia
7. Sempre com apoio de ferramentas de código como Sonar e SonarLint

# Java Guideline recomendado: 

https://google.github.io/styleguide/javaguide.html 

# Kotlin Guideline recomendado:  
https://developer.android.com/kotlin/style-guide 
ou Usar default do Intelij 

# Boas Práticas e regras de desenvolvimento:  

1. Todo código pode ser melhorado, devemos buscar constantemente evoluir
2. Todo código pode ser melhorado, devemos buscar constantemente evoluir
3. Ao executar esse item, sempre cuidar para não executar overenginering e respeitar o ritmo do projeto, as criticidades, etc. 
4. Realizar organização das classes e métodos 
5. Respeitar arquitetura e limites de camadas   Procure seguir os conceitos de Clean code   
6. Procure respeitar os princípios de SOLID 
7. Os projetos deverão ser desenvolvidos utilizando a configuração de codeStyle e checkStyle fornecidas no repositório de documentos oficiais ou .editorconfig no próprio projeto
8. Prefira o uso de parametrizações em profile do que parâmetros estáticos
9. Tenha cuidado e pense em concorrência caso utilize threads, filas, jobs, ou sistemas simultâneos
10. Quando houver mais de 4 parâmetros para construir uma classe, pode ser utilizado o padrão builder
11. Quando houver mais de 4 parâmetros para um método, avalie a refatoração ou utilização de um objeto com os parâmetros
12. Em casos de Constantes, Properties, Pom, Gradle, e similares,  manter organização por agrupamentos e por ordem alfabética.
    12.1. Exemplo, agrupar mensagens  por telas, ou por pacotes. 
    12.2. Exemplo, agrupar dependências do mesmo provider

# Imports: 
 
1. Seguindo a linha do google guideline: https://google.github.io/styleguide/javaguide.html#s3.3-import-statements
2. Deve-se evitar Wildcards como *
3. Primeiro os imports estáticos e depois os demais
4. Procurar agrupar por grupos conhecidos organizações ou frameworks ou assuntos 

# Comentários no código  

## Quando não inserir comentários: 

1. Não é necessário colocar comentários em classes ou métodos simples, básicos, ou de configuração de frameworks, exceto para casos que fujam da configuração default e necessite alguma explicação 
2. Não colocar comentário de @Author e outros gerados automaticamente por algumas IDEs, estes dados já são providos pelo gerenciador de código. 
3. Não deixar “código comentado”, remover. Se necessário tem o versionador para pesquisar 
4. Não adicionar comentários redundantes  
    4.1. Ex: adicionar o mesmo nome, mas em português  
    4.2. Ex: CarService -> /** Serviço que gerencia carros */   
5. Não use comentários em classes e métodos que já seguem a convenção da linguagem ou framework  
    5.1. Ex: SessionHTTPInterceptor – /** Um interceptador da sessão http  */ 

## Quando usar comentários: 

1. Documentar quando for algo específico de negócio 
2. Cálculos ou Formulas para que não fiquem perdidos sem sentido  
    2.1. Exceto contas e resultados simples. EX: 24*60 
3. Fluxos de código / negócio 
4. Quando o código é bastante complexo e não é possível reescrever/quebrar/refatorar ou dividir as responsabilidades 
5. Documentar quando o código (métodos públicos) for externalizado como LIB/FRAMEWORK 
6. Documentar Rest APIs (Swagger) 
7. Quando for um BFF não é necessária uma documentação ampla 
8. Utilizar as convenções de documentação das ferramentas (Swagger) 
9. Inserir comentário quando houver um comportamento que não é "comum/convenção" em implementações (ou que possa ferir algum princípio clean code / solid, mas que seja importante).  
    9.1. Ex: Não tratar um catch de uma exception  
    9.2. Ex: Tratar uma exception da mesma forma que o código normal  
    9.3. Ex: Fazer dois loops, ou vários if/else que seria substituível por um estrategy 
10. Inserir comentário quando houver uso/adaptação para um sistema externo  
    10.1. Ex: um if com retorno diferente do padrão para retornar um DTO quando for o sistema X pois o sistema X usa o DTO diferente  
    10.2. Ex: um mapeamento para XML quando o resto do sistema usa JSON 
11. Inserir comentário quando houver uso/adaptação devido a limitação tecnológica ou arquitetural  
    11.1. Ex: Quando, em um cenário comum um sistema Spring usaria RestTemplate mas não está utlizando por algum motivo, e usando uma implementaçao manual

# Clean Code  

1. Utilizar dos princípios do clean code e deixar atributos, variáveis, classes e métodos com nomes significativos 
2. Não deixe números e caracteres fixos e soltos no código, utilize constantes  
3. Cria classes de constantes caso não seja um único uso deste valor  
4. Verifique se já não existem classes de constantes  
5. Evite o uso de números mágicos  
    5.1. Ex: 
processar (567) ->  
CONST ID_DEFAULT_BATATA = 567  
 Processar (ID_DEFAULT_BATATA) 
6. Números como 0, 1, 2, 10, 100 não são necessariamente números mágicos. Muitas vezes vale a pena deixá-los assim, exceto se for algo que pode vir a ser mutável/parametrizável. Sempre depende do contexto 
7. Outros números notáveis e situações (como 30, 60, 24) depende do contexto (contexto de data/hora) 
8. Prefira utilizar:  
    8.1. StringUtils.isEmpty para verificar strings vazias  
    8.2. Objects.isNull e Objects.nonNull para verificar nulos  
    8.3 Collections.isEmpty para verificar coleções vazia  
9. Evite o uso extenso de lambdas e procure uma boa endentação 
10. Evite utilizar expressões e de lambdas dentro de setters e construtores  
11. Programe defensivamente verificando Nulls antes de acessar propriedades de objetos  
12. Procure um retorno rápido e evite blocos em IF/ELSE (Early return pattern)  
13. Verificações IF de exceção ou retorno podem ser executadas no início e sem um ELSE 
14. Uso de DTOs e VOs  
    14.1. Deverá sempre ser utilizado o sufixo DTO para designar que a classe é um objeto que poderá transportar dados para dentro ou fora do sistema. Nesse caso deverá sempre utilizar os mapeamentos json do framework "jackson".  
    14.2. Os DTO deverão estar no modulo/package "share" (ou similar) para serem compartilhados entre camada de entrada e cada de negócios.  
    14.3. Deverá sempre ser utilizado o sufixo VO para designar que a classe é utilizada apenas como transitória internamente. Pode ser para passagem de parâmetros, pode para um Cálculo temporário, pode ser uma tradução temporária entre objetos   
    14.4. Não é necessário a utilização de VOs dentro de um serviço responsável pela manipulação de uma entidade, basta usar a entidade para tal, porém evitar acoplamento da camada de negócios com a camada de domínio 
Utilizar camelCase para nomear propriedades de DTOs ao criar JSONs do próprio sistema 
15. Proteja-se quanto a nullos  
    15.1. Be safe, verifique as possibilidades de nulos no seu código não confie em lógicas de métodos externos / publicos
    15.2. Optional by Stuart Marks https://www.youtube.com/watch?reload=9&v=fBYhtvY19xA

# Nomenclaturas e convenções gerais   

1. Sem espaço entre um método e o parênteses e o nome do método "(" início de lista de parâmetros;  
2. Métodos são sempre separados entre si por uma linha em branco 
3. O nome de variáveis não deve começar com qualquer caractere especial. Os nomes de variáveis devem ser curtos, mas significativo. Para variáveis temporárias os nomes comuns são i, j, k, m, n.  
4. As constantes devem ser todas em letras maiúsculas com palavras separadas por sublinhados ("_"). 
5. Nunca tenha linhas com mais de 120 caracteres, uma vez que em alguns terminais fica mais difícil de ler. 
6. Quando uma expressão não couber em uma única linha, quebrá-lo de acordo com estes princípios gerais:  
7. Quebre após uma vírgula;  
8. Quebre antes de um operador;  
9. Prefira quebras de nível superior para diminuir o nível-breaks. 
10. Abertura das chaves "{" aparece no fim da mesma linha que foi declarado o código;  
11. Fechamento das chaves "}" começa uma linha alinhada no conjunto do método a qual foi criada, exceto quando há códigos em parte em branco (vazio) ou nulo}"devendo aparecer imediatamente depois de aberto com "{" 
12. Every variable declaration (field or local) declares only one variable: 
    12.1 declarations such as int a, b; are not used.
13. Evitar dar enter entre declaração de variáveis
    13.1. Usar quando tiver algum element acima da declaração. Ex: @Mock , Ex: //Variavel legal
14. Evitar dar enter em declaração de métodos de interfaces

# Idiomas 

## Disponíveis

Portugues (pt-BR) - English (en-US) 

## Por Padrão 

* Código: en-US 
* Comentários em código: en-US 
* Commits: en-US 
* Pull Requests: pt-BR 
* Documentações técnicas: en-US 
* Documentações de Negócio: pt-BR  
* Linguagem da aplicação: pt-BR 
* Tarefas: pt-BR  

## Permitidos 

* Código: en-US 
* Comentários em código: pt-BR/en-US  
* Commits: pt-BR/en-US  
* Pull Requests: pt-BR/en-US  
* Documentações técnicas: pt-BR/en-US,  
* Documentações de Negócio: pt-BR,  
* Linguagem da aplicação: pt-BR/en-US  
* Tarefas: pt-BR/en-US 

# Boas Práticas code review:   

1. Conhecer as boas práticas gerais da empresa  
2. Ter ao menos um resumo da funcionalidade/correção implementada a nível de negócio  
3. Não ser extremista, buscar sempre as melhorias e o melhor code review, mas respeitar também o ritmo do projeto, as criticidades, etc  
4. Verificar se as alterações estão com boas práticas de código  
5. Verificar as nomenclaturas de classes, variáveis e métodos  
6. Estão de acordo com a tarefa que está sendo implementada  
7. Estão nos padrões da equipe/empresa  
8. Podem ser melhorados significativamente  
9. Verificar se visivelmente algo pode gerar impacto de performance  
10. Verificar itens dentro de Loops  
11. Verificar carregamentos sem paginação  
12. Verificar grande quantidade de objetos em memória  
13. Verificar se a parte alterada também teve alteração de testes unitários.  
14. Qualquer alteração em código deve refletir alteração em testes, caso contrário os testes implementados estavam errados ou superficiais.  
15. Olhar o código de teste criado também e verificar se atende as boas práticas, se cobre não apenas o básico, mas as possíveis variações e situações  
16. Verificar o check-list de itens específicos do projeto  
17. Verificar Branchs e commits  
    17.1. Os commits feitos tiveram boas descrições? Foram curtos?  
    17.2 O nome da branch criada segue os padrões do projeto ou empresa  
    17.3 Existe referência ao work item Redmine/JIRA e/ou número de chamado?  
18. Caso o projeto não tenha um CI integrado com o PR, executar o JOB de CI para rodar os testes e sonar da branch que está sendo avaliada.  
    18.1 Caso não houver, rodar manual  
19. O Sonar foi passado nesta branch ? O SonarLint foi analisado?  
    19.1. Algumas vezes é uma branch parcial e não é interessante rodar no servidor geral, mas o desenvolvedor pode rodar local.  
    19.2. Algumas vezes somente o SonarLint já ajuda a pegar muitos code smells ou bugs  
20. Existem / foram alterados LOGs 
21. Tem alguma falha de segurança 
22. Criada/atualizada documentação? 

# Todos os projetos devem ter:   

1. Documentação / Wiki de regra de negócio  
2. Documentação / Wiki de configuração e instalação para desenvolvimento  
3. Documentação / Wiki de processo de build, QA e PRD  
4. Documentação / Wiki de estratégia de branchs e versionamento  
5. Sonar com Quality Profile e Quality Gate definidos  
6. Testes automatizados  
7. Processo de Continuous Integration  
8. Processo de Continuous deploy  
9. Processos estabelecidos de code review  
10. Processos estabelecidos de homologação 

# Versionamento de código (git e commits)  
1. Seguir o Fluxo de Branchs - Gitflow definido pelo time
2. Faça commits pequenos, se possível diários  
3. Na mensagem no commit inserir o padrão “numeroDaIssue - descrição...” 
    3.1. exemplo: “FERNANDO-30 Refatoração Classe X”, desta forma, no JIRA será feito o relacionamento do código com a issue, para fim de rastreabilidade.  
4. Nome da branch deve seguir o padrão com o código da issue, feature/FERNANDO-X e pode ser adicionando um texto de identificacao. Ex:  feature/FERNANDO-X_fix_code_x 
5. Padrão de prefixo do gitflow para branchs. Ex: feature/ , hotfix/, etc 

# Recomendações e boas práticas em testes unitários  

1. Prefira o uso de Junit5
    1.1. Lançamento do Junit5 https://www.youtube.com/watch?v=0qI6_NKFQsY
    1.2. Diferenças do Junit4 para o 5 https://www.youtube.com/watch?v=vEr6QHil2xI
2. Usar 1 cenário por teste 
3. Usar um passo a passo para o teste “given when then” 
4. A anotação @DisplayName, deverá ser utilizada para facilitar a entendimento do cenário de teste que está sendo realizado pelo método, classe e etc  
    4.1. Procurar usar o pattern: “Should do something when some condition”
    4.1.1. ex: Should not throw any exception when dto values are valid"
    4.2. Em Kotlin é possível usar métodos com nomes em String entre ` ` 
    4.3. Utilização desses recursos permite uma melhor legibilidade dos códigos quando quebram, principalmente em ambientes automatizados 
5. Prefira o uso de testes unitários sobre de integração, os mesmos têm custo mais baixo para implementação e para execução.  
6. Evitar testar comportamento interno, melhor checkar o resultado esperado – ex: ao invés de testar com verify, testar o resultado  
7. Evite ao máximo realizar verify no final do teste  
8. Verify geralmente está associado ao comportamento e fluxo interno e não ao resultado esperado 
    8.1. Exceto para casos que realmente o comportamento é significativo. Ex: ao salvar deve obrigatoriamente chamar a Auditoria 
9. Preferencialmente realize apenas um assert ao final, criando variações do teste para validar demais asserts  
    9.1. Lembrando que muitos asserts, pode ser sinal de falha no design  
10. Testar todas as ações de resultado que são importantes.  
    10.1. Ex: resultado salvo, auditoria, loggs 
11. Evite uso de constantes de código nos testes


# Versionamento e evolução de base de dados  
 
1. Procurar junto ao responsável do projeto e arquitetos implementar Liquibase ou Flyway  
2. Onde já houver, seguir as melhores práticas  
3. Evitar ao máximo alterar arquivos, fazer a evolução com arquivos novos  
4. Separar em pequenos arquivos com as execuções de SQLs  
5. Fazer apenas uma instrução por arquivo 
6. É uma boa prática usar o sequencial com data-hora_codigo_da_issue_descricao 
    6.1.  Ex 10/08/2020 as 18:10:01 é criado o arquivo “V2020.08.10.18.10_FERNANDO-000_criar_tabela_x.sql” 
7. Utilizar scripts idepotentes 
8. Fazer checkagem se já foi executado ou se já existe na base
    8.1. Ex: if table exists 
    8.2 Ex: if column exists

    //check se o usuario já existe
    DECLARE v_exist NUMBER; 
    BEGIN 
        SELECT COUNT(*) INTO v_exist FROM tab_cliente WHERE idt_cliente = 'abc@email'; 
        IF v_exist = 0 THEN 
            INSERT INTO tab_cliente VALUES ('abc@email', to_char(sysdate, 'YYYYMMDD HH24:MI:SS'), '', 'Fernando Gomes', 0); 
            commit; 
        END IF; 
    END; 

    //check se uma tabela já existe 
    DECLARE v_exist NUMBER; 
    BEGIN 
        SELECT COUNT(*) INTO v_exist FROM user_tables WHERE table_name = ' tabela_nova'; 
        IF v_exist = 0 THEN 
            execute immediate 'CREATE TABLE tabela_nova ( 
    idt_pessoa NUMBER AS IDENTITY,  
    primeiro_nome VARCHAR2(50) NOT NULL)'; 
        END IF; 
    END; 

# Ferramentas de build GRADLE, MAVEN e similares  

1. Procure usar “wrapper” para não ter dependência de instalação nos ambientes  
2. Usar as versões de dependências em variáveis, seja no ext ou no gradle.properties 
3. Dividir em sub módulos quando necessário  
4. Organizar as dependências agrupando por funções e por ordem alfabética  
5. Usar somente as dependências necessárias  
6. Dividir em arquivos os processos para facilitar a identificação e manutenção  
7. GRADLE Nunca utilizar 'plugin java' nos sub módulos, para não perder a configuração do gradle pai  
8. Garantir que no Gradle “pai”, tenha as propriedades sourceCompatibility e targetCompatibility  

# Quality Gate Sonar 

## Débito Tecnico 

Blocker Issues is greater than 0 (error) 
Critical Issues is greater than 0 (error)  
Major Issues is greater than 1 (error) 
Bugs is greater than 0 (warn) 5 (error) 
Vulnerabilities is greater than 0 (error) 
Minor Issues is greater than 5 (warn) 10 (error) 
Code Smells is greater than 10 (warn) 15 (error) 
Technical Debt is greater than 2d (error) 

## Testes
Coverage on new code is less than is less than 80% (warn) 60.0% (error) 
Condition Coverage on New Code is less than 80% (warn) 60.0% (error) 
Skipped Unit Tests is greater than 1 (error) 

## Leitura e Manutenabilidade

Duplicated Lines (%) is greater than 1,5% (warn) 3% (error)
Maintainability Rating on New Code is worse than A (error)
Reliability Rating is worse than A (error)
Security Rating is worse than A (error) 

# Referencias: 

* https://gist.github.com/wojteklu/73c6914cc446146b8b533c0988cf8d29 
* https://www.todaysoftmag.com/article/1120/clean-code-comments-and-formatting 
* https://blog.usejournal.com/stop-writing-code-comments-28fef5272752 
* https://blog.cleancoder.com/uncle-bob/2017/02/23/NecessaryComments.html 
* https://dzone.com/articles/rule-30-–-when-method-class-or#:~:text=Some%20people%20recommend%20that%20200,not%20more%20than%2020”%20methods. 
* https://softwareengineering.stackexchange.com/questions/133404/what-is-the-ideal-length-of-a-method-for-you 
* https://dbabulletin.com/index.php/2018/03/29/best-practices-using-flyway-for-database-migrations/ 
* https://rieckpil.de/howto-best-practices-for-flyway-and-hibernate-with-spring-boot/ 
* https://www.agilealliance.org/glossary/gwt/ 
* https://medium.com/@erik.sacre/on-tdd-literals-versus-constants-in-tests-8ac992c7873f 
* https://dev.to/scottshipp/don-t-use-non-test-constants-in-unit-tests-3ej0
* https://www.youtube.com/watch?v=fBYhtvY19xA
* https://www.youtube.com/watch?v=0qI6_NKFQsY
* https://www.youtube.com/watch?v=vEr6QHil2xI
