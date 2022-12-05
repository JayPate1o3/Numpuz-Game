/**
 * NumPuz.java
 * Jay Patel (041028206) / Neeraj Bansal()
 * CST 8221 - JAP, Lab Section: 301
 * Assignment: A12
 * Professor: Paulo Sousa
 * Date: 02-10-2022
 * Compiler: Eclipse IDE for Java Developers - Version: 2022-03 (4.23.0)
 * Purpose: The files contains method for Frame creation and adding attributes into the Frame
 */
package Main;
/**
 * Class name: NumPuz
 * Methods List: main().
 * Constants List: actionPerformed
 * Purpose: The program initialises from this method
 * @author Jay Patel
 * @version 1.0	
 * @since JDK 17
 */
/**
 * @author Jay Patel
 *
 */
public class GameController {
	/**
	 * object of GameModel
	 */
	GameModel model = new GameModel();
	/**
	 * object of GameView
	 */
	GameView view= new GameView();
	/**
	 * 
	 * @param model - object of GameModel
	 * @param view - object of GameView
	 */
	public GameController(GameModel model, GameView view)
	{
		this.view=view;
		this.model=model;
		view.setVisible(true);
	}
	
}

