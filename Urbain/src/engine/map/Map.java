package engine.map;


public class Map {
	private Block[][] blocks;

	private double lineCount;
	private double columnCount;

	public Map(double responsiveLineCount, double responsiveColumnCount) {
		this.lineCount = responsiveLineCount;
		this.columnCount = responsiveColumnCount;

		blocks = new Block[(int) responsiveLineCount][(int) responsiveColumnCount];

		for (int lineIndex = 0; lineIndex < responsiveLineCount; lineIndex++) {
			for (int columnIndex = 0; columnIndex < responsiveColumnCount; columnIndex++) {
				blocks[lineIndex][columnIndex] = new Block(lineIndex, columnIndex);
			}
		}
	}

	public Block[][] getBlocks() {
		return blocks;
	}

	public double getLineCount() {
		return lineCount;
	}

	public double getColumnCount() {
		return columnCount;
	}

	public Block getBlock(int line, int column) {
		return blocks[line][column];
	}

	public boolean isOnTop(Block block) {
		int line = block.getLine();
		return line == 0;
	}

	public boolean isOnBottom(Block block) {
		int line = block.getLine();
		return line == lineCount - 1;
	}

	public boolean isOnLeftBorder(Block block) {
		int column = block.getColumn();
		return column == 0;
	}

	public boolean isOnRightBorder(Block block) {
		int column = block.getColumn();
		return column == columnCount - 1;
	}

	public boolean isOnBorder(Block block) {
		return isOnTop(block) || isOnBottom(block) || isOnLeftBorder(block) || isOnRightBorder(block);
	}

	public Block getBlock(double d, double e) {
		return null;
	}

}
