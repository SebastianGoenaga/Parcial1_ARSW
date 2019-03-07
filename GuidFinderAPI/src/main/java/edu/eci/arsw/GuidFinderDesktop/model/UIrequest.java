package edu.eci.arsw.GuidFinderDesktop.model;

import java.util.Date;
import java.util.UUID;

public class UIrequest {
	
	private UUID request;
	
	public UIrequest() {

	}
	
	public UUID getRequest() {
		return request;
	}
	
	public void setRequest(String request) {
		this.request = UUID.fromString(request);
	}
	
	
}
