package gui;

import java.awt.Graphics;

import javax.swing.JPanel;


public class HudDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		HudPaintStrategy.paint(g);

	}
}