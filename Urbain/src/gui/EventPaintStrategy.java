package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public class EventPaintStrategy {
	public static void paint(Graphics graphics) {
		Image eventBackground;
		ImageIcon eventBg = new ImageIcon("img/eventBackground2.png");
		eventBackground = eventBg.getImage();
		graphics.drawImage(eventBackground, 0, 0,(ResponsiveMode.screenWidth/12), 
		        (ResponsiveMode.screenHeight-ResponsiveMode.screenHeight/5),
		         null);

	}
	
}	


