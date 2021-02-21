package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import engine.map.Block;
import engine.map.Map;
import engine.mobile.Car;
import engine.mobile.Loot;
import engine.mobile.MovableCharacter;
import engine.mobile.MovableCharacter2;
import engine.mobile.MovableCharacter3;
import engine.statique.Building;


public class PaintStrategy {
	public void paint(Map map, Graphics graphics) {
		
		Image image2;
		ImageIcon i2 = new ImageIcon("img/Map1.png");
	    image2 = i2.getImage();
	    graphics.drawImage(image2, 0, 0, (ResponsiveMode.screenWidth-ResponsiveMode.screenWidth/12), 
	    				                 (ResponsiveMode.screenHeight)-(ResponsiveMode.screenHeight/5),
	    				                  null);
		
	}
	
	public void paint(MovableCharacter movableCharacter, Graphics graphics) {
		Block position = movableCharacter.getPosition();
		int responsiveBlockSize = ResponsiveMode.RESPONSIVE_BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		Image character1;
		ImageIcon char1 = new ImageIcon("img/character1.png");
		character1 = char1.getImage();

		graphics.drawImage(character1,x * responsiveBlockSize, y * responsiveBlockSize, 2*responsiveBlockSize, 2*responsiveBlockSize, null);
		

	}
	
	public void paint(MovableCharacter2 movableCharacter2, Graphics graphics) {
		Block position = movableCharacter2.getPosition();
		int responsiveBlockSize = ResponsiveMode.RESPONSIVE_BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		Image character1;
		ImageIcon char1 = new ImageIcon("img/character1.png");
		character1 = char1.getImage();

		graphics.drawImage(character1,x * responsiveBlockSize, y * responsiveBlockSize, 2*responsiveBlockSize, 2*responsiveBlockSize, null);
		

	}
	
	
	public void paint(MovableCharacter3 movableCharacter3, Graphics graphics) {
		Block position = movableCharacter3.getPosition();
		int responsiveBlockSize = ResponsiveMode.RESPONSIVE_BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		Image character1;
		ImageIcon char1 = new ImageIcon("img/character1.png");
		character1 = char1.getImage();

		graphics.drawImage(character1,x * responsiveBlockSize, y * responsiveBlockSize, 2*responsiveBlockSize, 2*responsiveBlockSize, null);
		

	}
	

	public void paint(Car car, Graphics graphics) {
		Block position = car.getPosition();
		int responsiveBlockSize = ResponsiveMode.RESPONSIVE_BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		Image car1;
		ImageIcon char1 = new ImageIcon("img/car/car1_bot.png");
		car1 = char1.getImage();

		graphics.setColor(Color.RED);
		graphics.drawImage(car1,x * responsiveBlockSize, y * responsiveBlockSize, 2*responsiveBlockSize, 1*responsiveBlockSize, null);

	}
	
	public void paint(Building building, Graphics graphics) {
		Block position = building.getPosition();
		int responsiveBlockSize = ResponsiveMode.RESPONSIVE_BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		Color colorBuilding = new Color(0,0,1,0.2f) ;
		
		graphics.setColor(colorBuilding);
		graphics.fillRect(x * responsiveBlockSize, y * responsiveBlockSize, responsiveBlockSize, responsiveBlockSize);
	}

	public void paint(Loot loot, Graphics graphics) {
		Block position = loot.getPosition();
		int responsiveBlockSize = ResponsiveMode.RESPONSIVE_BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		Image fireSprite;
		ImageIcon fSprite = new ImageIcon("img/fireSprite.png");
	    fireSprite = fSprite.getImage();

		graphics.drawImage(fireSprite,x * responsiveBlockSize, y * responsiveBlockSize, 2*responsiveBlockSize, 2*responsiveBlockSize, null);
	}
	
}
