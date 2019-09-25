package duke.agentmanager;

public class AID {
	
	private String name;
	private String host;
	private AgentType type;
	
	public AID() {
		name = "";
		host = "";
		type = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public AgentType getType() {
		return type;
	}

	public void setType(AgentType type) {
		this.type = type;
	}
	
	
	
}
