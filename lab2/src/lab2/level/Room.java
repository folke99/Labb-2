package lab2.level;

import java.awt.Color;

public class Room {
	
	public int x;
	public int y;
	public int dx;
	public int dy;
	public Color color;
	public Room north = null;
	public Room east = null;
	public Room south = null;
	public Room west = null;
	
	
	public Room(int dx, int dy, Color color) {
		this.dx = dx;
		this.dy = dy;
		this.color = color;

		System.out.println("Dimensions: X x Y " + dx + " x " + dy + " floor color: " + color);
	}

	public void connectNorthTo(Room r) {
		if(this.north == null) {
			this.north = r;	
		}
	}
	public void connectEastTo(Room r) {
		if(this.east == null) {
			this.east = r;
		}
	}
	public void connectSouthTo(Room r) {
		if(this.south == null) {
			this.south = r;	
		}
	}
	public void connectWestTo(Room r) {
		if(this.west == null) {
			this.west = r;
		}
	}
}