package engine.process;

import java.util.ArrayList;
import java.util.List;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Car;
import engine.mobile.Loot;
import engine.mobile.MovableCharacter;
import engine.mobile.MovableCharacter2;
import engine.mobile.MovableCharacter3;
import gui.ResponsiveMode;


public class MobileElementManager {
	private Map map;

	private MovableCharacter movableCharacter;
	private MovableCharacter2 movableCharacter2;
	private MovableCharacter3 movableCharacter3;
	
	private List<Car> cars = new ArrayList<Car>();
	private List<Loot> loots = new ArrayList<Loot>();

	public MobileElementManager(Map map) {
		this.map = map;
	}
	
	public void set(MovableCharacter movableCharacter) {
		this.movableCharacter = movableCharacter;
	}
	
	public void set(MovableCharacter2 movableCharacter2) {
		this.movableCharacter2 = movableCharacter2;
	}
	
	public void set(MovableCharacter3 movableCharacter3) {
		this.movableCharacter3 = movableCharacter3;
	}
	

	public void add(Car car) {
		cars.add(car);
	}
	
	public void add(Loot loot) {
		loots.add(loot);
	}


	public void nextRound() {
		
		generateCar();
		moveCars();
		moveLoots();
		lootEffect();
		
	}

	public void moveLeftMovableCharacter() {
		Block position = movableCharacter.getPosition();

		if (position.getColumn() > 0) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
			movableCharacter.setPosition(newPosition);
		}

	}

	
	public void moveRightMovableCharacter() {
        Block position = movableCharacter.getPosition();

        if (position.getColumn() < ResponsiveMode.RESPONSIVE_COLUMN_COUNT - (ResponsiveMode.responsiveWidth)/100) {
            Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
            movableCharacter.setPosition(newPosition);
        }
    }
	
	
	
	public void moveUpMovableCharacter() {
		Block position = movableCharacter.getPosition();

		if (position.getLine() < ResponsiveMode.RESPONSIVE_LINE_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
			movableCharacter.setPosition(newPosition);
		}
	}
	
	
	public void moveDownMovableCharacter() {
        Block position = movableCharacter.getPosition();

        if (position.getLine() < ResponsiveMode.RESPONSIVE_LINE_COUNT - (ResponsiveMode.responsiveHeight)/45) {
            Block newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
            movableCharacter.setPosition(newPosition);
        }
    }
	
	
	
	
	public void moveLeftMovableCharacter2() {
		Block position = movableCharacter2.getPosition();

		if (position.getColumn() > 0) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
			movableCharacter2.setPosition(newPosition);
		}

	}

	public void moveRightMovableCharacter2() {
		Block position = movableCharacter2.getPosition();

		if (position.getColumn() < ResponsiveMode.RESPONSIVE_COLUMN_COUNT - (ResponsiveMode.responsiveWidth)/100) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
			movableCharacter2.setPosition(newPosition);
		}
	}
	
	public void moveUpMovableCharacter2() {
		Block position = movableCharacter2.getPosition();

		if (position.getLine() < ResponsiveMode.RESPONSIVE_LINE_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
			movableCharacter2.setPosition(newPosition);
		}
	}
	
	public void moveDownMovableCharacter2() {
		Block position = movableCharacter2.getPosition();

		if (position.getLine() < ResponsiveMode.RESPONSIVE_LINE_COUNT - (ResponsiveMode.responsiveHeight)/45) {
			Block newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
			movableCharacter2.setPosition(newPosition);
		}
	}

	
	public void moveLeftMovableCharacter3() {
		Block position = movableCharacter3.getPosition();

		if (position.getColumn() > 0) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
			movableCharacter3.setPosition(newPosition);
		}

	}

	public void moveRightMovableCharacter3() {
		Block position = movableCharacter3.getPosition();

		if (position.getColumn() < ResponsiveMode.RESPONSIVE_COLUMN_COUNT - (ResponsiveMode.responsiveWidth)/100) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
			movableCharacter3.setPosition(newPosition);
		}
	}
	
	public void moveUpMovableCharacter3() {
		Block position = movableCharacter3.getPosition();

		if (position.getLine() < ResponsiveMode.RESPONSIVE_LINE_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
			movableCharacter3.setPosition(newPosition);
		}
	}
	
	public void moveDownMovableCharacter3() {
		Block position = movableCharacter3.getPosition();

		if (position.getLine() < ResponsiveMode.RESPONSIVE_LINE_COUNT - (ResponsiveMode.responsiveHeight)/45) {
			Block newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
			movableCharacter3.setPosition(newPosition);
		}
	}
	
	
	private void generateCar() {
		
		Block block = map.getBlock(1, 62);
		Car car = new Car(block);
		add(car);
		for (int numberCars=1; numberCars<4; numberCars++) {
			try {
				Thread.sleep(GameConfiguration.CAR_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	

	private void moveCars() {

		List<Car> outOfBoundCars = new ArrayList<Car>();

		for (Car car : cars) {
			Block position = car.getPosition();

			if (!map.isOnBottom(position)) {
				Block newPosition = map.getBlock(position.getLine() + 3, position.getColumn());
				car.setPosition(newPosition);
			} else {
				outOfBoundCars.add(car);
			}

		}

		for (Car car : outOfBoundCars) {
			cars.remove(car);
		}
		
	}
		
	
	private void moveLoots() {
		List<Loot> outOfBoundLoots = new ArrayList<Loot>();

		for (Loot loot : loots) {
			Block position = loot.getPosition();

			if (!map.isOnTop(position)) {
				Block newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
				loot.setPosition(newPosition);
			} else {
				outOfBoundLoots.add(loot);
			}

		}

		for (Loot loot : outOfBoundLoots) {
			loots.remove(loot);
		}
	}
	
	public void generateLoot() {
		Block position = movableCharacter.getPosition();
		Loot loot = new Loot(position);
		add(loot);

	}
	
	private void lootEffect() {
		List<Car> eliminatedCars = new ArrayList<Car>();
		for (Loot loot : loots) {
			Block lootPosition = loot.getPosition();
			for (Car car : cars) {
				if (car.getPosition().equals(lootPosition)) {
					eliminatedCars.add(car);
				}
			}
		}
		for (Car car : eliminatedCars) {
			cars.remove(car);
		}
	}

	public MovableCharacter getMovableCharacter() {
		return movableCharacter;
	}
	public MovableCharacter2 getMovableCharacter2() {
		return movableCharacter2;
	}
	public MovableCharacter3 getMovableCharacter3() {
		return movableCharacter3;
	}

	public List<Car> getCars() {
		return cars;
	}
	
	public List<Loot> getLoots() {
		return loots;
	}


	
}
