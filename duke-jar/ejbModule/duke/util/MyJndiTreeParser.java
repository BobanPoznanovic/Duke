package duke.util;

import java.util.HashSet;

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

	public void parse() {
		
		System.out.println("My JNDI parser");
		
		try {
			NamingEnumeration<NameClassPair> list = ctx.list(myEXP);
			while (list.hasMore()) {
			  String module = list.next().getName();
			  processModule("", module);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	public void processModule(String parentModule, String module) throws NamingException {
		
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
					//nasledjuje
					checkIfImplementsAgent(ejbName);
				}
				else {
					processModule(module, ejbName);
				}
			}
		}
		
		
	}
	
	public AgentType checkIfImplementsAgent(String ejbName) {
		if(ejbName.endsWith(agentInterfacePath)) {
			parseEjbName();
		}
		return null;
	}
	
	public AgentType parseEjbName() {
		AgentType agentType = null;
		
		return agentType;
	}
}
