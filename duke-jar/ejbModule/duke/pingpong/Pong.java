package duke.pingpong;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import duke.agentmanager.Agent;
import duke.agentmanager.XjafAgent;
import duke.messagemanager.ACLMessage;
import duke.messagemanager.Performative;

@Stateless
@Remote(Agent.class)
public class Pong extends XjafAgent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void handleMessage(ACLMessage message) {
		// TODO Auto-generated method stub
		if(message.performative == Performative.REQUEST) {
			System.out.println("Pong Request performative");
		}
		else if(message.performative == Performative.INFORM) {
			System.out.println("Pong Inform performative");
		}
	}

}
