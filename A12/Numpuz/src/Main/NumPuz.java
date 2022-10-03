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

import java.io.IOException;

/**
 * Class name: NumPuz
 * Methods List: main().
 * Constants List: 
 * Purpose: The program initilizes from this method
 * @version 1.0
 * @author Jay Patel
 * @see Main
 * @since JDK 17
 */

public class NumPuz {

	/**
	 * Method Name: main
	 * Purpose: it instantiate the object of the GameController
	 * Algorithm: the objection declaration invokes the constructor and program begins
	 * @param args string argument used for taking parameters for main method
	 * @throws IOException
	 * @return void
	 */
	public static void main(String[] args) throws IOException
	{ 
		GameController gc = new GameController();
		gc.setVisible(true);
	}

}

