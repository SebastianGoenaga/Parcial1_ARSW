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

import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component("guidFinder")
public class GuidFinder2 extends Thread {

	private static UUID[] guids = GuidFinder2.getGuidsStatic();
	
	private int ntrheads, sec, count;
	public static Integer countGlobal = 0;
	private UUID guidToFind;
	
	public GuidFinder2(int n, int sec, UUID guid) throws Exception {
		
		ntrheads = n;
		this.sec = sec;
		this.guidToFind = guid;
	}
	
	public GuidFinder2(UUID uuid) {
		this.guidToFind = uuid;
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
		
		synchronized (GuidFinder2.countGlobal) {
			GuidFinder2.countGlobal += count;
		}
		
		
	}
	
//	public static int countGuids() {
//
//		int count = 0;
//		for (UUID uuid : guids) {
//			if (uuid.equals(guidToFind)) {
//				count++;
//			}
//
//		}
//		return countGlobal;
//
//	}
	
	public int consult(UUID uuid) {
		int count = 0;
		for (UUID uuid2 : guids) {
			if (uuid2.equals(uuid)) {
				count++;
			}
		}
		return count;
	}

	public static UUID[] getGuidsStatic()  {

		if (guids == null) {
			 
			System.out.println("es nulo");
			UUID[] guids = new UUID[10];
			for (int i = 0; i < 10; i++) {
				UUID uuid = UUID.randomUUID();
				guids[0] = uuid;
			}
			
		}

		return guids;

	}
	
	public UUID[] getGuids() {
		return guids;
	}
	

}
