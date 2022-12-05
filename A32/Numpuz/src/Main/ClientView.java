package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * ClientView which creates GUI for client side
 * @author Jay Patel / Neeraj Kumar Bansal
 *
 */
public class ClientView extends JFrame{
	
	/**
	 * Basic serial version
	 */
	private static final long serialVersionUID = 1L;
	
	/** Variable for server title*/
    private static final String SERVER_TITLE = "Game Server - JAP (Fall 2022)";
	/**
	* labels for various buttons
	*/
	private JLabel imageLabel, userLabel, serverLabel, portLabel;
	
	/**Text fields for user inputs*/
	protected JTextField user, server, port;
	/**
	* Text area for displaying messages
	*/
	protected JTextArea chat;
	
	/**Buttons for client side*/
	protected JButton connect, end, newGame, sendGame, recieveGame, sendData, play;
	
	/**
	* Panel for splitting label and other attributes
	*/
	private JPanel top, middle, bottom;
	
	/**Image icon for importing image*/
	private ImageIcon image;
	
	/**
	*	Default Constructor starts frame and adds other attributes to it
	*/
	public ClientView() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600,600);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle(SERVER_TITLE);

		image = new ImageIcon(GameView.class.getResource("/Images/gameclient.png"));
		Image normalSizeImage = image.getImage(); 
		Image newimg = normalSizeImage.getScaledInstance(550, 200, Image.SCALE_FAST);
		image.setImage(newimg);
		
		imageLabel = new JLabel(image);
		imageLabel.setBounds(10, 25, 31, 30);
		imageLabel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		top = new JPanel();
		top.setBackground(new Color(139,69,19));
		this.add(top, BorderLayout.NORTH);
		this.top.add(imageLabel);
		
		userLabel = new JLabel("User: ");
		userLabel.setForeground(Color.black);
		user = new JTextField("client1",7);
		user.setBackground(new Color(255,235,205));
		user.setForeground(Color.black);
		
		serverLabel = new JLabel("Server: ");
		serverLabel.setForeground(Color.black);
		server = new JTextField("localhost",7);
		server.setBackground(new Color(255,235,205));
		server.setForeground(Color.black);
		
		portLabel = new JLabel("Port: ");
		portLabel.setForeground(Color.black);
		port = new JTextField("3000",7);
		port.setBackground(new Color(255,235,205));
		port.setForeground(Color.black);
		
		connect = new JButton("Connect");
		connect.setBackground(new Color(255,235,205));
		connect.setForeground(Color.black);
		
		end = new JButton("End");
		end.setBackground(new Color(255,235,205));
		end.setForeground(Color.black);
		
		newGame = new JButton("New Game");
		newGame.setBackground(new Color(255,235,205));
		newGame.setForeground(Color.black);
		
		sendGame = new JButton("Send Game");
		sendGame.setBackground(new Color(255,235,205));
		sendGame.setForeground(Color.black);
		
		recieveGame = new JButton("Recieve Game");
		recieveGame.setBackground(new Color(255,235,205));
		recieveGame.setForeground(Color.black);
		
		sendData = new JButton("Send Data");
		sendData.setBackground(new Color(255,235,205));
		sendData.setForeground(Color.black);
		
		play = new JButton("Play");
		play.setBackground(new Color(255,235,205));
		play.setForeground(Color.black);
		
		middle = new JPanel();
		middle.setBackground(new Color(139,69,19));
		this.add(middle, BorderLayout.CENTER);
		this.middle.add(userLabel);
		this.middle.add(user);
		this.middle.add(serverLabel);
		this.middle.add(server);
		this.middle.add(portLabel);
		this.middle.add(port);
		this.middle.add(connect);
		this.middle.add(end);
		this.middle.add(newGame);
		this.middle.add(sendGame);
		this.middle.add(recieveGame);
		this.middle.add(sendData);
		this.middle.add(play);
		
		bottom = new JPanel();
		bottom.setBackground(new Color(139,69,19));
		this.add(bottom, BorderLayout.SOUTH);
		chat = new JTextArea();
		chat.setPreferredSize(new Dimension(500,240));
		chat.setBackground(new Color(255,235,205));
		chat.setForeground(Color.black);
		chat.setFont(new Font("Consolas", Font.BOLD, 15));
		chat.setEditable(false);
		this.bottom.add(chat);
		
		this.newGame.setEnabled(false);
		this.recieveGame.setEnabled(false);
		this.sendData.setEnabled(false);
		this.play.setEnabled(false);
		this.sendGame.setEnabled(false);
		
		this.setVisible(true);
		
	}

}
