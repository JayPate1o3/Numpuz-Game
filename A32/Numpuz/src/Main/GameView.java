package Main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

import javax.swing.*;

/**
 * GameView which implements majority of game's logic regarding graphics and backend working
 * @author Jay Patel
 *
 */
public class GameView extends JFrame implements ActionListener{

	/**
	 * Basic serial version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * panel for the grid 
	 */
	private JPanel gamePanel = new JPanel();
	/**
	 * panel for buttons and other components
	 */
	private JPanel sidePanel= new JPanel();
	/**
	 * panel for the menu and game info
	 */
	private JPanel menuPanel = new JPanel();
	/**
	 * panel for buttons
	 */
	public JPanel numpuzGamePanel = new JPanel();
	/**
	 * sub-panel for the partitioning component i.e. NumPuz Logo
	 */
	private JPanel sidePanelTop= new JPanel();
	/**
	 * sub-panel for partitioning component i.e buttons,radio button and dropdown menu
	 */
	private JPanel sidePanelCenter= new JPanel();
	/**
	 * sub-panel for partitioning component i.e textfield for movement record, reset button
	 */
	private JPanel sidePanelBottom= new JPanel();
	/**
	 * panel for user-input in type Text of the game
	 */
	private JPanel text = new JPanel();
	/**
	 * Textfield for text input
	 */
	private JTextField textInput = new JTextField();
	/**
	 * Textfield corresponding to move Label
	 */
	private JTextField moveTF = new JTextField(3);
	/**
	 * Textfield corresponding to point label
	 */
	private JTextField pointTF = new JTextField(3);
	/**
	 * Textfield regarding to the movement recording 
	 */
	private JTextField moveRecordTF = new JTextField();
	/**
	 * Textfield regarding to the time
	 */
	private JTextField timeTF = new JTextField(5);
	/**
	 * Button for the input of string in the type "Text"
	 */
	private JButton setButton = new JButton("Set");
	/**
	 * Dropdown menu for dimension selection
	 */
	public JComboBox<Integer> dimSelect;
	/**
	 * Dropdown menu for game type selection
	 */
	public JComboBox<String> typeSelect;
	
	/**
	 * Button for gamelogo
	 */
	private JButton gameLogoButton = new JButton();
	/**
	 * Show  button
	 */
	private JButton showButton = new JButton("Show");
	/**
	 * hide button
	 */
	private JButton hideButton = new JButton("Hide");
	/**
	 * save button
	 */
	private JButton saveButton = new JButton("Save");
	/**
	 * load button
	 */
	private JButton loadButton = new JButton("Load");
	/**
	 * random button
	 */
	private JButton randButton = new JButton("Rand");
	/**
	 * finish button
	 */
	private JButton finishButton = new JButton("Finish");
	/**
	 * reset button
	 */
	private JButton resetButton = new JButton("Reset");
	/**
	 * game button in menu bar
	 */
	private JButton gameButton = new JButton("Game");
	/**
	 * help button in menu bar
	 */
	private JButton helpButton = new JButton("Help");
	
	/**
	 * label for mode
	 */
	private JLabel modeLabel = new JLabel("Mode: ");
	/**
	 * label for dim
	 */
	private JLabel dimLabel = new JLabel("Dim:");
	/**
	 * label for type
	 */
	private JLabel typeLabel = new JLabel("Type:");
	/**
	 * label for move
	 */
	private JLabel moveLabel = new JLabel("  Moves:");
	/**
	 * label for point
	 */
	private JLabel pointLabel = new JLabel("Points:");
	/**
	 * label for time
	 */
	private JLabel timeLabel = new JLabel("Time:");
	/**
	 * buttongroup object for gathering buttons into one group
	 */
	private ButtonGroup buttons = new ButtonGroup();	
	/**
	 * radiobutton for for design
	 */
	private JRadioButton designRadio = new JRadioButton();
	/**
	 * radiobutton for for play
	 */
	private JRadioButton playRadio = new JRadioButton();
	
	
	/**
	 * ImageIcon object for the game picture
	 */
	public ImageIcon game = new ImageIcon(GameView.class.getResource("/Images/game.png"));
	/**
	 * ImageIcon object for the game logo
	 */
	public ImageIcon gameLogo = new ImageIcon(GameView.class.getResource("/Images/gamelogo.png"));
	/**
	 * Constant for the game name
	 */
	private final String GAME_TITLE = "Numpuz";
	
