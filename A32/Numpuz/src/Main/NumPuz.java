/**
 * NumPuz.java
 * Jay Patel (041028206) / Neeraj Bansal()
 * CST 8221 - JAP, Lab Section: 301
 * Assignment: A12
 * Professor: Paulo Sousa
 * Date: 02-10-2022
 * Compiler: Eclipse IDE for Java Developers - Version: 2022-03 (4.23.0)
 * Purpose: The file contains the main class where the entire program begins 
 */

package Main;
/**
 * Class name: NumPuz
 * Methods List: main().
 * Constants List: 
 * Purpose: The program initilizes from this method
 * @version 1.0
 * @author Jay Patel
 * @since JDK 17
 */

public class NumPuz {
	/**
	 * object of GameModel declared as static
	 */
	public static GameModel model = new GameModel();
	/**
	 * object of GameView declared as static
	 */
	public static GameView view = new GameView();
	/**
	 * Method Name: main
	 * Purpose: it instantiate the object of the GameController
	 * Algorithm: the objection declaration invokes the constructor and program begins
	 * @param args string argument used for taking parameters for main method
	 */
	public static void main(String[] args) 
	{ 
		//view.new splashScreen();
		new GameController(model,view);
		
		
	}

}

