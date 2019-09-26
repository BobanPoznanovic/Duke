package duke.agentmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

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
	public String getAvailableAgentClasses() {
		// TODO Auto-generated method stub
		System.out.println("Get all available agent classes");
		
		List<AgentType> retVal = new ArrayList<AgentType>();
		try {
			retVal = jndi.parse();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Integer.toString(retVal.size());
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
		String ejbName = type.getName();
		String module = type.getModule();
		Agent agent = null;
		
		AID aid = new AID(name, "", type);
		
		try {
			InitialContext localCtx = new InitialContext();
			String exp = "java:jboss/exported/duke-ear" + "/" + module + "/" + ejbName;
			agent = lookup(exp, Agent.class, localCtx);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initAgent(agent, aid);
		
		return aid;
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
	
	public void initializeAgentMap() {
		this.agents = new HashMap<>();
	}
	
	public void initAgent(Agent agent, AID aid) {
		if(agents==null) {
			initializeAgentMap();
		}
		this.agents.put(aid, agent);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T lookup(String name, Class<T> c, InitialContext ctx) {
		try {
			return (T) ctx.lookup(name);
		} catch (NamingException ex) {
			throw new IllegalStateException("Failed to lookup " + name, ex);
		}
	}

}
