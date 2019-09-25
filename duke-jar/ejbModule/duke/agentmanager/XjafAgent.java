package duke.agentmanager;

import javax.ejb.Lock;
import javax.ejb.LockType;

@Lock(LockType.READ)
public abstract class XjafAgent implements Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1764776335375992332L;
	
	protected AID id;

}
