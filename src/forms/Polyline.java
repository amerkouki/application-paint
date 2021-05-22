package forms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public class Polyline {

	int[] x;
	int[] y;
	private Color color;
	public Polyline() {}
	public Polyline( ArrayList<Integer> lx,ArrayList<Integer> ly) {
		super();	
		this.x=convert(lx);
		this.y=convert(ly);	
		this.color=main.frame.panellblColor.getBackground();
	}

	public void dessiner(Graphics g) {
		g.setColor(this.color);
		g.drawPolyline(x, y, x.length);
	}

	private int[] convert(ArrayList<Integer> list) {
		int[] l=new int[list.size()];
		for(int i=0;i<list.size();i++) {
			l[i]=list.get(i);
		}
		return l;
	}

}
