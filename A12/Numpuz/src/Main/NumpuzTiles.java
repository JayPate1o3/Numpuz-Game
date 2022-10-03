/**
 * NumPuz.java
 * Jay Patel (041028206) / Neeraj Bansal()
 * CST 8221 - JAP, Lab Section: 301
 * Assignment: A12
 * Professor: Paulo Sousa
 * Date: 02-10-2022
 * Compiler: Eclipse IDE for Java Developers - Version: 2022-03 (4.23.0)
 * Purpose: The files contains method for maintaining and creation of tiles in the grids of the game
 */
package Main;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.*;
/**
 * Class name: Numpuz
 * Methods List: main().
 * Constants List: numpuz,newGame,isSolvable,shuffle,reset,isSolved,drawGrid,drawStartMessage,drawCenteredString,paintComponent
 * Purpose: The class groups the attributes and method regarding the tiles creation based on given dimension and type
 * @version 1.0
 * @author Jay Patel
 * @see Game
 * @since JDK 17
 */
public class NumpuzTiles extends JPanel{

	/**
	 * Basic serial version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * size of the grid 
	 */
	private int size;
	/**
	 *  number of required buttons
	 */
	private int nbTiles;
	/**
	 * button dimension
	 */
	private int dimension;
	/**
	 * color combination
	 */
	private static final Color FOREGROUND_COLOR = new Color(255,235,205);
	/**
	 * random number generation
	 */
	private static final Random RANDOM = new Random();
	/**
	 * tile array
	 */
	private int[] tiles;
	/**
	 * tile size in px
	 */
	private int tileSize;
	/**
	 * tile string in px
	 */
	private int[] tilesString;
	/**
	 * empty position
	 */
	private int blankPosition;
	/**
	 * margin value in px
	 */
	private int margin;
	/**
	 * grid size 
	 */
	private int gridSize;
	/**
	 * status of game
	 */
	private boolean gameOver;
	/**
	 * input type
	 */
	private boolean valueType;

