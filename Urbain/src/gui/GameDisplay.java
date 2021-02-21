package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import engine.map.Map;
import engine.mobile.Car;
import engine.mobile.Loot;
import engine.mobile.MovableCharacter;
import engine.mobile.MovableCharacter2;
import engine.mobile.MovableCharacter3;
import engine.process.MobileElementManager;
import engine.process.StatiqueElementManager;
import engine.statique.Building;


public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private Map map;
	private MobileElementManager manager;
	private StatiqueElementManager managerStatique;
	private PaintStrategy paintStrategy = new PaintStrategy();

	public GameDisplay(Map map, MobileElementManager manager, StatiqueElementManager managerStatique) {
		this.map = map;
		this.manager = manager;
		this.managerStatique = managerStatique;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintStrategy.paint(map, g);
		
		MovableCharacter movableCharacter = manager.getMovableCharacter();
		paintStrategy.paint(movableCharacter, g);
		
		MovableCharacter2 movableCharacter2 = manager.getMovableCharacter2();
		paintStrategy.paint(movableCharacter2, g);
		
		MovableCharacter3 movableCharacter3 = manager.getMovableCharacter3();
		paintStrategy.paint(movableCharacter3, g);
		

		for (Car car : manager.getCars()) {
			paintStrategy.paint(car, g);
		}
		
		for (Building building : managerStatique.getBuildings()) {
			paintStrategy.paint(building, g);
		}
		
		for (Loot loot : manager.getLoots()) {
			paintStrategy.paint(loot, g);
		}

	}

}
