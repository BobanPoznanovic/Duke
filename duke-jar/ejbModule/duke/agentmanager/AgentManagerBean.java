package duke.agentmanager;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import duke.util.MyJndiTreeParser;

@Stateless
@Remote(AgentManager.class)
@LocalBean
public class AgentManagerBean implements AgentManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<AID, Agent> agents;
	
	@EJB
	private MyJndiTreeParser jndi;

	@Override
	public List<AgentType> getAvailableAgentClasses() {
		// TODO Auto-generated method stub
		System.out.println("Get all available agent classes");
		
		jndi.parse();
		
		return null;
	}

	@Override
	public List<AID> getRunningAgents() {
		// TODO Auto-generated method stub
		System.out.println("Gell all running agents");
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

	public Map<AID, Agent> getAgents() {
		return agents;
	}

	public void setAgents(Map<AID, Agent> agents) {
		this.agents = agents;
	}

}
