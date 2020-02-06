package lab2.level;

import java.util.ArrayList;
import java.util.Observable;
import lab2.level.Room;

public class Level extends Observable {

	public ArrayList<Room> rooms = new ArrayList<Room>();
	
	public Room player = null;

	public boolean place(Room r, int x, int y) {

		if (rooms.size() == 0) {
			r.x = x;
			r.y = y;
			rooms.add(r);
			return true;
		}
		for (int i = 0; i < rooms.size(); i++) {

			if ((x >= rooms.get(i).dx + rooms.get(i).dx || x+r.dx <= rooms.get(i).x) ||
					(y >= rooms.get(i).y + rooms.get(i).dy || y+r.dy <= rooms.get(i).y)
					) {
			} else {
				System.out.println("Flera rumm på samma kordinater");
				return false;
			}
		}
		r.x = x;
		r.y = y;
		rooms.add(r);
		return true;

	}

	public void firstLocation(Room r) {
		player = r;
	}

	public void moveSouth()
	{
		if(player.south != null) {
			player = player.south;
			change();
		}
		else
			System.out.println("There is no door to your south");
	}
	public void moveNorth()
	{
		if(player.north != null) {
			player = player.north;
			change();
		}
		else
			System.out.println("There is no door to your north");
	}
	public void moveWest()
	{
		if(player.west != null) {
			player = player.west;
			change();
		}
		else
			System.out.println("There is no door to your west");
	}
	public void moveEast()
	{
		if(player.east != null) {
			player = player.east;
			change();
		}
		else
			System.out.println("There is no door to your east");
	}
	
	private void change() {
		setChanged();
		notifyObservers();
	}
	
}