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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * Class name: NumPuz
 * Methods List: main().
 * Constants List: actionPerformed
 * Purpose: The program initialises from this method
 * @author Jay Patel
 * @version 1.0
 * @see Game
 * @since JDK 17
 */
public class GameController extends JFrame implements ActionListener {

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
	private JTextField timeTF = new JTextField(3);
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
	public ImageIcon game = new ImageIcon(GameController.class.getResource("/images/game.png"));
	/**
	 * ImageIcon object for the game logo
	 */
	public ImageIcon gameLogo = new ImageIcon(GameController.class.getResource("/images/gamelogo.png"));
//	JTextField moveField = new JTextField(4);
//	JTextField pointField = new JTextField(4);
//	JTextField timeField = new JTextField(4);
	/**
	 * Constant for the game name
	 */
	private final String GAME_TITLE = "Numpuz";
	
	/**
	 * No argument constructor for the frame creation and adding other important elements
	 * @throws IOException for exception handling
	 */
	public GameController() throws IOException
	{
		Integer dim[] = {3,4,5,6,7,8,9};
		String type[]= {"Number", "Text"};
		dimSelect = new JComboBox<Integer>(dim);
		dimSelect.setSelectedIndex(0);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(650,550);
		this.getContentPane().setBackground(new Color(139,69,19));
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle(GAME_TITLE);
		
//		ImageIcon game = new ImageIcon(GameController.class.getResource("/images/game.png"));
//		ImageIcon gameLogo = new ImageIcon(GameController.class.getResource("/images/gamelogo.png"));
		this.setIconImage(game.getImage());
		
		this.menuPanel.setBounds(0,0,649,0);
		this.menuPanel.setBackground(new Color(139,69,19));
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
		
		setButton.addActionListener(this);
		textInput.addActionListener(this);
		
		designRadio.setText("Design        ");
		playRadio.setText("Play      ");
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

		this.menuPanel.add(gameButton);
		this.menuPanel.add(helpButton);
		
		
		this.add(menuPanel);
		this.add(gamePanel);
		this.add(sidePanel);
		
	}
	
		/**
		 * Method Name: actionPerformed
		 * Purpose: check mouse click or action on buttons
		 * Algorithm: invoke source of click and compare it with button to do specific tasks
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			NumpuzTiles npm = new NumpuzTiles();
			String textFieldInput=null;
			int currentDim=0;
			
			//game variable doesn't have scope here coz i think set image icon can only be done under static state
			if (e.getSource() == gameLogoButton) {
				JFrame popup = new JFrame();
				ImageIcon image = new ImageIcon(getClass().getResource("/images/game.png"));
				JLabel label = new JLabel(image);
				popup.setIconImage(image.getImage());
				popup.setLayout(new BorderLayout());
				popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				popup.setSize(550,550);
				popup.setResizable(false);
				popup.setVisible(true);
			    popup.add(label);
				
			}
			
			//text field character input gonna be done here and numpuzTiles
			if(e.getSource() == setButton)
			{
				if(typeSelect.getSelectedItem() == "Text")
				{
					textFieldInput=textInput.getText();
					System.out.println(textFieldInput);
					currentDim=(int)dimSelect.getSelectedItem();
					System.out.println(currentDim);
					
				}

			}
			
			
			if (e.getSource() == typeSelect) {
				//String selection = (String) typeSelect.getSelectedItem();
				//System.out.println(selection);
				
				int selection = typeSelect.getSelectedIndex();
				
				if (selection == 1) {
					
				}
				
			}
			
			if (e.getSource() == setButton) {

				int selection = typeSelect.getSelectedIndex();
				
				if (selection == 1) {
					String value = textInput.getText();
					int[] tiles = new int[(int)dimSelect.getSelectedItem() * (int)dimSelect.getSelectedItem()];
					
					for (int i = 0; i < (int)dimSelect.getSelectedItem() * (int)dimSelect.getSelectedItem(); i++) {
						tiles[i] = (int)value.charAt(i);
						System.out.println(tiles[i]);
					}
					
					this.numpuzGamePanel.removeAll();
					int numberOfTiles = (int) dimSelect.getSelectedItem();

					if (numberOfTiles >= 6) {
						npm.setFont(new Font("SansSerif", Font.BOLD, 15));
						npm.numpuz(numberOfTiles, 400, 15, tiles, true);
						this.numpuzGamePanel.add(npm);
						this.setVisible(true);
					}
					else
					{
						npm.setFont(new Font("SansSerif", Font.BOLD, 30));
						npm.numpuz(numberOfTiles, 400, 15, tiles, true);
						this.numpuzGamePanel.add(npm);
						this.setVisible(true);
					}
					
				}
			}
			
			if (e.getSource() == dimSelect) {
				this.numpuzGamePanel.removeAll();
				int numberOfTiles = (int) dimSelect.getSelectedItem();
				int[] tiles = new int[(int)dimSelect.getSelectedItem() * (int)dimSelect.getSelectedItem()];
				if (numberOfTiles >= 6) {
					npm.setFont(new Font("SansSerif", Font.BOLD, 15));
					npm.numpuz(numberOfTiles, 400, 15, tiles, false);
					this.numpuzGamePanel.add(npm);
					this.setVisible(true);
				}
				else
				{
					npm.setFont(new Font("SansSerif", Font.BOLD, 30));
					npm.numpuz(numberOfTiles, 400, 15, tiles, false);
					this.numpuzGamePanel.add(npm);
					this.setVisible(true);
				}
				
			}		
		}
}