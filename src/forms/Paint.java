package forms;

import java.awt.Graphics;
import java.util.ArrayList;

public class Paint {
	private ArrayList<Line> obj;
	
	public Paint() {
		obj=new ArrayList<Line>();
	}

	public void  addelement(Line l) {
		obj.add(l);
	}
	public void undo() {
		obj.remove(obj.size()-1);
	}
	
	public void dessiner(Graphics g) {
		for(Line o: obj) {
			o.dessiner(g);
		}
	}
}
