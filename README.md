# SistemaTarefas

Resumo:
Foi implementado no sistema um cadastro, edição e listagem das taferas, sendo que, na listagem é possível realizar a filtragem dos dados. Além disso, foi implementado um sistema de login, onde somente os usuários que tiverem as credenciais de Responsavel poderam acessa partes restristas do sistema, como a edição, cadastro e manipulação das tarefas. Qualquer novo usuario pode criar uma conta quando quiser.

Itens implementados:
a) Criar uma aplicação Java Web utilizando JavaServer Faces (JSF).
b) Utilizar persistência em um banco de dados PostgreSQL.
c) Utilizar JPA.
f) Utilização de JTA para facilidar a implementação e configuração do hibernate.
g) Utilização de CDI.

Instruções para execução em um ambiente local:

Requisitos:
IDE - Eclipse IDE for Enterprise Java and Web Developers - 2021-06 Ou similar
Servidor local - WildFly 23.0 ou similar
Banco de dados - PostgreSQL
Java - Java 16
Maven - Maven 4.0 ou similar

Passos:
1. Importa o projeto para a sua IDE.
2. Instalar o Servidor WildFly na sua IDE.
3. Criar um banco de dados no PostgreSQL.
4. Configurar o WildFly para o funciomento da JTA com o PostgreSQL:
   Entrar no diretorio \standalone\configuration do seu servidor WildFly.
   Abrir o arquivo standalone-full.xml ou o standalone.xml (Depende qual configurou na instalação do servidor).
   Adicionar os comandos que estão no arquivo stand_config.txt na pasta coniguração.
   Criar os diretorios /org/postgresql/main/ dentro da pasta modules no diretorio do WildFly.
   Dentro de /org/postgresql/main/ criar o arquivo module.xml com os codigos que estão dentro do arquivo module_config.txt e colocar no mesmo diretorio o driver jdbc do postgresql
   Feito isso o servidor está configurado.
5. Pode dar start no servidor e está pronto.
