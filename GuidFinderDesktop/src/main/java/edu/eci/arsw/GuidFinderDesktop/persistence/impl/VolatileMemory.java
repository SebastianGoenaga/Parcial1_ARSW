package edu.eci.arsw.GuidFinderDesktop.persistence.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.arsw.GuidFinderDesktop.GuidFinder2;
import edu.eci.arsw.GuidFinderDesktop.model.UIrequest;
import edu.eci.arsw.GuidFinderDesktop.model.UIresponse;
import edu.eci.arsw.GuidFinderDesktop.persistence.GuidPersistence;

@Component("vm")
public class VolatileMemory implements GuidPersistence{
	
	@Autowired
	GuidFinder2 guidFinder;
	List<UIresponse> responses = new LinkedList<UIresponse>();
	
	
	@Override
	public List<UIresponse> getAll() {
		return responses;
	}

	@Override
	public UIresponse consult(UIrequest request) {
		UIresponse response = new UIresponse(guidFinder.consult(request.getRequest()), new Date(), request.getRequest());
		responses.add(response);	
		return response;
		
	}
	
	
	
	
	
}
