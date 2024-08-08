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
