package forms;

import java.awt.Color;
import java.awt.Graphics;

public class Arc {

	private int x;
	private int y;
	private int dx;
	private int dy;
	private String ObjType;
	private Color color;
	public Arc() {
		// TODO Auto-generated constructor stub
	}
	public Arc(int x, int y, int dx, int dy,String ObjTyp) {
		super();
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.ObjType=ObjTyp;
		this.color=main.frame.panellblColor.getBackground();
	}

	public void dessiner(Graphics g) {
		if(ObjType=="draw") {g.setColor(this.color);g.drawArc(x, y, dx, dy, 10, 180);}
		else
			if(ObjType=="fill") {g.setColor(this.color);g.fillArc(x, y, dx, dy, 10, 180);}
		
	}

}
