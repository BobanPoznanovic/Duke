package duke.agentmanager;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.PathParam;

public interface AgentManager extends Serializable{

	//public List<AgentType> getAvailableAgentClasses();
	
	public String getAvailableAgentClasses();
	
	public List<AID> getRunningAgents();
	
	public AID startAgent(AgentType type, @PathParam("name") String name);
	
	public void stopAgent(AID aid);
}
