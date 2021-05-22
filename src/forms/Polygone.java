package forms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public class Polygone {
	
	private Polygon poly;
	private String ObjType;
	private Color color;
	public Polygone() {
		// TODO Auto-generated constructor stub
	}
	public Polygone( ArrayList<Integer> lx,ArrayList<Integer> ly,String ObjTyp) {
		super();		
	    poly = new Polygon(convert(lx), convert(ly), lx.size());
		this.ObjType=ObjTyp;
		this.color=main.frame.panellblColor.getBackground();

	}

	public void dessiner(Graphics g) {
		if(ObjType=="fill") {g.setColor(this.color);g.fillPolygon(poly);}
		else
			if(ObjType=="draw") {g.setColor(this.color);g.drawPolygon(poly);}

	}

	private int[] convert(ArrayList<Integer> list) {
		int[] l=new int[list.size()];
		for(int i=0;i<list.size();i++) {
			l[i]=list.get(i);
		}
		return l;
	}

}
