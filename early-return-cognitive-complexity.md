# Conceitos:
* guard clause
* early return / avoid else
* diminuição de carga cognitiva e complexidade cognitiva
	* através da eliminação de hipoteses e variaveis
	* através da diminuicao dos niveis de encadeamento (niveis de edentacao)
* facilitação do entendimento através da diminuição da quebra de fluxo de código

# Referencias:

//blog de refatoração do martin f, sobre clausulas de guarda e condicoes aninhadas
https://refactoring.com/catalog/replaceNestedConditionalWithGuardClauses.html

//artigo do google sobre code health e reducao de encadeamentos
https://testing.googleblog.com/2017/06/code-health-reduce-nesting-reduce.html

//manual da métrica de complexidade cognitiva do sonar com exemplos
https://www.sonarsource.com/docs/CognitiveComplexity.pdf

//uma apresentação de slides sobre  complexidade cognitiva com exemplos
https://artesoftware.com.br/2019/02/10/complexidade-cognitiva/

//um artigo bacana falando sobre usar o conceito pra evitar condicoes aninhadas e melhorar a legibilidade
https://dev.to/yvonnickfrin/devtips-use-early-returns-to-avoid-nested-conditions-4i51

//uma apresentação de slides sobre  complexidade cognitiva com exemplos
https://pt.slideshare.net/DouglasSiviotti/complexidade-cognitiva

//um artigo bacana com mais explicacoes
https://medium.com/better-programming/are-early-returns-any-good-eed4b4d03866

//um debate legal sobre o tema de complexidade cognitiva
https://stackoverflow.com/questions/52741725/what-is-cognitive-complexity-in-sonar-report

//uma boa discussao sobre ter multiplos retornos e como encadiamento de nivies pode dificultar a letitura e entendimento
https://stackoverflow.com/questions/36707/should-a-function-have-only-one-return-statement?page=1&tab=votes#tab-top

//Não é exatamente sobre early return mas é um video mto legal sobre DDD e Teoria da Carga Cognitiva
DDD e Teoria da Carga Cognitiva | Zup Insights (Alberto Souza)
https://www.youtube.com/watch?v=hAducG06ZMI&

//Não é exatamente sobre early return mas é um video mto legal sobre carga cognitiva e carga intrinsica
LIVE CODING: refatorando um código | Zup Insights (Alberto Souza)
https://www.youtube.com/watch?v=dS-mDgchUtk

//um comentario interessante sobre pontos de vista de single exit e return early
https://stackoverflow.com/questions/4838828/why-should-a-function-have-only-one-exit-point

//um artigo explicando a origem do single exit e talz
http://blog.triadworks.com.br/single-exit-point
