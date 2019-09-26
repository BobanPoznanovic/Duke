package duke.pingpong;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import duke.agentmanager.Agent;
import duke.agentmanager.XjafAgent;
import duke.messagemanager.ACLMessage;

@Stateless
@Remote(Agent.class)
public class Ping extends XjafAgent{

	@Override
	public void handleMessage(ACLMessage message) {
		// TODO Auto-generated method stub
		
	}

}
