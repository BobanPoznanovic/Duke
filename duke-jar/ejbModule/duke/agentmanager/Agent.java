package duke.agentmanager;

import java.io.Serializable;

import duke.messagemanager.ACLMessage;

public interface Agent extends Serializable {
	
	void handleMessage(ACLMessage message);
}
