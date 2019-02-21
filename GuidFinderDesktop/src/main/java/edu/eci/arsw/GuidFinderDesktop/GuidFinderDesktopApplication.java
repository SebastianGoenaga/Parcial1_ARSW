package edu.eci.arsw.GuidFinderDesktop;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Console;
import java.util.UUID;

import javax.xml.bind.Marshaller.Listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GuidFinderDesktopApplication {

	public static final int N_THREADS = 4;

	public static void main(String[] args) {
		
		new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

		};

		SpringApplication.run(GuidFinderDesktopApplication.class, args);

		try {
			UUID guid = UUID.fromString("d0692660-c39a-4d73-9496-d9df0c4ebdf3");

			for (int i = 0; i < N_THREADS + 1; i++) {
				GuidFinder finder = new GuidFinder(N_THREADS, i, guid);
				finder.start();
			}

			System.out.println(GuidFinder.countGuids());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
