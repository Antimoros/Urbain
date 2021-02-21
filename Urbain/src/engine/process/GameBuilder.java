package engine.process;

import engine.map.Block;
import engine.map.Map;
import engine.mobile.MovableCharacter;
import engine.mobile.MovableCharacter2;
import engine.mobile.MovableCharacter3;
import gui.ResponsiveMode;

public class GameBuilder {

	public static Map buildMap() {
		return new Map(ResponsiveMode.RESPONSIVE_LINE_COUNT, ResponsiveMode.RESPONSIVE_COLUMN_COUNT);
	}

	public static MobileElementManager buildInitMobile(Map map) {
		MobileElementManager manager = new MobileElementManager(map);
		
		initializeMovableCharacter(map, manager);
		initializeMovableCharacter2(map, manager);
		initializeMovableCharacter3(map, manager);
		
		return manager;
	}
	
	public static StatiqueElementManager buildInitStatique (Map map) {
		StatiqueElementManager managerStatique = new StatiqueElementManager(map);
		
		return managerStatique;
	}
	
	private static void initializeMovableCharacter(Map map, MobileElementManager manager) {
		Block block = map.getBlock(1, 2);
		MovableCharacter movableCharacter = new MovableCharacter(block);
		manager.set(movableCharacter);
	}
	
	private static void initializeMovableCharacter2(Map map, MobileElementManager manager) {
		Block block = map.getBlock(2, 3);
		MovableCharacter2 movableCharacter2 = new MovableCharacter2(block);
		manager.set(movableCharacter2);
	}
	
	
	
	private static void initializeMovableCharacter3 (Map map, MobileElementManager manager) {
		Block block = map.getBlock(3, 4);
		MovableCharacter3 movableCharacter3 = new MovableCharacter3(block);
		manager.set(movableCharacter3);
	}
	
	

}
