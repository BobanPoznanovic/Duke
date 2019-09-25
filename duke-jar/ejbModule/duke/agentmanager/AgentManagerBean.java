package duke.agentmanager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(AgentManager.class)
@LocalBean
public class AgentManagerBean implements AgentManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<AgentType> getAvailableAgentClasses() {
		// TODO Auto-generated method stub
		System.out.println("Get all available agent classes");
		return null;
	}

	@Override
	public List<AID> getRunningAgents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AID startAgent(AgentType type, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stopAgent(AID aid) {
		// TODO Auto-generated method stub
		
	}

}
