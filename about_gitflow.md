
  
## **Instruções:**  
  
1. Seguir o Fluxo de Branchs - Gitflow definido pelo time  
2. Nome da branch deve seguir o padrão com o código da issue, feature/MYPROJ-X e pode ser adicionando um texto de identificacao.   
   2.1. Ex: feature/MYPROJ-X_fix_code_x  
3. Na mensagem no commit inserir o padrão “numeroDaIssue - descrição...”    
   3.1. EX: “MYPROJ-30 Refatoração Classe X”, desta forma, no JIRA será feito o relacionamento do código com a issue, para fim de rastreabilidade.  
4. Faça commits pequenos, se possível diários  
5. Padrão de prefixo do gitflow no nome das branchs. Ex: feature/ , hotfix/, etc  
  
## **Code Review e Pull Request**  
  
Ao terminar a tarefa, abrir a PR via Github para a branch de destino, seguindo o GitFlow  
Titulo da PR deve conter o ID da tarefa no JIRA (ou outro ALM)  
  
> Ex: MYPROJ-234 Alterando a pesquisa de estados  
  
E uma breve descrição do que foi alterado, no campo descrição.    
Passar a tarefa para CodeReview no board agile e avisar os demais membros no canal de comunicação  
  
## **Sobre o GitFlow**  
![Gitflow](./gitflow.jpg)  
[https://www.atlassian.com/br/git/tutorials/comparing-workflows/gitflow-workflow](https://www.atlassian.com/br/git/tutorials/comparing-workflows/gitflow-workflow)  
  
A branch **/develop** , será criada a partir da “main/master” e será fixa  
A branch **/release ,** será criada a partir da “develop” e será fixa  
  
1. **Ao criar uma nova feature:**.  
1.1. Partir da branch **/develop**  
1.2. Retornar a PR para a branch **/develop**  
2. **Ao criar uma hotfix ou bugfix**  
2.1. Partir da branch **/main**  
2.2. Retornar a PR para a branch **/main**  
3. **Tudo que entrar na branch /main (ao integrar uma release ou hotfix)**  
3.1. Deve entrar também na branch **/develop**  
3.2. Deve entrar também na branch **/release**  
4. **Para “gerar” uma nova release:**  
4.1.  Deve ser feito um “merge” da **/develop** na → **/release**  
5. **Para “encerrar” uma release, promovendo para prod**  
5.1. Deve ser feito um “merge” da **/release** na → **/develop**  
5.2. Deve ser feito um “merge” da **/release** na → **/main**  
  
## **Deploys:**  
  
1. Produção  
1.1.  sempre a partir da **/main**  
2. QA  
2.1. default a partir da **/release**  
2.2. pode ser enviado branchs de features para serem testadas
