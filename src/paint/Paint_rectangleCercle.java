package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import forms.Arc;
import forms.Cercle;
import forms.Line;
import forms.Rectangle;
import forms.RoundRectangle;
import main.panelGraphic;



public class Paint_rectangleCercle {

	
	private int xd,yd;
	private panelGraphic applet;
	Graphics g;
	public Paint_rectangleCercle(panelGraphic appl) {
		applet=appl;
		g=applet.getGraphics();
	}

	
	public void init() {

		applet.addMouseListener(main.frame.mouseListener=new mouseadap());
		applet.addMouseMotionListener(main.frame.mouseMotionAdapter=new Dragueur());
	}
	
	
	
	
	public class mouseadap extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			
			xd=e.getX();
			yd=e.getY();
			Graphics g=applet.getGraphics();
			g.setColor(Color.red);
			g.fillRect(xd, yd, 5, 5);
		}
		@Override
		public void mouseReleased(MouseEvent e) {

			int x=e.getX();
			int y=e.getY();
			if(main.frame.forms=="arc") {
				Arc rec=new Arc(xd, yd, x, y,main.frame.type);
				applet.addelement(rec);
			}
			else
			if(main.frame.forms=="line") {
				Line rec=new Line(xd, yd, x, y);
				applet.addelement(rec);
			}
			else
			if(x>xd && y>yd) {
				if(main.frame.forms=="rectangle") {
					Rectangle rec=new Rectangle(xd, yd, x-xd, y-yd,main.frame.type);
					applet.addelement(rec);
				}
				else if(main.frame.forms=="cercle") {
					Cercle rec=new Cercle(xd, yd, x-xd, y-yd,main.frame.type);
					applet.addelement(rec);
				}
				else if(main.frame.forms=="arc") {
					Arc rec=new Arc(xd, yd, x-xd, y-yd,main.frame.type);
					applet.addelement(rec);
				}
				else if(main.frame.forms=="roundRect") {
					RoundRectangle rec=new RoundRectangle(xd, yd, x-xd, y-yd,main.frame.type);
					applet.addelement(rec);
				}
				 
				
			}
			else if(xd>x && y>yd) {
				if(main.frame.forms=="rectangle") {
					Rectangle rec=new Rectangle(x, yd, xd-x, y-yd,main.frame.type);
					applet.addelement(rec);
				}
				else if(main.frame.forms=="roundRect") {
					Cercle rec=new Cercle(x, yd, xd-x, y-yd,main.frame.type);
					applet.addelement(rec);
				}
				else if(main.frame.forms=="arc") {
					Arc rec=new Arc(x, yd, xd-x, y-yd,main.frame.type);
					applet.addelement(rec);
				}
				else if(main.frame.forms=="roundRect") {
					RoundRectangle rec=new RoundRectangle(x, yd, xd-x, y-yd,main.frame.type);
					applet.addelement(rec);
				}
				
				
			}
			else if(xd>x && yd>y) {
				if(main.frame.forms=="rectangle") {
					Rectangle rec=new Rectangle(x, y, xd-x, yd-y,main.frame.type);
					applet.addelement(rec);
				}
				else if(main.frame.forms=="cercle") {
					Cercle rec=new Cercle(x, y, xd-x, yd-y,main.frame.type);
					applet.addelement(rec);
				}
				else if(main.frame.forms=="arc") {
					Arc rec=new Arc(x, y, xd-x, yd-y,main.frame.type);
					applet.addelement(rec);
				}
				else if(main.frame.forms=="roundRect") {
					RoundRectangle rec=new RoundRectangle(x, y, xd-x, yd-y,main.frame.type);
					applet.addelement(rec);
				}
				
				
			}
			else if(x>xd && yd>y) {
				if(main.frame.forms=="rectangle") {
					Rectangle rec=new Rectangle(xd, y, x-xd, yd-y,main.frame.type);
					applet.addelement(rec);
				}
				else if(main.frame.forms=="cercle") {
					Cercle rec=new Cercle(xd, y, x-xd, yd-y,main.frame.type);
					applet.addelement(rec);
				}
				
				else if(main.frame.forms=="roundRect") {
					RoundRectangle rec=new RoundRectangle(xd, y, x-xd, yd-y,main.frame.type);
					applet.addelement(rec);
				}	
				
			}
			
		}


	}
	class Dragueur extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e) {
		int x = e.getX(), y = e.getY();
		//Line l=new Line(xd,yd,x,y);
		
		
		
		}
		}
	
}
