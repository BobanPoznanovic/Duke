package duke.messagemanager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(MessageManager.class)
@LocalBean
public class MessageManagerBean implements MessageManager{

	@Override
	public List<String> getPerformatives() {
		// TODO Auto-generated method stub
		Performative[] performatives = Performative.values();
		
		List<String> retVal = new ArrayList<String>();
		
		for (Performative p : performatives) {
			retVal.add(p.toString());
		}
		
		return retVal;
	}

	@Override
	public void post(ACLMessage message) {
		// TODO Auto-generated method stub
		
	}

}
