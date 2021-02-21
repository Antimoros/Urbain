package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public class HudPaintStrategy {
	public static void paint(Graphics graphics) {
		
		Image character1;
		ImageIcon char1 = new ImageIcon("img/character1.png");
		character1 = char1.getImage();
	    graphics.drawImage(character1, 280, 40,null);
	    
	    Image hudBackground;
		ImageIcon hudBg = new ImageIcon("img/HudBackground.png");
	    hudBackground = hudBg.getImage();
	    graphics.drawImage(hudBackground, 0, 0,(ResponsiveMode.screenWidth/2), 
                							   (ResponsiveMode.screenHeight/8),
                							    null);
	    
	    
	    Image hudBackgroundPart2;
        ImageIcon hudBgPart2 = new ImageIcon("img/HudBackground-Part-2.png");
        hudBackgroundPart2 = hudBgPart2.getImage();
        graphics.drawImage(hudBackgroundPart2, ResponsiveMode.screenWidth/2, 0,(ResponsiveMode.screenWidth/2), 
                                               (ResponsiveMode.screenHeight/8),
                                                null);
	}

}