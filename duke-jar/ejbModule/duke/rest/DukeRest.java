package duke.rest;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import duke.agentmanager.AID;
import duke.agentmanager.AgentType;
import duke.messagemanager.ACLMessage;
import duke.messagemanager.Performative;

public interface DukeRest {

	@GET
	@Path("/agents/classes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AgentType> getAvailableAgentClasses(); //Return value was list of AgentType
	
	
	@GET
	@Path("/agents/running")
	public List<AID> getRunningAgents();
	
	@PUT
	@Path("/agents/running/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AID startAgent(AgentType type, @PathParam("name") String runtimeName);
	
	@DELETE
	@Path("/agents/running")
	@Consumes(MediaType.APPLICATION_JSON)
	public void stopAgent(AID aid);
	
	@POST
	@Path("/messages")
	@Consumes(MediaType.APPLICATION_JSON)
	public void sendACLMessage(ACLMessage message);
	
	@GET
	@Path("/messages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getPerformatives();
}
