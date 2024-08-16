package br.com.patrickriibeiro.servlet;

import java.io.PrintWriter;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.patrickriibeiro.mdb.classes.Cliente;

@WebServlet("/mdb")
public class ServletMdb extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String QUEUE_LOOKUP = "queue/ExemploQueue";
	private static final String CONNECTION_FACTORY = "ConnectionFactory";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter out = null;
		QueueConnection connection = null;
		QueueSession session = null;

		try {
			out = resp.getWriter();

			// Inicializando o contexto
			Context context = new InitialContext();

			// Lookup da Connection Factory
			QueueConnectionFactory factory = (QueueConnectionFactory) context
					.lookup(CONNECTION_FACTORY);

			// Criando a conexão
			connection = factory.createQueueConnection();

			// Criando a sessão
			session = connection.createQueueSession(false,
					QueueSession.AUTO_ACKNOWLEDGE);

			// Lookup da Queue
			Queue queue = (Queue) context.lookup(QUEUE_LOOKUP);

			// Criando o sender
			QueueSender sender = session.createSender(queue);

			// 1. Enviando objeto TextMessage
			TextMessage textMessage = session.createTextMessage();
			textMessage.setText("Exemplo EJB3 MDB Queue!!!");
			sender.send(textMessage);
			out.println("1. Enviando mensagem tipo TextMessage");

			// 2. Enviando objeto ObjectMessage
			ObjectMessage objMsg = session.createObjectMessage();
			Cliente cliente = new Cliente();
			cliente.setId(1500);
			cliente.setNome("Ead Pós");
			cliente.setTelefone("3385-8010");
			cliente.setEmail("emilio.celso@ead.com.br");
			objMsg.setObject(cliente);
			sender.send(objMsg);
			out.println("2. Enviando mensagem ObjectMessage");

		} catch (Exception ex) {
			if (out != null) {
				out.println("Erro ao enviar mensagem: " + ex.getMessage());
			}
			ex.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
