package duke.messagemanager;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

@Singleton
@LocalBean
public class JMSFactory {

	@Resource(lookup = "java:jboss/exported/jms/RemoteConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(lookup = "java:jboss/exported/jms/queue/siebog")
	private Queue queue;
	
	private Connection connection;
	
	@PostConstruct
	public void postConstruction() {
		try {
			connection = connectionFactory.createConnection("guest", "guest.guest.1");
			connection.setClientID("duke-jar");
			connection.start();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		try {
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Session getSession() {
		try {
			if(connection == null)
				postConstruction();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			return session;
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public MessageProducer getDefaultProducer(Session session) {
		try {
			if(session==null) {
				return getSession().createProducer(queue);
			}
				
			return session.createProducer(queue);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
