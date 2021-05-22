package forms;

import java.awt.Color;
import java.awt.Graphics;

import main.frame;

public class Cercle {

	private int x;
	private int y;
	private int dx;
	private int dy;
	private String ObjType;
	private Color color;
	public Cercle() {
		// TODO Auto-generated constructor stub
	}
	public Cercle(int x, int y, int dx, int dy,String ObjTyp) {
		super();
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.ObjType=ObjTyp;
		this.color=main.frame.panellblColor.getBackground();
	}

	public void dessiner(Graphics g) {
		if(ObjType=="draw") {g.setColor(this.color);g.drawOval(x, y, dx, dy);}
		else
			if(ObjType=="fill") {g.setColor(this.color);g.fillOval(x, y, dx, dy);}
		
		
	}
}