	/**
	 * No argument constructor for the frame creation and adding other important elements
	 * @throws IOException for exception handling
	 */
	
	/**
	 * grid class object
	 */
	private gridTile grid = new gridTile();
	/**
	 * GameModel object
	 */
	private GameModel model= new GameModel();
	/**
	 * JmenuBar for menu bar 
	 */
	private JMenuBar menuBar = new JMenuBar();
	/**
	 * menu object for the menu-'game' 
	 */
	private JMenu gameMenu = new JMenu("Game");
	/**
	 * menu object for the menu-'help' 
	 */
	private JMenu helpMenu = new JMenu("Help");
	/**
	 * sub-menu item - new
	 */
	private JMenuItem newItem = new JMenuItem("New");
	/**
	 * sub-menu item - solution
	 */
	private JMenuItem solutionItem = new JMenuItem("Solution");
	/**
	 * sub-menu item - exit
	 */
	private JMenuItem exitItem = new JMenuItem("Exit");
	/**
	 * sub-menu item - colors
	 */
	private JMenuItem colorsItem = new JMenuItem("Colors");
	/**
	 * sub-menu item - about
	 */
	private JMenuItem aboutItem = new JMenuItem("About");
	/**
	 * imageicon object declaration - new
	 */
	private ImageIcon newIcon;
	/**
	 * imageicon object declaration - solution
	 */
	private ImageIcon solutionIcon;
	/**
	 * imageicon object declaration - exit
	 */
	private ImageIcon exitIcon;
	/**
	 * imageicon object declaration - about
	 */
	private ImageIcon aboutIcon;
	/**
	 * imageicon object declaration - colors
	 */
	private ImageIcon colorsIcon;
	/**
	 * progress bar object creation
	 */
	private JProgressBar progressBar = new JProgressBar();
	/**
	 * clock system constant 
	 */
	private final int clockConst= 60;
	/**
	 * variable for storing seconds
	 */
	private int seconds;
	/**
	 * variable for storing minutes
	 */
	private int minutes;
	/**
	 * variable for storing hours
	 */
	private int hours;
	/**
	 * variable for storing seconds used for formatting
	 */
	private String sec;
	/**
	 * variable for storing minutes used for formatting
	 */
	private String min;
	/**
	 * variable for storing hours used for formatting
	 */
	private String hrs;
	/**
	 * timer object for time counting
	 */
	private Timer time= new Timer(1000, this);
	private char[] stringToChar;
	private int[] charToInt;
	
