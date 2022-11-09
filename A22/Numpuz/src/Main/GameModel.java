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
}
