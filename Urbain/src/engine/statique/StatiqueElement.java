package engine.statique;

import engine.map.Block;

public abstract class StatiqueElement {
	private Block position;

	public StatiqueElement(Block position) {
		this.position = position;
	}

	public Block getPosition() {
		return position;
	}

	public void setPosition(Block position) {
		this.position = position;
	}

}