package forms;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle {

	private int x;
	private int y;
	private int dx;
	private int dy;
	private String ObjType;
	private Color color;
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}
	public Rectangle(int x, int y, int dx, int dy,String ObjTyp) {
		super();
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.ObjType=ObjTyp;
		this.color=main.frame.panellblColor.getBackground();
	}

	public void dessiner(Graphics g) {
		if(ObjType=="draw") {g.setColor(this.color);g.drawRect(x, y, dx, dy);}
		else
			if(ObjType=="fill") {g.setColor(this.color);g.fillRect(x, y, dx, dy);}
		
	}

}
