package edu.eci.arsw.GuidFinderDesktop.services;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.GuidFinderDesktop.model.UIrequest;
import edu.eci.arsw.GuidFinderDesktop.model.UIresponse;
import edu.eci.arsw.GuidFinderDesktop.persistence.GuidPersistence;
import edu.eci.arsw.GuidFinderDesktop.persistence.impl.VolatileMemory;

@Service
public class GuidServices {
	
	@Autowired
	private GuidPersistence vm;
	
	public List<UIresponse> getAll() {
		
		return vm.getAll();
		
	}
	
	public UIresponse consult(UIrequest uuid) {
		return null;
		
	}
	
	
}
