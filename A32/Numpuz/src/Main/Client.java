package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * NumPuz.java
 * Jay Patel (041028206) / Neeraj Bansal(041000185)
 * CST 8221 - JAP, Lab Section: 301
 * Assignment: A12
 * Professor: Paulo Sousa
 * Date: 02-10-2022
 * Compiler: Eclipse IDE for Java Developers - Version: 2022-03 (4.23.0)
* Purpose: Responsible for instanciating a ClientView and making it visible. Contains main method for this program.
*/

public class Client implements ActionListener{
	/**
	* clientView class object declaration
	*/
	private ClientView clientView;
	
	/** game view object*/
	private GameView view = new GameView();
	/**
	*	model class object declaration and initialisation
	*/
	private GameModel model = new GameModel();
	
	/**
	 * Default port.
	 */
	static int PORT = 3000;
	
	/**
	 * Number of port.
	 */
	static int portNumber = 0;
	
	/**
	 * Default hostname.
	 */
	static String HOSTNAME = "localhost";
	
	/**
	 * Variable for hostname.
	 */
	static String hostName = "";
	/**
	*	variable for clientName
	*/
	static String clientName = "";
	
	/**default client ID*/
	static int clientID = 0;
	/**
	*		variable to store the data from server/client
	*/
	static String data="";
	
	/**
	 * Default constructor.
	 */
	public Client() {
		; // No commands
	}
	
	/**
	 * Parameterized constructor
	 * @param view - referenced to ClientView class
	 */
	 public Client(ClientView view) {
		 clientView = view;
		 ClientActions();
	  }
	/**
	*	method which add the actionlistner to different elements of the frame
	*/
	    public void ClientActions() {
	    	clientView.port.addActionListener(this);
	    	clientView.user.addActionListener(this);
	    	clientView.server.addActionListener(this);
	    	clientView.connect.addActionListener(this);
	    	clientView.end.addActionListener(this);
	    	clientView.newGame.addActionListener(this);
	    	clientView.sendGame.addActionListener(this);
	    	clientView.recieveGame.addActionListener(this);
	    	clientView.sendData.addActionListener(this);
	    	clientView.play.addActionListener(this);
	    }
	
	/**
	 * Main method.
	 * @param args parameter arguments.
	 */
	public static void main(String args[]) {
		
		 ClientView view = new ClientView();
		 new Client(view);
	}
	
	/**Setters for data
	 * @param data Parameter for data of string type
	 */
	public void setData(String data)
	{
		 Client.data=data;
	}
	
	/**
	 * Getter for data
	 * @return data from client in string format
	 */
	public String getData()
	{
		return Client.data;
	}
	/**
	*	Socket object declaration
	*/
	public Socket sock;
	
	/**Buffer reader*/
	public BufferedReader dis;
	
	/**
	*	PrintStream object declaration
	*/
	public PrintStream dat;
	/**
	*	default actionPerformed method which excutes function regarding their assigned purpose
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == clientView.connect)
		{
			clientName = clientView.user.getText();
			hostName = clientView.server.getText();
			portNumber=Integer.parseInt(clientView.port.getText());
			if(hostName.equals(null))
				hostName=HOSTNAME;
			if(portNumber==0)
				portNumber=PORT;
			if(clientName.equals(null))
				clientName="client01";	
			
			clientView.chat.append("Connecting with server on " + hostName + " at port " + portNumber + "\n");
			clientView.chat.append("Starting Server Thread on port " + portNumber + "\n");
			System.out.println("Connecting with server on " + hostName + " at port " + portNumber);
			System.out.println("Starting Server Thread on port " + portNumber);
			
			try {
				sock = new Socket(hostName, portNumber);
				System.out.println("Connection Established....");
				clientView.chat.append("Connection Established ...\n");
				dis = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				dat = new PrintStream(sock.getOutputStream());
				String strcliid = dis.readLine();
				clientID= Integer.parseInt(strcliid);
				System.out.println("Client no." + strcliid + "...");
				clientView.chat.append("Client ID Generating...");
				clientView.chat.append("\nClientID:"+clientID);
				
			}
			catch(Exception ec)
			{
				System.out.println("Error: " + ec.getMessage());
				clientView.chat.append("Error: " + ec.getMessage()+"\n");
			}
			clientView.newGame.setEnabled(true);
			clientView.recieveGame.setEnabled(true);
			clientView.sendData.setEnabled(true);
			clientView.play.setEnabled(true);
			clientView.sendGame.setEnabled(true);
			clientView.connect.setEnabled(false);
		}
		
		if(e.getSource() == clientView.sendData)
		{
			int moves = model.getMoves();
			int points = model.getPoints();
			model.getGridDim();
			
			Random rand = new Random();
			
			if(moves==0)
				moves = rand.nextInt(100);
			if(points==0)
				points = rand.nextInt(10);
			
			String sendData = clientID+"#P3#"+clientName+"#"+moves+"#"+points;
			setData(sendData);
				dat.println(sendData);
				String serverData = null;
				try {
					serverData = dis.readLine();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println("Server: " + serverData);
		}
		
		if(e.getSource() == clientView.play)
		{
			clientView.chat.append("Creating MVC .....\n");
			new GameController(model,view);
		}
	
		if(e.getSource() == clientView.sendGame)
		{
			int dim=model.getGridDim();
			Random rand = new Random();
			
			if(dim==0)
			{
				while(true)
				{
					dim = rand.nextInt(9);
					if(dim>=3&&dim<=9)
						break;
				}
			}
			 Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7,8,9 };

				List<Integer> intList = Arrays.asList(intArray);
				Collections.shuffle(intList);
				intList.toArray(intArray);
				String formattedNum=null;
				for(int i=0;i<9;i++)
				{
					if(i==0)
						formattedNum=intArray[i].toString();
					else
					formattedNum=formattedNum+","+intArray[i];
				}
					
			String sendGameData=clientID+"#P2#"+dim+"#Number#"+formattedNum;
			setData(sendGameData);
			dat.println(sendGameData);
		}
		
		if(e.getSource() == clientView.recieveGame)
		{
			clientView.chat.append("Recieving Game......");
			String serverData = null;
			try {
				serverData = dis.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("Server: " + serverData);
		}
		
		if(e.getSource() == clientView.newGame)
		{
			clientView.chat.append("Creating New MVC .....\n");
			new GameController(model,view);
		}
		
		if(e.getSource() == clientView.end)
		{
			System.exit(0);
		}
		
	}	
}

