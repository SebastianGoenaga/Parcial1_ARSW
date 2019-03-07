package edu.eci.arsw.GuidFinderDesktop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

import javax.imageio.event.IIOReadWarningListener;

public class GuidFinder extends Thread {

	private static UUID[] guids = GuidFinder.getGuids();
	
	private int ntrheads, sec, count;
	public static Integer countGlobal = 0;
	private UUID guidToFind;
	
	public GuidFinder(int n, int sec, UUID guid) throws Exception {
		
		ntrheads = n;
		this.sec = sec;
		this.guidToFind = guid;
	}
	
	@Override
	public void run() {
		
		int n = guids.length;
		
		int n1 = sec * (n/ntrheads);
		int n2 = (sec+1) * (n/ntrheads);
		
		//validar residuo
		
		for (int i = n1; i < n2 && i < guids.length; i++) {
			if (guids[i].equals(guidToFind)) {
				count++;
			}
		}
		
		synchronized (GuidFinder.countGlobal) {
			GuidFinder.countGlobal += count;
		}
		
		
	}
	
	public static int countGuids() {

		int count = 0;
		for (UUID uuid : guids) {
			if (uuid.equals(guidToFind)) {
				count++;
			}

		}
		return count;

	}

	public static UUID[] getGuids()  {

		if (guids == null) {
			 
			System.out.println("es nulo");
			FileInputStream fi;

			try {
				fi = new FileInputStream(new File("guids.eci"));
				ObjectInputStream oi = new ObjectInputStream(fi);

				guids = (UUID[]) oi.readObject();

				oi.close();
				fi.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		}

		return guids;

	}
	

}
