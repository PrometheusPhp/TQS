# bugBank

Automação web do BugBank (https://bugbank.netlify.app/) com Java + Selenium + JUnit 5 + Allure,
na mesma estrutura do projeto sauceDemo (Framework / PageObjects / Tasks / Validacao / TestCases).

## Cenário
1. Cadastra duas contas com saldo
2. Entra na primeira e transfere um valor para a segunda
3. Valida saldo e extrato da conta que enviou
4. Entra na segunda e valida saldo e extrato da conta que recebeu

## Como rodar
```
mvn clean test                      # Chrome (padrão)
mvn clean test -Dbrowser=edge
mvn clean test -Dbrowser=firefox
mvn clean test -Dbrowser=headless   # Chrome sem janela
mvn allure:serve                    # relatório
```
Valores do teste (saldo inicial, valor e descrição da transferência) ficam em
`src/main/resources/Properties/conta.properties`.

Requer JDK 27 (`--enable-preview`), como no sauceDemo.

## Contas usadas
Nome, e-mail, senha e número das duas contas criadas em cada execução são gravados em
`registros/contas-usadas.csv` (histórico: cada execução acrescenta linhas), impressos no console
e anexados ao relatório do Allure.

## Dados das contas criadas
A cada execução o teste grava nome, e-mail, senha e número das duas contas em
`evidencias/contas-criadas.txt` (arquivo recriado), mostra no console e anexa ao relatório do Allure.
