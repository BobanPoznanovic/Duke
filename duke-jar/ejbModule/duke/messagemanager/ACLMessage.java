package duke.messagemanager;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import duke.agentmanager.AID;

public class ACLMessage implements Serializable {

	private static final long serialVersionUID = -2935147894991062937L;
	
	public Performative performative;
	public AID sender;
	public List<AID> receivers;
	public AID replyTo;
	public String content;
	public Object ContentObj;
	public HashMap<String, Object> userArgs;
	public String language;
	public String encoding;
	public String ontology;
	public String protocol;
	public String converstationId;
	public String replyWith;
	public String inReplyTo;
	public Long replyBy;
	
	public ACLMessage() {
		
	}
}
