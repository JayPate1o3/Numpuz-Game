package Main;

import java.awt.*;

import javax.swing.*;
/**
 * ServerView which starts server and also implements threads
 * @author Jay Patel / Neeraj Kumar Bansal
 *
 */
public class ServerView extends JFrame{
	
	/**
	 * Basic serial version
	 */
	private static final long serialVersionUID = 1L;
	/** Variable for server title*/
	private static final String SERVER_TITLE = "Game Server - JAP (Fall 2022)";
	/**
	* labels for various buttons
	*/
	private JLabel imageLabel, portLabel;
	/**Text fields for user inputs*/
	protected JTextField port;
	/**Text fields for printing texts*/
	protected JTextArea chat;
	/**Buttons for server side*/
	protected JButton start, results, end, okButton;
	/**Radio Button for server side*/
	protected JRadioButton finalize;
	/**
	* Panel for splitting label and other attributes
	*/
	private JPanel top, middle, bottom;
	/**Dialog box for results*/
	protected JDialog result;
	/**Method to show client results*/
	public void resultDialog()
	{
		result = new JDialog(this,"Results");
		result.setSize(150,150);
		okButton = new JButton("Ok");
		result.add(okButton);
		result.setVisible(true);
	}
	/**default constructor*/
	public ServerView() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600,600);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle(SERVER_TITLE);
		
		imageLabel = new JLabel(new ImageIcon(GameView.class.getResource("/Images/gameserver.png")));
		imageLabel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		top = new JPanel();
		top.setBackground(new Color(139,69,19));
		this.add(top, BorderLayout.NORTH);
		this.top.add(imageLabel);
		
		portLabel = new JLabel("Port: ");
		portLabel.setForeground(Color.black);
		port = new JTextField("3000",7);
		port.setBackground(new Color(255,235,205));
		port.setForeground(Color.black);
		
		start = new JButton("Start");
		start.setBackground(new Color(255,235,205));
		start.setForeground(Color.black);
		
		results = new JButton("Results");
		results.setBackground(new Color(255,235,205));
		results.setForeground(Color.black);
		
		finalize = new JRadioButton("Finalize");
		finalize.setBackground(new Color(255,235,205));
		finalize.setForeground(Color.black);
		
		end = new JButton("End");
		end.setBackground(new Color(255,235,205));
		end.setForeground(Color.black);
		
		middle = new JPanel();
		middle.setBackground(new Color(139,69,19));
		this.add(middle, BorderLayout.CENTER);
		this.middle.add(portLabel);
		this.middle.add(port);
		this.middle.add(start);
		this.middle.add(results);
		this.middle.add(finalize);
		this.middle.add(end);
		
		bottom = new JPanel();
		bottom.setBackground(new Color(139,69,19));
		this.add(bottom, BorderLayout.SOUTH);
		chat = new JTextArea();
		chat.setPreferredSize(new Dimension(500,220));
		chat.setBackground(new Color(255,235,205));
		chat.setForeground(Color.black);
		chat.setEditable(false);
		chat.setFont(new Font("Consolas", Font.BOLD, 15));
		this.bottom.add(chat);
		
		this.setVisible(true);
	}

}
