JBOSS TOOLS - CORE - PARA ECLIPSE VERSAO KEPLER - https://download.jboss.org/jbosstools/updates/development/kepler. (Colocar o link quando for instalar o software no eclipse install)

Utilizei o servidor JBOSS 7.1, é necessário conter o jre 7 na idei kepler para executar o servidor, em blogs encontrei users relantando que a versão 7.1 deveria executar com a jre 8 também, porém é necessário alterações complexas no arquivo standalone.xml ou domain.xml, preferi utilizar a versão ideal que a 7.

Versão de dependencias utilizadas no exercicio - 

obs: Na descrição do exercico mandava realizar o download dos respectivos Jars abaixo, porém não encontrei no site do hibernate, então utilizei o gerenciador de dependecia Maven nos projetos para utilizar as libs mencionadas no exercicios.

 <!-- Hibernate Core -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>5.6.10.Final</version>
        </dependency>

        <!-- JPA API -->
        <dependency>
            <groupId>javax.persistence</groupId>
            <artifactId>javax.persistence-api</artifactId>
            <version>2.2</version>
        </dependency>

        <!-- MySQL Connector/J -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version>
        </dependency>

        <!-- Hibernate Entity Manager -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-entitymanager</artifactId>
            <version>5.6.10.Final</version>
        </dependency>

No exercicio 01_FolhaDePagamento, ambos os projetos utilizam o mesmo EAR, o mesmo possui o war gerado através do projeto 01_FolhaDePagamentoWeb e o Jar do 01_FolhaDePagamento.

JAR (Java ARchive): Quando você tem uma biblioteca ou um aplicativo Java standalone. Exemplo: Uma biblioteca utilitária que será usada por outras aplicações.
WAR (Web Application Archive) : Quando você desenvolve uma aplicação web que será executada em um servidor de aplicação web. Exemplo: Um site ou serviço web.
EAR (Enterprise Application Archive) : Quando você está construindo uma aplicação empresarial complexa que precisa integrar diferentes tipos de módulos (web, EJB, etc.). Exemplo: Um sistema de gestão empresarial que inclui uma interface web, lógica de negócios complexa e bibliotecas compartilhadas.
