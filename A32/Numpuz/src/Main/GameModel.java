package Main;
/**
 * GameModel Class 
 * @author Jay Patel
 *
 */
public class GameModel {
	
	/**
	 * variable for getting default dimnesion
	 */
	private int gridDim=3;
	private int points;
	private int moves;
	private int[] gridTiles;
	/**
	 * Default Constructor
	 */
	GameModel()
	{
		
	}
	/**
	 * get method for gridDim
	 * @return gridDim return default dimension
	 */
	public int getGridDim() {
		return gridDim;
	}
	/**
	 * set method for gridDim
	 * @param gridDim set default dimension
	 */
	public void setGridDim(int gridDim) {
		this.gridDim = gridDim;
	}

	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getMoves() {
		return moves;
	}
	public void setMoves(int moves) {
		this.moves = moves;
	}
	public int[] getGridTiles() {
		return gridTiles;
	}
	public void setGridTiles(int[] gridTiles) {
		gridTiles = new int[gridDim];
		this.gridTiles = gridTiles;
	}
}
