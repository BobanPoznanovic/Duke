package duke.messagemanager;

import java.util.List;

public interface MessageManager {

	List<String> getPerformatives();
	
	void post(ACLMessage message);
}
