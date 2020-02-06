
package lab2.level;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class LevelGUI implements Observer {
	
	public Level lv;
	private Display d;
	
	public LevelGUI(Level level, String name) {
		
		this.lv = level;
		
		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TODO: You should change 200 to a value 
		// depending on the size of the level
		d = new Display(lv,1000,500);
		
		frame.getContentPane().add(d);
		frame.pack();
		frame.setLocation(0,0);
		frame.setVisible(true);
		
		lv.addObserver(this);
	}
	
	
	public void update(Observable arg0, Object arg1) {
		d.repaint();
	}
	
	private class Display extends JPanel {
		
		private Level fp;
		
		
		public Display(Level fp, int x, int y) {
		
			this.fp = fp;
			addKeyListener(new Listener());
			
			setBackground(Color.gray);
			setPreferredSize(new Dimension(x+20,y+20));
			setFocusable(true);
		}
	
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i = 0; i < fp.rooms.size(); i++) {
				drawRoom(g, fp.rooms.get(i));
				drawSouth(g, fp.rooms.get(i));
				drawNorth(g, fp.rooms.get(i));
				drawWest(g, fp.rooms.get(i));
				drawEast(g, fp.rooms.get(i));
				
			}
			drawPlayer(g, fp.player);
		}
		
		private void drawPlayer(Graphics g, Room player)
		{
			g.setColor(Color.white);
			g.fillOval((player.x + player.dx/2 - 10), (player.y + player.dx/2 - 10), 20, 20);
		}
		
		private void drawRoom(Graphics g, Room r){			
			if(fp.player == r)
			{
				g.setColor(Color.white);
				g.fillOval((r.x + r.dx/2 - 10), (r.y + r.dx/2 - 10), 20, 20);
			}
			g.setColor(r.color);		
			g.fillRect(r.x, r.y, r.dx, r.dy);
		}
		
		
		private void drawSouth(Graphics g, Room r)
		{
			g.setColor(Color.black);
			if(r.south != null)
			{
				g.drawLine((r.x + (r.dx/2)), (r.y + r.dy),
						(r.south.x + (r.south.dx/2)) , r.south.y);
				g.fillOval((r.x + (r.dx/2))-5, (r.y + r.dy)-5, 10, 10);
			}
			
		}
		
		private void drawNorth(Graphics g, Room r)
		{
			g.setColor(Color.black);
			if(r.north != null)
			{
				g.drawLine((r.x + (r.dx/2)), (r.y),
						(r.north.x + (r.north.dx/2)) , r.north.y+ r.north.dy);
				g.fillOval((r.x + (r.dx/2))-5, (r.y)-5, 10, 10);
			}
			
		}
		private void drawWest(Graphics g, Room r)
		{
			g.setColor(Color.black);
			if(r.west != null)
			{
				g.drawLine((r.x), (r.y + r.dy/2),
						(r.west.x + (r.west.dx)) , r.west.y + r.west.dy/2);
				g.fillOval((r.x)-5, (r.y + r.dy/2)-5, 10, 10);
			}
			
		}
		private void drawEast(Graphics g, Room r)
		{
			g.setColor(Color.black);
			if(r.east != null)
			{
				g.drawLine((r.x + (r.dx)), (r.y + r.dy/2),
						(r.east.x) , r.east.y + r.east.dy/2);
				g.fillOval((r.x + (r.dx))-5, (r.y + r.dy/2)-5, 10, 10);
			}
			
		}
		

		
		
	 	private class Listener implements KeyListener {
	 		
	 		public void keyPressed(KeyEvent ke) {
			    int key = ke.getKeyCode();
			    
			    switch(key)
			    {
			    case KeyEvent.VK_W:
			    	lv.moveNorth();
			    	break;
			    case KeyEvent.VK_A:
			    	lv.moveWest();
			    	break;
			    case KeyEvent.VK_S:
			    	lv.moveSouth();
			    	break;
			    case KeyEvent.VK_D:
			    	lv.moveEast();
			    	break;
			    default:
			    	System.out.println("Key is not supported");
			    	
			    }
			    
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

	 	}

	}
	
}