	/**
	 * method to initiate time counting
	 */
	public void startTime()
	{
		time.setInitialDelay(0);
		
	    playRadio.addItemListener(new ItemListener() {

	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (playRadio.isSelected()) {
	            	  time.start();
	            } else {
	              
	                time.stop();
	               
	            }
	        }
	    });
		
		
	}
	/**
	 * method to stop time counting
	 */
	public void stopTime()
	{
		time.stop();
	}
	GameView()
	{
		Integer dim[] = {3,4,5,6,7,8,9};
		String type[]= {"Number", "Text"};
		dimSelect = new JComboBox<Integer>(dim);
		dimSelect.setSelectedIndex(0);
		
		this.setSize(650,580);
		this.getContentPane().setBackground(new Color(139,69,19));
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle(GAME_TITLE);
		
		newIcon= new ImageIcon(GameView.class.getResource("/Images/iconnew.png"));
		solutionIcon= new ImageIcon(GameView.class.getResource("/Images/iconsol.png"));
		exitIcon= new ImageIcon(GameView.class.getResource("/Images/iconext.png"));
		aboutIcon= new ImageIcon(GameView.class.getResource("/Images/iconabt.png"));
		colorsIcon= new ImageIcon(GameView.class.getResource("/Images/iconcol.png"));
		
		newItem.addActionListener(this);
		solutionItem.addActionListener(this);
		exitItem.addActionListener(this);
		colorsItem.addActionListener(this);
		aboutItem.addActionListener(this);
		
		newItem.setIcon(newIcon);
		aboutItem.setIcon(aboutIcon);
		solutionItem.setIcon(solutionIcon);
		exitItem.setIcon(exitIcon);
		colorsItem.setIcon(colorsIcon);
		
		gameMenu.add(newItem);
		gameMenu.add(solutionItem);
		gameMenu.add(exitItem);
		helpMenu.add(colorsItem);
		helpMenu.add(aboutItem);
		
		menuBar.add(gameMenu);
		menuBar.add(helpMenu);
		this.setJMenuBar(menuBar);
		
		this.setIconImage(game.getImage());
		this.menuPanel.setBounds(0,0,50,510);
		this.menuPanel.setBackground(new Color(200,49,89));
		this.menuPanel.setLayout(new BorderLayout());
		
		this.gamePanel.setBounds(0, 0, 410, 510);
		this.gamePanel.setBackground(new Color(139,69,19)); 
		this.gamePanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		this.gamePanel.setLayout(new BorderLayout());
		
		this.sidePanel.setBounds(410, 0, 239, 550);
		this.sidePanel.setBackground(new Color(139,69,19)); 
		this.sidePanel.setLayout(new BorderLayout());
		
		this.gamePanel.add(numpuzGamePanel, BorderLayout.CENTER);
		this.gamePanel.add(text, BorderLayout.SOUTH);
		

		
		numpuzGamePanel.setPreferredSize(new Dimension(100, 100));
		numpuzGamePanel.setBackground(new Color(139,69,19));   
		this.numpuzGamePanel.setLayout(new BorderLayout());
		
		text.setBackground(new Color(139,69,19));  
		text.setLayout(new FlowLayout());
		text.setPreferredSize(new Dimension(400, 90));
		
		this.sidePanel.add(sidePanelTop, BorderLayout.NORTH);
		this.sidePanel.add(sidePanelCenter, BorderLayout.CENTER);
	//	this.sidePanel.add(sidePanelBottom, BorderLayout.SOUTH);
		
		sidePanelTop.setBackground(new Color(210,105,30));  
		sidePanelTop.setPreferredSize(new Dimension(270, 100));
		sidePanelTop.setLayout(new FlowLayout());
		
		sidePanelCenter.setBackground(new Color(210,105,30));  
		sidePanelCenter.setPreferredSize(new Dimension(270, 500));
		
		sidePanelBottom.setBackground(new Color(210,105,30)); 
		sidePanelBottom.setPreferredSize(new Dimension(300, 100));		
		
		textInput.setBackground(new Color(255,235,205));
		textInput.setForeground(new Color(0,0,0));
		textInput.setPreferredSize(new Dimension(200,20));
		textInput.setFont(new Font("TimesNewRoman",Font.BOLD,10));
		textInput.setHorizontalAlignment(JLabel.LEFT);
		textInput.setText(" ");
		textInput.setOpaque(true);
		
		this.text.add(textInput);
		this.text.add(setButton);
		
		sidePanelTop.setLayout(new FlowLayout());
		this.gameLogoButton.setIcon(gameLogo);
		this.gameLogoButton.setFocusable(false);
		this.gameLogoButton.setBackground(new Color(210,105,30)); //very light yellow
		
		this.sidePanelTop.add(gameLogoButton);
		gameLogoButton.addActionListener(this);
		
		
		dimSelect.addActionListener(this);
		
		dimSelect.setBackground(new Color(255,235,205));
		showButton.setBackground(new Color(255,235,205));
		hideButton.setBackground(new Color(255,235,205));
		saveButton.setBackground(new Color(255,235,205));
		loadButton.setBackground(new Color(255,235,205));
		randButton.setBackground(new Color(255,235,205));
		finishButton.setBackground(new Color(255,235,205));
		setButton.setBackground(new Color(255,235,205));
		gameButton.setBackground(new Color(255,235,205));
		helpButton.setBackground(new Color(255,235,205));
		
		setButton.addActionListener(this);
		setButton.setEnabled(false);
		textInput.addActionListener(this);
			
		
		designRadio.setText("Design        ");
		designRadio.setActionCommand("enable");
		designRadio.setSelected(true);
		playRadio.setText("Play      ");
		playRadio.setActionCommand("disable");
		buttons.add(designRadio);
		buttons.add(playRadio);
		
		designRadio.addActionListener(this);
		playRadio.addActionListener(this);

		this.sidePanelCenter.add(modeLabel);
		this.sidePanelCenter.add(designRadio);
		this.sidePanelCenter.add(playRadio);
		this.sidePanelCenter.add(dimLabel);
		this.sidePanelCenter.add(dimSelect);
		this.sidePanelCenter.add(showButton);
		this.sidePanelCenter.add(hideButton);
		this.sidePanelCenter.add(saveButton);
		this.sidePanelCenter.add(loadButton);
		this.sidePanelCenter.add(randButton);
		this.sidePanelCenter.add(typeLabel);
		
		showButton.addActionListener(this);
		hideButton.addActionListener(this);
		saveButton.addActionListener(this);
		loadButton.addActionListener(this);
		randButton.addActionListener(this);
		finishButton.addActionListener(this);
		
		typeSelect = new JComboBox<String>(type);
		typeSelect.setFocusable(false);
		typeSelect.setSelectedIndex(0);
		typeSelect.setBackground(new Color(255,235,205));
		typeSelect.addActionListener(this);
	
		
		
		this.sidePanelCenter.add(typeSelect);
		this.sidePanelCenter.add(finishButton);
		this.sidePanelCenter.add(moveLabel);
		this.sidePanelCenter.add(moveTF);
		this.sidePanelCenter.add(pointLabel);
		this.sidePanelCenter.add(pointTF);
		moveRecordTF.setPreferredSize(new Dimension(205,210));
		this.sidePanelCenter.add(moveRecordTF);
		this.sidePanelCenter.add(timeLabel);
		this.sidePanelCenter.add(timeTF);
		this.sidePanelCenter.add(resetButton);
		
		moveTF.setEditable(false);
		pointTF.setEditable(false);
		timeTF.setEditable(false);
		moveRecordTF.setEditable(false);
		
		this.add(gamePanel,BorderLayout.WEST);
		this.add(sidePanel,BorderLayout.CENTER);
		
		drawDefaultGrid();
		
	}
	/**
	 * method for default grid creation
	 */
	public void drawDefaultGrid()
	{
		grid.setFont(new Font("SansSerif", Font.BOLD, 30));
		grid.numpuz(3, 400, 15,charToInt,false);
		this.numpuzGamePanel.add(grid);
	}
	/**
	 * method for changing value of the move count textfield
	 */
	public void changeMoveCount()
	{
		moveTF.setText(grid.getCount()+"");
		model.setMoves(grid.getCount());
	}
	/**
	 * method for changing value of the point count textfield
	 */
	public void changePoint()
	{
		pointTF.setText(grid.getPoint()+"");
		model.setPoints(grid.getPoint());
	}
	
	/**
	 * method for writing string to the move-record textfield
	 * @param x - x coordinate
	 * @param y - y coordinate
	 * @param tile - tile array
	 */
	public void writeMove(int x,int y,int tile[])
	{
		for(int i=0;i<tile.length;i++)
		{
			if(i%3==0)
				moveRecordTF.setText("\n");
			moveRecordTF.setText(tile[i]+",");
		}
		moveRecordTF.setText("["+x+","+y+"] on Move");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gridTile grid = new gridTile();
		String textFieldInput=null;
		
		//game variable doesn't have scope here coz i think set image icon can only be done under static state
		if (e.getSource() == gameLogoButton) {
			JFrame popup = new JFrame();
			ImageIcon image = new ImageIcon(getClass().getResource("/Images/game.png"));
			JLabel label = new JLabel(image);
			popup.setIconImage(image.getImage());
			popup.setLayout(new BorderLayout());
			popup.setSize(550,550);
			popup.setResizable(false);
			popup.setVisible(true);
		    popup.add(label);
			
		}
		if(typeSelect.getSelectedItem() == "Text")
		{
			setButton.setEnabled(true);
		}
		
		if(typeSelect.getSelectedItem() == "Number")
		{
			setButton.setEnabled(false);
		}
		
		//text field character input gonna be done here and numpuzTiles
		if(e.getSource() == setButton)
		{
			textFieldInput=textInput.getText();
			stringToChar= textFieldInput.toCharArray();
			charToInt=new int[(int)dimSelect.getSelectedItem()*(int)dimSelect.getSelectedItem()];
			int hero;
			if(charToInt.length>stringToChar.length)
			{
				hero=stringToChar.length;
				for(int i=0;i<stringToChar.length;i++)
					charToInt[i]=(int)stringToChar[i];
			}
				
			else
			{
				hero=charToInt.length;
				for(int i=0;i<charToInt.length;i++)
					charToInt[i]=(int)stringToChar[i];
			}
				
				
			System.out.println(stringToChar);
			for(int i=0;i<hero;i++)
			System.out.println(charToInt[i]);
			this.numpuzGamePanel.removeAll();
			grid.numpuz((int)dimSelect.getSelectedItem(), 400, 15,charToInt,true);
			this.numpuzGamePanel.add(grid);
			this.setVisible(true);
		}
		
		if (e.getSource() == dimSelect || e.getSource() == randButton || e.getSource() == newItem) {
			this.numpuzGamePanel.removeAll();
			int numberOfTiles = (int) dimSelect.getSelectedItem();
			model.setGridDim(numberOfTiles);
			grid.count=0;
			grid.point=0;
			changeMoveCount();
			changePoint();
			if (numberOfTiles >= 6) {
				grid.setFont(new Font("SansSerif", Font.BOLD, 15));
				grid.numpuz(numberOfTiles, 400, 15,charToInt,false);
				this.numpuzGamePanel.add(grid);
				this.setVisible(true);
			}
			else
			{
				grid.setFont(new Font("SansSerif", Font.BOLD, 30));
				grid.numpuz(numberOfTiles, 400, 15,charToInt,false);
				this.numpuzGamePanel.add(grid);
				this.setVisible(true);
			}
			
		}
		
		if("enable".equals(e.getActionCommand()))
		{
			randButton.setEnabled(true);
			saveButton.setEnabled(true);
			loadButton.setEnabled(true);
			dimSelect.setEnabled(true);
			typeSelect.setEnabled(true);
			showButton.setEnabled(false);
			finishButton.setEnabled(false);
			stopTime();
		}
		
		if("disable".equals(e.getActionCommand()))
		{
			randButton.setEnabled(false);
			saveButton.setEnabled(false);
			loadButton.setEnabled(false);
			dimSelect.setEnabled(false);
			typeSelect.setEnabled(false);
			showButton.setEnabled(true);
			finishButton.setEnabled(true);
			
			 NumberFormat formating = new DecimalFormat("00");
				if(seconds == clockConst)
				{
					seconds= 00;
					minutes++;
				}
				
				if(minutes == clockConst)
				{
					minutes=00;
					hours++;
				}
				
				hrs=formating.format(hours);
				min=formating.format(minutes);
				sec=formating.format(seconds);
				timeTF.setText(String.valueOf(hrs+":"+min+":"+sec));
				seconds++;
				
		}
	
		
		if(e.getSource() == colorsItem)
		{
			
		}
		
		if(e.getSource() == solutionItem)
		{
			
		}
		
		if(e.getSource() == aboutItem)
		{
			JDialog aboutD = new JDialog(this,"About");
			JLabel aboutLable = new JLabel("NumPuz v1.0",SwingConstants.CENTER);
			aboutD.setLayout(new GridLayout());
			aboutD.add(aboutLable);
			aboutD.setSize(200,200);
			aboutD.setVisible(true);
			
		}
		
		if(e.getSource() == exitItem)
		{
			System.exit(0);
		}

	}
