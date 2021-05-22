package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import forms.Polygone;
import forms.Polyline;
import main.panelGraphic;
import paint.Paint_rectangleCercle.mouseadap;

public class PaintPoly {

	private int xd,yd,nbrPoint,localenbr=0;
	private panelGraphic applet;
	ArrayList<Integer> x,y;

	public PaintPoly(panelGraphic appl) {
		this.applet=appl;
		this.nbrPoint=Integer.parseInt(main.frame.nbrPoint.getText());

		x=new ArrayList<Integer>();
		y=new ArrayList<Integer>();
	}


	public void init() {

		applet.addMouseListener(main.frame.mouseListener=new mouseadap());
		//applet.addMouseMotionListener(frame.mouseMotionAdapter=new Dragueur());
	}




	public class mouseadap extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {

			xd=e.getX();
			yd=e.getY();
			nbrPoint=Integer.parseInt(main.frame.nbrPoint.getText());
			Graphics g=applet.getGraphics();
			g.setColor(Color.red);
			g.fillRect(xd, yd, 5, 5);

		}
		@Override
		public void mouseReleased(MouseEvent e) {
			if(localenbr<nbrPoint-1) {
				x.add(e.getX());
				y.add(e.getY());

				localenbr++;
			}
			else {
				x.add(e.getX());
				y.add(e.getY());
				if(main.frame.forms=="polygone") 
				{
				Polygone p=new Polygone(x,y,main.frame.type);
				applet.addelement(p);
				}
				else
					if(main.frame.forms=="polyline") 
					{
					Polyline p=new Polyline(x,y);
					applet.addelement(p);
					}
				x.clear();
				y.clear();
				localenbr=0;
			}

		}
	}




	public int getLocalenbr() {
		return localenbr;
	}


	public void setLocalenbr(int localenbr) {
		this.localenbr = localenbr;
	}


	public ArrayList<Integer> getX() {
		return x;
	}


	public void setX(ArrayList<Integer> x) {
		this.x = x;
	}


	public ArrayList<Integer> getY() {
		return y;
	}


	public void setY(ArrayList<Integer> y) {
		this.y = y;
	};




}
