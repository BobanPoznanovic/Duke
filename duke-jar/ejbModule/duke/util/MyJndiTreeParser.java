package duke.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import duke.agentmanager.Agent;
import duke.agentmanager.AgentType;

@Stateless
@LocalBean
public class MyJndiTreeParser {
	
	private InitialContext ctx;
	private static final String EXP = "java:jboss/exported/";
	private static final String myEXP = "java:jboss/exported";
	private static final String agentInterfacePath = "!" + Agent.class.getName();
	
	@PostConstruct
	public void postConstruct() {
		try {
			ctx = new InitialContext();
		} catch (NamingException e) {
			
		}
		
	}

	public List<AgentType> parse() throws NamingException {
		
		List<AgentType> result = new ArrayList<>();
		
		System.out.println("My JNDI parser");
		
		try {
			NamingEnumeration<NameClassPair> list = ctx.list(myEXP);
			while (list.hasMore()) {
				if(list.next() != null) {
					String module = list.next().getName();
					  processModule("", module, result);
				}
			  
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public void processModule(String parentModule, String module, List<AgentType> results) throws NamingException {
		
		NamingEnumeration<NameClassPair> list = null;
		
		if ( parentModule.equals("")) {
			try {
				list = ctx.list(myEXP + "/" + module);
			} catch (NamingException e) {
				
			}
		} else {
			try {
				list = ctx.list(myEXP + "/" + parentModule + "/" + module);
			} catch (NamingException e) {
				
			}
		}
		
		if(list!=null) {
			while(list.hasMore()) {
				NameClassPair ncp = list.next();
				String ejbName = ncp.getName();
				if(ejbName.contains("!")) {
					AgentType newAgentType = checkIfImplementsAgent(module, ejbName);
					if(newAgentType != null) {
						results.add(newAgentType);
					}
				}
				else {
					processModule(module, ejbName, results);
				}
			}
		}
		
		
	}
	
	public AgentType checkIfImplementsAgent(String module, String ejbName) {
		if(ejbName.endsWith(agentInterfacePath)) {
			return parseEjbName(module, ejbName);
		}
		return null;
	}
	
	public AgentType parseEjbName(String module, String ejbName) {
		AgentType agentType = new AgentType();
		
		agentType.setModule(module);
		agentType.setName(ejbName);
		
		return agentType;
	}
}
