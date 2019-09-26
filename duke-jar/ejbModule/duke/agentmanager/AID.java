package duke.agentmanager;

import java.io.Serializable;

public class AID implements Serializable {
	
	private String name;
	private String host;
	private AgentType type;
	
	public AID() {
		this("","",null);
	}
	
	public AID(String name, String host, AgentType type) {
		setName(name);
		setHost("duke-ear");
		setType(type);
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
