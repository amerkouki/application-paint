package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class AdapterColor extends MouseAdapter{

	JPanel panelColor;
	public AdapterColor(JPanel panel) {
		this.panelColor=panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		main.frame.panellblColor.setBackground(panelColor.getBackground());
	}
}
