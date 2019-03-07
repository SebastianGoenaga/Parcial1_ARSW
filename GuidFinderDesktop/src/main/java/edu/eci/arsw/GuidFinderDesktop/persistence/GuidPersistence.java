package edu.eci.arsw.GuidFinderDesktop.persistence;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import edu.eci.arsw.GuidFinderDesktop.model.UIrequest;
import edu.eci.arsw.GuidFinderDesktop.model.UIresponse;

public interface GuidPersistence {
	
	
	public List<UIresponse> getAll();
	
	public UIresponse consult(UIrequest request);
	
	
}
