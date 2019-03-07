package edu.eci.arsw.GuidFinderDesktop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.UUID;

import javax.imageio.event.IIOReadWarningListener;

import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component("guidFinder")
public class GuidFinder2 extends Thread {

	private LinkedList<UUID> guids;

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

	public GuidFinder2() {
		guids = getGuidsStatic();
	}

	public int consult(UUID uuid) {
		int count = 0;
		System.out.println();
		System.out.println();
		System.out.println(guids.toString());
		System.out.println();
		System.out.println();
		for (int i = 0; i < guids.size(); i++) {
			if (guids.get(i).toString().equals(uuid.toString())) {
				count++;
			}
		}
		return count;
	}

	public LinkedList<UUID> getGuidsStatic() {

		LinkedList<UUID> guids = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			UUID uuid = UUID.randomUUID();
			guids.add(uuid);
		}

		return guids;

	}

//	public UUID[] getGuids() {
//		return guids;
//	}

}
