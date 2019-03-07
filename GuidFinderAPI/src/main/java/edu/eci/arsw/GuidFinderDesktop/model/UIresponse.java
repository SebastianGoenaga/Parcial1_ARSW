package edu.eci.arsw.GuidFinderDesktop.model;

import java.util.Date;
import java.util.UUID;

public class UIresponse {
	
	private int count;
	private Date fecha;
	private UUID consulted;
	
	public UIresponse(int count, Date fecha, UUID uuid) {
		this.count = count;
		this.consulted = uuid;
		this.fecha = fecha;
	}
	
	public int getCount() {
		return count;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public UUID getConsulted() {
		return consulted;
	}
	
	
}
