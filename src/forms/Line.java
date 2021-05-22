package forms;

import java.awt.Color;
import java.awt.Graphics;

public class Line {

	private int x;
	private int y;
	private int dx;
	private int dy;
	private Color color;
	public Line() {
		// TODO Auto-generated constructor stub
	}
	public Line(int x, int y, int dx, int dy) {
		super();
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.color=main.frame.panellblColor.getBackground();
	}

	public void dessiner(Graphics g) {
		g.setColor(this.color);
		g.drawLine(x, y, dx, dy);
		
	}
}
