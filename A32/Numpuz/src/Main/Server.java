/**
 * NumPuz.java
 * Jay Patel (041028206) / Neeraj Bansal(041000185)
 * CST 8221 - JAP, Lab Section: 301
 * Assignment: A12
 * Professor: Paulo Sousa
 * Date: 02-10-2022
 * Compiler: Eclipse IDE for Java Developers - Version: 2022-03 (4.23.0)
 * Purpose: Implements class method for server connection
 */
package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* This class handles the executor and its pool by making use of ExecutorService.
* Creates a serverSocket on either the passed command line argument port or DEFAULT_PORT and
* handles connections from clients.
* 
* @author Jay Patel (041028206) / Neeraj Bansal (041000185)
* @version 1.0
*/
public class Server extends JFrame implements ActionListener, Runnable {
	
	/**
	 * Basic serial version
	 */
	private static final long serialVersionUID = 1L;
	/**
	*	serverView class declaration 
	*/
	private ServerView serverView;
	/**
	 * Socket variable.
	 */
	Socket sock;
	
	/**
	 * Variables for number clients.
	 */
	static int nclient = 0, nclients = 0;
	
	/**
	 * Server socket.
	 */
	static ServerSocket servsock;
	
	/**
	 * Default port.
	 */
	static int PORT = 3000;
	
	/**
	 * Number of port.
	 */
	static int portNumber = 0;
	/**
	*	thread object declaration
	*/
	private Thread servDaemon;
	/**
	* PrintStream object declaration
	*/
	private PrintStream out = null;
	/**
	* BufferedReader object declaration
	*/
	private BufferedReader in;
	/**
	* Jlabel array declaration 
	*/
	private JLabel[] labels = new JLabel[5];
	
	/**
	 * Default constructor.
	 */
	public Server() {
		; // No commands.
	}
    
	/**
	 * Parameter constructor
	 * @param view referenced to Server view
	 */
    public Server(ServerView view) {
    	serverView = view;
    	ServerActions();
    }
    /**
	*	method to provide actionListner to different attributes of the frame
	*/
    public void ServerActions() {
    	serverView.port.addActionListener(this);
    	serverView.start.addActionListener(this);
    	serverView.results.addActionListener(this);
    	serverView.finalize.addActionListener(this);
    	serverView.end.addActionListener(this);
    	serverView.results.setEnabled(false);
    }
	/**
	*	array to record the data
	*/
    public String record[]= new String[10];
	/**
	*	arrayList to store the message string from server
	*/
    private static ArrayList<String> detail = new ArrayList<String>();
    /**
     * setMethod to set the detail arrayList
     * @param det details for server data
     */
    public static void setData(String det)
    {
    	detail.add(det);
    }

