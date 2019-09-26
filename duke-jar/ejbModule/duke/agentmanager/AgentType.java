package duke.agentmanager;

import java.io.Serializable;

public class AgentType implements Serializable {

	private String name;
	private String module;
	
	public AgentType() {
		this("","");
	}
	
	public AgentType(String module, String name) {
		this.module = module;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}
	
	
}
