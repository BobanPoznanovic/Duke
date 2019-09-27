package duke.messagemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import duke.agentmanager.AID;

@Stateless
@Remote(MessageManager.class)
@LocalBean
public class MessageManagerBean implements MessageManager{
	
	@EJB
	private JMSFactory factory;
	
	private Session session;
	private MessageProducer producer;
	
	@PostConstruct
	public void postConstruct() {
		session = factory.getSession();
		producer = factory.getDefaultProducer(session);
	}
	
	@PreDestroy
	public void preDestroy() {
		try {
			session.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getPerformatives() {
		// TODO Auto-generated method stub
		Performative[] performatives = Performative.values();
		
		List<String> retVal = new ArrayList<String>();
		
		for (Performative p : performatives) {
			retVal.add(p.toString());
		}
		
		return retVal;
	}

	@Override
	public void post(ACLMessage message) {
		// TODO Auto-generated method stub
		System.out.println("Post message");
		AID aid = message.receivers.get(0);
		try {
			ObjectMessage jmsMsg = session.createObjectMessage(message);
			jmsMsg.setStringProperty("JMSXGroupID", aid.getName()+"@"+aid.getHost());
			jmsMsg.setIntProperty("AIDIndex", 0);
			jmsMsg.setStringProperty("_HQ_DUPL_ID", UUID.randomUUID().toString());
			producer.send(jmsMsg);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