    /**
     * @param args the command line arguments, including the port for the server to be running on.
     */
    public static void main(String[] args) {
    	
    	ServerView view = new ServerView();
    	new Server(view);
    }
	/**
	*	default actionPerformed method which excutes function regarding their assigned purpose 
	*/
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == serverView.start) 
		{
			if (serverView.port == null) {
	            portNumber = PORT;    		
	    	} else if (serverView.port.getText().length() < 1) {
	            portNumber = PORT;
	        } else {
	            portNumber = Integer.parseInt(serverView.port.getText());
	        }
			serverView.chat.append("Starting Server Thread on port " + portNumber + "\n");
			System.out.println("Starting Server Thread on port " + portNumber + "\n");
			//Initialize our server
			try {
				servsock = new ServerSocket(portNumber);
				servDaemon = new Thread(new Server());
				servDaemon.start();
				serverView.chat.append("Server running on " + InetAddress.getLocalHost() + " at port " + portNumber + "!");
				System.out.println("Server running on " + InetAddress.getLocalHost() + " at port " + portNumber + "!");
			} catch (Exception exp) {
				serverView.chat.append("\nError: " + exp.toString());
				System.out.println("\nError: " + exp.toString());
			}
			
		} 
		if(e.getSource() == serverView.results)
		{
			serverView.okButton = new JButton("Ok");
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent me) {
					if(me.getSource() == serverView.okButton) {
						System.exit(0);
					}
				}
			});
			
			serverView.result= new JDialog(this, "Results");
			serverView.result.setSize(260,150);
			serverView.result.add(serverView.okButton);
			serverView.result.setVisible(true);
			serverView.okButton.addActionListener(this);
			
			JPanel pan = new JPanel();
			for(int i=0;i<detail.size();i++)
			{
				String[] data = detail.get(i).split("#");
				labels[i]= new JLabel("Player["+(i+1)+"]: "+data[1]+", Moves: "+data[2]+" Points: "+data[3]);
			}
			for(int i=0;i<detail.size();i++)
				pan.add(labels[i]);
			pan.add(serverView.okButton);
			serverView.result.add(pan);
			serverView.result.setVisible(true);
			
			for(int i=0;i<detail.size();i++)
				System.out.println(detail.get(i));
			
			
				
		}
		if(e.getSource() == serverView.end) {
			System.exit(0);
		}
		
		if(e.getSource() == serverView.finalize)
			serverView.results.setEnabled(true);
		
		if(e.getSource() == serverView.port) {
			
			if (serverView.port == null) {
	            portNumber = PORT;    		
	    	} else if (serverView.port.getText().length() < 1) {
	            portNumber = PORT;
	        } else {
	            portNumber = Integer.parseInt(serverView.port.getText());
	        }
			serverView.chat.append("Starting Server Thread on port " + portNumber + "\n");
			System.out.println("Starting Server Thread on port " + portNumber + "\n");
	        
		} 
				
	}//end
	
	/**
	 * Run method.
	 */
	public void run() {
		for (;;) {
			try {
				sock = servsock.accept();
				nclient += 1;
				nclients += 1;
				System.out.println("\nConnecting " + sock.getInetAddress() + " at port " + sock.getPort() + ".");
				
			} catch (IOException ioe) {
				System.out.println(ioe);
			}
			Worked w = new Worked(sock, nclient);
			w.start();
		}
	}

	/**
	 * Inner class for Theads.
	 * @author sousap
	 *
	 */
	class Worked extends Thread {
		/**
		* Server classs object declaration and initialisation
		*/
		Server sev = new Server();
		
		/**
		 * Socket variable.
		 */
		Socket sock;
		
		/**
		 * Integers for client and positions.
		 */
		int clientid, poscerq;
		
		/**
		 * String for data.
		 */
		String strcliid, dadosCliente;

		/**
		 * Default constructor.
		 * @param s Socket
		 * @param nclient Number of client.
		 */
		public Worked(Socket s, int nclient) {
			sock = s;
			clientid = nclient;
		}

		/**
		 * Run method.
		 */
		public void run() {
			String data;
			try {
				out = new PrintStream(sock.getOutputStream());
				in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out.println(clientid);
				data = in.readLine();
				poscerq = data.indexOf("#");
				strcliid = data.substring(0, poscerq);
				dadosCliente = data.substring(poscerq + 1, data.length());
				Server.setData(dadosCliente);
				while (!dadosCliente.equals("end")) {
					System.out.println("Cli[" + strcliid + "]: " + data);
					out.println("String \"" + data + "\" received.");
					out.flush();
					data = in.readLine();
					Server.setData(data);
					poscerq = data.indexOf("#");
					strcliid = data.substring(0, 1);
					dadosCliente = data.substring(2, data.length());
				}
				nclients -= 1;
				System.out.println("Disconecting " + sock.getInetAddress() + "!");
				System.out.println("Current client number: " + nclients);
				if (nclients == 0) {
					System.out.println("Ending server...");
					sock.close();
					System.exit(0);
				}
			} catch (IOException ioe) {
				System.out.println(ioe);
			}
		}
	}
}
    
