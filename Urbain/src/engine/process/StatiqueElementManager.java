package engine.process;

import java.util.ArrayList;
import java.util.List;

import engine.map.Block;
import engine.map.Map;
import engine.statique.Building;

public class StatiqueElementManager {
	private Map map;

	private List<Building> buildings = new ArrayList<Building>();

	public StatiqueElementManager(Map map) {
		this.setMap(map);
	}
	

	public void add(Building Building) {
		buildings.add(Building);
	}

	public boolean generateBuilding() {
		
			for (int choseColumn = 9; choseColumn<18 ; choseColumn++ ) {
				for (int choseLine = 12; choseLine<22 ; choseLine++ ) {
						Block position = new Block(choseLine, choseColumn);
						Building Building = new Building(position);
						add(Building);
				}
			}
			return false;
	}
	
	public void wallBuilding() {
		
		if(generateBuilding() == true) { 
			
		}
		
	}
			
	public List<Building> getBuildings() {
		return buildings;
	}


	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		this.map = map;
	}

}
	
	