	/**
	 * Method Name: numpuz
	 * Purpose: it used to take care about the initialising of the grid size and dimension
	 * Algorithm: It takes the values from parameters and creates the grid according to the requirement
	 * @param size value for the n x n grid
	 * @param dim dimension of the grid in px
	 * @param mar margin value in px
	 */
	public void numpuz(int size, int dim, int mar, int[] tiles, boolean type) {
		this.size = size;
		dimension = dim;
		margin = mar;
		valueType = type;
		
		tilesString = new int[size*size];
		
		for (int i = 0; i<size*size; i++) {
			tilesString[i] = tiles[i];
		}
		
		nbTiles = size * size -1;
		this.tiles = tiles;
		for (int i = 0; i< tiles.length; i++) {
			System.out.println(tiles[i]);
		}
		//tiles = new int[size * size];
		
		gridSize = (dim -2 * margin);
		tileSize = gridSize / size;
		
		this.setPreferredSize(new Dimension(dimension, dimension + margin));
		this.setForeground(FOREGROUND_COLOR);
		this.setBackground(new Color(139,69,19));
		
		gameOver  = true;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//used to let user click on grid
				if (gameOver) {
				      newGame();
				    } else {
				      // get position of the click
				      int ex = e.getX() - margin;
				      int ey = e.getY() - margin;

				      // click in the grid ?
				      if (ex < 0 || ex > gridSize  || ey < 0  || ey > gridSize)
				        return;

				      // get position in the grid
				      int c1 = ex / tileSize;
				      int r1 = ey / tileSize;

				      // get position of the blank cell
				      int c2 = blankPosition % size;
				      int r2 = blankPosition / size;

				      // we convert in the 1D coord 
				      int clickPos = r1 * size + c1;

				      int dir = 0;

				      // we search direction for multiple tile moves at once
				      if (c1 == c2  &&  Math.abs(r1 - r2) > 0)
				        dir = (r1 - r2) > 0 ? size : -size;
				      else if (r1 == r2 && Math.abs(c1 - c2) > 0)
				        dir = (c1 - c2) > 0 ? 1 : -1;

				      if (dir != 0) {
				        // we move tiles in the direction
				        do {
				          int newBlankPos = blankPosition + dir;
				          tiles[blankPosition] = tiles[newBlankPos];
				          blankPosition = newBlankPos;
				        } while(blankPosition != clickPos);

				        tiles[blankPosition] = 0;
				      }

				      // we check if game is solved
				      gameOver = isSolved();
				    }

				    // we repaint panel
				    repaint();
			}
		});
		
		newGame();
		}
	
	/**
	 * Method Name: newGame()
	 * Purpose: it reset the grid by randomizing numbers
	 * Algorithm: calls the method to perform the function
	 */
	private void newGame() {
		do {
			reset();
			shuffle();
		}while(!isSolvable());
		
		gameOver = false;
	}
	
	/**
	 * Method Name: isSolvable()
	 * Purpose: Check for solution and count inversions
	 * Algorithm: count inversions using nested for loops and return boolean
	 * @return boolean true/false
	 */
	private boolean isSolvable() {
		int countInversions = 0;
		
		for(int i = 0; i<nbTiles; i++) {
			for(int j =0; j<i;j++) {
				if(tiles[j] > tiles[i]) 
					countInversions++;
			}
		}
		return countInversions % 2 == 0;
	}

	/**
	 * Method Name: shuffle()
	 * Purpose: create random digits and store in tiles array
	 * Algorithm: randomize tiles uing temporary locations in array
	 */
	private void shuffle() {
		int n = nbTiles;
		
		while(n > 1) {
			int r = RANDOM.nextInt(n--);
			int tmp = tiles[r];
			tiles[r] = tiles[n];
			tiles[n] = tmp;
		}
		
	}

	/**
	 * Method Name: reset()
	 * Purpose: reset the tiles for new Game or new dimension
	 * Algorithm: reset the tiles for new Game or new dimension using array length
	 */
	private void reset() {
		for(int i = 0; i<tiles.length; i++) {
			tiles[i] = (i+1) % tiles.length;
		}
		blankPosition = tiles.length - 1;
	}
	
	/**
	 * Method Name: isSolved()
	 * Purpose: check for solve solution
	 * Algorithm: true for matched soloution and false for not
	 * @return boolean
	 */
	private boolean isSolved() {
		if (tiles[tiles.length - 1] != 0) {
			return false;
		}
		
		for (int i = nbTiles - 1; i >= 0; i--) {
			if (tiles[i] != i+1)
				return false;
		}
		
		return true;
	}
	/**
	 * Method Name: drawGrid()
	 * Purpose: draw grid for tiles
	 * Algorithm: convert 1D array to 2D and call functions for tile creation and text in it
	 * @param g for graphics class
	 */
	private void drawGrid(Graphics2D g) {
		  for (int i = 0; i < tiles.length; i++) {
		    // we convert 1D coords to 2D coords given the size of the 2D Array
		    int r = i / size;
		    int c = i % size;
		    // we convert in coords on the UI
		    int x = margin + c * tileSize;
		    int y = margin + r * tileSize;

		    // check special case for blank tile
		    if(tiles[i] == 0) {
		      if (gameOver) {
		        g.setColor(FOREGROUND_COLOR);
		        drawCenteredString(g, "\u2713", x, y);
		      }

		      continue;
		    }
		    // for other tiles
		    g.setColor(getForeground());
		    g.fillRoundRect(x, y, tileSize, tileSize, 25, 25);
		    g.setColor(Color.BLACK);
		    g.drawRoundRect(x, y, tileSize, tileSize, 25, 25);
		    
		    if (valueType) {
		    	char tile = (char) this.tilesString[i];
		    	String value = "" + tile;
		    	System.out.println(tilesString[i]);
		    	drawCenteredString(g, value, x , y);
		    }
		    else {
		    	drawCenteredString(g, String.valueOf(tiles[i]), x , y);
		    }
		    
		  }
		}
	
	/**
	 * Method Name: drawStartMessage()
	 * Purpose: draw new game message
	 * Algorithm: check for game solved and reshuffle on new Game click
	 * @param g for graphics class
	 */
	private void drawStartMessage(Graphics2D g) {
		  if (gameOver) {
		    g.setFont(getFont().deriveFont(Font.BOLD, 18));
		    g.setColor(FOREGROUND_COLOR);
		    String ng = "New Game";
//		    JButton newGame = new JButton(ng);
		    g.drawString(ng, (getWidth() - g.getFontMetrics().stringWidth(ng)) / 2,
		        getHeight() - margin);
		  }
		}

		/**
		 * Method Name:drawCenteredString()
		 * Purpose: place string at centre
		 * Algorithm: place text using font metrics in tile's dimension
		 * @param g for graphics class
		 * @param s for text inside tile
		 * @param x for X-dimension
		 * @param y for X-dimension
		 */
		private void drawCenteredString(Graphics2D g, String s, int x, int y) {
		  // center string s for the given tile (x,y)
		  FontMetrics fm = g.getFontMetrics();
		  int asc = fm.getAscent();
		  int desc = fm.getDescent();
		  g.drawString(s,  x + (tileSize - fm.stringWidth(s)) / 2, 
		      y + (asc + (tileSize - (asc + desc)) / 2));
		}

		/**
		 * Method: paintComponent()
		 * Purpose: helps in rendering for tiles
		 * Algorithm: Using Graphics class hints and methods got call
		 * @param g for graphics class
		 */
		@Override
		protected void paintComponent(Graphics g) {
		  super.paintComponent(g);
		  Graphics2D g2D = (Graphics2D) g;
		  g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		  drawGrid(g2D);
		  drawStartMessage(g2D);
		}
}