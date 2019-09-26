package duke.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import duke.agentmanager.AID;
import duke.agentmanager.AgentManager;
import duke.agentmanager.AgentType;

@Stateless
@LocalBean
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Remote(DukeRest.class)
@Path("")
public class DukeRestBean implements DukeRest{
	
	@EJB
	AgentManager agm;

	@Override
	public List<AgentType> getAvailableAgentClasses() {
		// TODO Auto-generated method stub
		return agm.getAvailableAgentClasses();
	}

	@Override
	public List<AID> getRunningAgents() {
		// TODO Auto-generated method stub
		return agm.getRunningAgents();
	}

	@Override
	public AID startAgent(AgentType type, String runtimeName) {
		// TODO Auto-generated method stub
		return agm.startAgent(type, runtimeName);
	}

	@Override
	public void stopAgent(AID aid) {
		// TODO Auto-generated method stub
		agm.stopAgent(aid);
	}

}
