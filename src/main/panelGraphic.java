package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.RepaintManager;

import forms.Arc;
import forms.Cercle;
import forms.Line;
import forms.Paint;
import forms.Polygone;
import forms.Polyline;
import forms.Rectangle;
import forms.RoundRectangle;

public class panelGraphic extends JPanel{

	private ArrayList<Object> obj;
	
	public panelGraphic() {
		obj =new ArrayList<Object>();
	}
	
	public void addelement(Object r) {
		obj.add(r);	
		repaint();	
	}
	public void reflesh() {repaint();}
	public void undo() {
		if(obj.size()>0) {		
		obj.remove(obj.size()-1);
		repaint();
		}
		
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for(Object re: obj) {
			if(re.getClass().getName()=="forms.Rectangle") {
				((Rectangle) re).dessiner(g);
			}
			else if(re.getClass().getName()=="forms.Cercle") {
				((Cercle) re).dessiner(g);
			}
			else if(re.getClass().getName()=="forms.Arc") {
				((Arc) re).dessiner(g);
			}
			else if(re.getClass().getName()=="forms.RoundRectangle") {
				((RoundRectangle) re).dessiner(g);
			}
			else if(re.getClass().getName()=="forms.Line") {
				((Line) re).dessiner(g);
			}
			else if(re.getClass().getName()=="forms.Polygone") {
				((Polygone) re).dessiner(g);
			}
			else if(re.getClass().getName()=="forms.Polyline") {
				((Polyline) re).dessiner(g);
			}
			else if(re.getClass().getName()=="forms.Paint") {
				((Paint) re).dessiner(g);
			}
			
		}
	}
	

	public ArrayList<Object> getObj() {
		return obj;
	}

	public void setObj(ArrayList<Object> rect) {
		this.obj = rect;
	}
	
}
