package main;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import forms.Line;



public class Paint {

	public Paint() {
		// TODO Auto-generated constructor stub
	}

	int xd, yd;
	private panelGraphic panel;
	forms.Paint listPaint;
	public Paint(panelGraphic pn) {
		panel=pn;
	}
	
	public void init() {
		
		panel.addMouseListener(frame.mouseListener=new Appuyeur());
		panel.addMouseMotionListener(frame.mouseMotionAdapter=new Dragueur());
	}
	
	class Appuyeur extends MouseAdapter {
	public void mousePressed(MouseEvent e) {
	xd = e.getX(); yd = e.getY();
	listPaint=new forms.Paint();
	
	}
	@Override
		public void mouseReleased(MouseEvent e) {
			panel.addelement(listPaint);
		}
	}
	class Dragueur extends MouseMotionAdapter {
	public void mouseDragged(MouseEvent e) {
	int x = e.getX(), y = e.getY();
	Line l=new Line(xd,yd,x,y);
	listPaint.addelement(l);
	Graphics g=panel.getGraphics();
	g.drawLine(xd, yd, x, y);
	xd = x; yd = y;
	}
	}
}
