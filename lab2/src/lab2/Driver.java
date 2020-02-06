package lab2;

import java.awt.Color;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;


public class Driver {

	public void run() {

		Level l1 = new Level();
		
		Room r1 = new Room(100,100, Color.red);
		Room r2 = new Room(100,100, Color.blue);
		Room r3 = new Room(100,100, Color.green);
		Room r4 = new Room(100,100, Color.magenta);
		Room r5 = new Room(100,100, Color.yellow);
		Room r6 = new Room(100,100, Color.orange);
		
		
		r1.connectEastTo(r2);
		r1.connectSouthTo(r4);
		r2.connectSouthTo(r5);
		r2.connectEastTo(r3);
		r3.connectSouthTo(r6);
		r4.connectNorthTo(r1);
		r5.connectWestTo(r4);
		r6.connectWestTo(r5);

		l1.place(r1, 30, 20);
		l1.place(r2, 230, 20);
		l1.place(r3, 430, 20);
		l1.place(r4, 30, 240);
		l1.place(r5, 230, 240);
		l1.place(r6, 430, 240);
		
		l1.firstLocation(r1);
		
		LevelGUI lg = new LevelGUI(l1, "level1");
		
		
		
		
	}

}