/******************************************************************************GRID TILE CLASS***************************************************************************/	
/**
 * gridtile class for grid implementation in the frame by extending JPanel	
 * @author Jay Patel
 *
 */
	public class gridTile extends JPanel
	{
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
		private final Color FOREGROUND_COLOR = new Color(255,235,205);
		/**
		 * random number generation
		 */
		private final Random RANDOM = new Random();
		/**
		 * tile array
		 */
		private int[] tiles;
		/**
		 * tile size in px
		 */
		private int tileSize;
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
		 * variable for checking game solvability
		 */
		private int countInversions = 0;
		/**
		 *  variable to track count for tile movement 
		 */
		private int count=0;
		/**
		 *  variable to track count of points
		 */
		private int point=0;
		/**
		 * frame object for winner screen popup
		 */
		private JFrame win = new JFrame();
		/**
		 * get value of count variable
		 * @return count - track count for tile movement
		 */
		public int getCount()
		{
			return count;
		}
		/**
		 * get value of point variable
		 * @return point - track count of points
		 */
		public int getPoint()
		{
			return point;
		}
		/**
		 * method for frame popup after a win
		 */
		public void winnerSplash()	
		{
			JLabel imageWin=new JLabel(new ImageIcon(GameView.class.getResource("/Images/gamewinner.png")));

			win.setLayout(new BorderLayout());
			win.setUndecorated(true);
			win.setSize(550,550);
			win.setLocationRelativeTo(null);//Setting location to the center of screen
			win.getContentPane().setBackground(Color.gray);//setting background color
			win.setVisible(true);//setting visibility
			imageWin.setBounds(100,25,550,550);
			win.add(imageWin,BorderLayout.CENTER);
			try {
				Thread.sleep(50);
				win.dispose();
			}
			catch(Exception e)
			{
				System.out.println("Error at winner splash");
			}

			
		}
		boolean check;
		char[] charNum;
		/**
		 * Method Name: numpuz
		 * Purpose: it used to take care about the initializing of the grid size and dimension
		 * Algorithm: It takes the values from parameters and creates the grid according to the requirement
		 * @param size value for the n x n grid
		 * @param dim dimension of the grid in px
		 * @param mar margin value in px
		 * @param numChar array for number-characters
		 * @param checkChar true/false for character check
		 */
		public void numpuz(int size, int dim, int mar,int[] numChar,boolean checkChar) {
			this.size = size;
			dimension = dim;
			margin = mar;
			check=checkChar;
			charNum= new char[size*size];
			nbTiles = size * size -1;
			tiles = new int[size * size];
			
			if(check)
				for(int i=0;i<tiles.length;i++)
				{
					tiles[i]=numChar[i];
					charNum[i] = (char) numChar[i];
				}
					
			
			gridSize = (dim -2 * margin); 
			tileSize = gridSize / size; 
		
			this.setPreferredSize(new Dimension(dimension, dimension + margin)); //400,415
			this.setForeground(FOREGROUND_COLOR);
			this.setBackground(new Color(139,69,19));
			
			gameOver  = true;
	
			addMouseListener(new MouseAdapter() {

				public void rasiePoint()
				{
					point=0;
					changePoint();
					for(int i=0;i<tiles.length;i++)
					if(tiles[i] == i+1)
						point++;
					changePoint();
					
						
				}
				@Override
				public void mousePressed(MouseEvent e) {
					//used to let user click on grid
					if (gameOver) {
					      newGame();
					      } 
					else {
							count++;   // ***Move Count***
							rasiePoint();
					      // get position of the click
					      int ex = e.getX() - margin;
					      int ey = e.getY() - margin;
					     

					      // click in the grid ?
					      if (ex < 0 || ex > gridSize  || ey < 0  || ey > gridSize)
					        return;

					      // get position in the grid
					      int c1 = ex / tileSize;
					      int r1 = ey / tileSize;
					      writeMove(c1,r1,tiles);
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
					        
					        model.setGridTiles(tiles);
					        tiles[blankPosition] = 0;
					      }
					      
					      rasiePoint();
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
		public void newGame() {
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
		public void shuffle() {
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
			count=0;
			point=0;
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
			changeMoveCount();
			if (tiles[tiles.length - 1] != 0) {
				return false;
			}
			
			for (int i = nbTiles - 1; i >= 0; i--) {
				if (tiles[i] != i+1)
					return false;
			}
			
			//winnerSplash();
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
			    
			    
		        if(check)
		        	for(int j=0;j<tiles.length;j++)
		        		charNum[i]=(char)tiles[i];
			    	
			    if(check)
			    drawCenteredString(g, String.valueOf(tiles[i]), x , y);
			    else
			    	drawCenteredString(g, String.valueOf(tiles[i]), x , y);
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
			    winnerSplash();
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
/***********************************************************************************************SPLASH SCREEN DEMO ******************************************/
	/**
	 * splashScreen for popup screen while game start
	 * @author Jay Patel
	 *
	 */
	public class splashScreen
	{
		/**
		 * frame object 
		 */
		JFrame splash;
		/**
		 * jlabel object for getting the numpuz image
		 */
		JLabel image=new JLabel(new ImageIcon(GameView.class.getResource("/Images/game.png")));
		splashScreen()
		{
			splashStartScreen();
	        addImage();
	        addProgressBar();
	        runningPBar();
		}
		/**
		 * method to add attributes to the frame 
		 */
		public void splashStartScreen()
		{
			splash = new JFrame();
			splash.setLayout(new BorderLayout());
			splash.setUndecorated(true);
			splash.setSize(650,400);
	        splash.setLocationRelativeTo(null);//Setting location to the center of screen
	        splash.getContentPane().setBackground(Color.gray);//setting background color
	        splash.setVisible(true);//setting visibility
		}
		
		/**
		 * setting proper bounds to image 
		 */
		public void addImage()
		{
				image.setBounds(100,25,425,300);
			  //image.setSize(400,400);//Setting size of the image
		      splash.add(image,BorderLayout.CENTER);
		}
		/**
		 * setting properties related to the progress bar
		 */
		public void addProgressBar()
		{
				progressBar.setBounds(103,325,400,25);
				progressBar.setBorderPainted(true);
		        progressBar.setStringPainted(true);
		        progressBar.setBackground(new Color(255,235,205));
		        progressBar.setForeground(Color.BLACK);
		        progressBar.setValue(0);
		        splash.add(progressBar, BorderLayout.SOUTH);
		}
		
		/**
		 * setting appropriate delay corresponding to the progress bar
		 */
	    public void runningPBar(){
	        int i=0;

	        while( i<=100)
	        {
	            try{
	                Thread.sleep(50);
	                progressBar.setValue(i); 
	                i++;
	                if(i==100)
	                    splash.dispose();
	            }catch(Exception e){
	                e.printStackTrace();
	            }

	        }
	    }
	}
}
