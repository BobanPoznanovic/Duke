package duke.rest;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import duke.agentmanager.AID;
import duke.agentmanager.AgentType;

public interface DukeRest {

	@GET
	@Path("/classes")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAvailableAgentClasses(); //Return value was list of AgentType
	
	
	@GET
	@Path("/running")
	public List<AID> getRunningAgents();
	
	@PUT
	@Path("/running/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AID startAgent(AgentType type, @PathParam("name") String runtimeName);
	
	@DELETE
	@Path("/running")
	@Consumes(MediaType.APPLICATION_JSON)
	public void stopAgent(AID aid);
}
