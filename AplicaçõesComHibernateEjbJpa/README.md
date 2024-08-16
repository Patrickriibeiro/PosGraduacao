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

No exercicio 02_Calculadora, por algum motivo no momento do empacotamento do war(02_CalculadoraWeb) a ide Kepler não estava adicionando o calc.jar como lib do web project JSF, mesmo com o buildPath configurado corretamente, então fiz manualmente.

JAR (Java ARchive): Quando você tem uma biblioteca ou um aplicativo Java standalone. Exemplo: Uma biblioteca utilitária que será usada por outras aplicações.

WAR (Web Application Archive) : Quando você desenvolve uma aplicação web que será executada em um servidor de aplicação web. Exemplo: Um site ou serviço web.

EAR (Enterprise Application Archive) : Quando você está construindo uma aplicação empresarial complexa que precisa integrar diferentes tipos de módulos (web, EJB, etc.). Exemplo: Um sistema de gestão empresarial que inclui uma interface web, lógica de negócios complexa e bibliotecas compartilhadas.


Exercico 03 - EJB MDB. (03_ProjetoMDB) - Message-driven bean.

Extension Message Jboss -  <extension module=“org.jboss.as.messaging”/> (Adicionar no Standalone.xml(Arquivos de configuração do JBOSS))

Dentro do elemento <profile>, adicionar o seguinte elemento <subsystem>: 

<subsystem xmlns="urn:jboss:domain:messaging:1.1">
    <hornetq-server>
        <persistence-enabled>true</persistence-enabled>
        <journal-file-size>102400</journal-file-size>
        <journal-min-files>2</journal-min-files>
        <connectors>
            <netty-connector name="netty" socket-binding="messaging"/>
            <netty-connector name="netty-throughput" socket-binding="messaging-throughput">
                <param key="batch-delay" value="50"/>
            </netty-connector>
            <in-vm-connector name="in-vm" server-id="0"/>
        </connectors>
        <acceptors>
            <netty-acceptor name="netty" socket-binding="messaging"/>
            <netty-acceptor name="netty-throughput" socket-binding="messaging-throughput">
                <param key="batch-delay" value="50"/>
                <param key="direct-deliver" value="false"/>
            </netty-acceptor>
            <in-vm-acceptor name="in-vm" server-id="0"/>
        </acceptors>
        <security-settings>
            <security-setting match="#">
                <permission type="send" roles="guest"/>
                <permission type="consume" roles="guest"/>
                <permission type="createNonDurableQueue" roles="guest"/>
                <permission type="deleteNonDurableQueue" roles="guest"/>
            </security-setting>
        </security-settings>
        <address-settings>
            <address-setting match="#">
                <dead-letter-address>jms.queue.DLQ</dead-letter-address>
                <expiry-address>jms.queue.ExpiryQueue</expiry-address>
                <redelivery-delay>0</redelivery-delay>
                <max-size-bytes>10485760</max-size-bytes>
                <address-full-policy>BLOCK</address-full-policy>
                <message-counter-history-day-limit>10</message-counter-history-day-limit>
            </address-setting>
        </address-settings>
        <jms-connection-factories>
            <connection-factory name="InVmConnectionFactory">
                <connectors>
                    <connector-ref connector-name="in-vm"/>
                </connectors>
                <entries>
                    <entry name="java:/ConnectionFactory"/>
                </entries>
            </connection-factory>
            <connection-factory name="RemoteConnectionFactory">
                <connectors>
                    <connector-ref connector-name="netty"/>
                </connectors>
                <entries>
                    <entry name="RemoteConnectionFactory"/>
                    <entry name="java:jboss/exported/jms/RemoteConnectionFactory"/>
                </entries>
            </connection-factory>
            <pooled-connection-factory name="hornetq-ra">
                <transaction mode="xa"/>
                <connectors>
                    <connector-ref connector-name="in-vm"/>
                </connectors>
                <entries>
                    <entry name="java:/JmsXA"/>
                </entries>
            </pooled-connection-factory>
        </jms-connection-factories>
        <jms-destinations>
            <jms-queue name="testQueue">
                <entry name="queue/ExemploQueue"/>
            </jms-queue>
            <jms-topic name="testTopic">
                <entry name="topic/MyTopic"/>
            </jms-topic>
        </jms-destinations>
    </hornetq-server>
</subsystem>

Dentro do elemento <socket-binding-group>, adicionar os elementos: 

  <socket-binding name="messaging" port="5445"/>
		<socket-binding name="messaging-throughput" port="5455"/>

Localize o elemento <subsystem xmlns=“urn:jboss:domain:ejb3:1.2”>. Em seguida, adicione o elemento:

   <mdb>
				<resource-adapter-ref resource-adapter-name="hornetq-ra"/>
				<bean-instance-pool-ref pool-name="mdb-strict-max-pool"/>
			</mdb>


Hornetq é um projeto opensource que permite a construção de sistemas assíncronos multiplataforma. A partir da versão 7.0 do JBoss, um grupo de configurações no arquivo standalone.xml é suficiente. Em versões anteriores, era necessário usar a API Hornetq, disponível em: <http://hornetq. jboss.org/docs.html>.
Projetado pela Sun MicroSystems com o apoio de empresas associadas e lançado para o mercado em agosto de 1998, o JMS surgiu para permitir que os aplicativos escritos na linguagem Java pudessem criar, receber e enviar mensagens destinadas ou oriundas de outros aplicativos. A principal característica desse tipo de processamento, classificado como fracamente acoplado, é que todas as operações que envolvem a troca de mensagens são feitas de forma assíncrona, fazendo com que as aplicações participantes não precisem ficar bloqueadas esperando o término de alguma computação remotamente solicitada, como ocorre naquelas aplicações que utilizam o Remote Procedure Call(RPC) ou mesmo o Remote Method Invocation(RMI).




