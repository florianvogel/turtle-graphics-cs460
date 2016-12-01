/**
 * Author: Jayden Urch
 * Student No: 5388406
 * Email: jsu22@nau.edu
 *
 * Author: Florian Vogel
 * Student No: 5373720
 * Email: fv69@nau.edu
 *
 * Date: 12/01/2016
 */

import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.security.*;

//This class contains all server code and displays
//the server whiteboard in a window
public class ServerDrawing extends javax.swing.JFrame {

	private static final int WIDTH = 1000; //Screen width and height
	private static final int HEIGHT = 1000;

	//Constructor
    public ServerDrawing(TurtleCanvas c) {
        initComponents(c);
        this.setVisible(true);
    }
    
    //BEGIN creating GUI
    @SuppressWarnings("unchecked")
    private void initComponents(TurtleCanvas c) {
        TurtleCanvas panelToDraw = c; //display this

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server Drawing");
        setName("frameServerDrawing"); // NOI18N
        setPreferredSize(new java.awt.Dimension(WIDTH,HEIGHT));
        setSize(new java.awt.Dimension(WIDTH,HEIGHT));
        setResizable(false);
        //panelToDraw.setScreenHeight(this.getHeight());
        //panelToDraw.setScreenWidth(this.getWidth());
        
        panelToDraw.setBackground(new java.awt.Color(255, 255, 255));
        this.add(panelToDraw);

        pack();
    }                      
    //END creating GUI

    //Method to start server. Takes an instance of the
    //whiteboard to be used by clients
    public void startServer(TurtleCanvas c)
    throws IOException{
            System.out.println("Starting Server");
            TurtleCanvas canvas = c;
            int portnumber = 21995;
            ServerSocket ss = new ServerSocket(portnumber);
                    while (true) 
                    new ServConn(ss.accept(), canvas);
    }

    //Server connection thread. New thread is created
    //for each client and then handles the input
    class ServConn extends Thread {
        Socket sock;
        TurtleCanvas canvas;

        //constructor
        ServConn(Socket s, TurtleCanvas c){
            sock=s;
            canvas = c;
            start();
        }
        
        public void run(){
            try{
                //Server
                String buf;
                System.out.println("Accepted Client");
                BufferedReader BR = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                
                String message;
                while((message= BR.readLine())!=null){
                    System.out.println("Total message:" + message);
                    String[] recieved = message.split(":");

                    System.out.println(recieved[0]); //direction
                    System.out.println(recieved[1]); //length
                    System.out.println(recieved[2]); //penstatus

                    int length = 0;
                    try{
                        length = Integer.parseInt(recieved[1]);
                    }
                    catch(Exception e){
                        System.out.println("Error converting length");
                    }

					//If pen is up, just move the pen
                    if(recieved[2].equals("up")){
                        switch (recieved[0]){
                            case "N":
                                canvas.setY(canvas.getY() - length);
                                break;
                            case "E":
                                canvas.setX(canvas.getX() + length);
                                break;
                            case "S":
                                canvas.setY(canvas.getY() + length);
                                break;
                            case "W":
                                canvas.setX(canvas.getX() - length);
                                break;
                        }
                    }
                    else{	//If pen is down, call the draw method
                        switch (recieved[0]){
                            case "N":
                                canvas.draw(true, -length);
                                break;
                            case "E":
                               canvas.draw(false, length);
                                break;
                            case "S":
                                canvas.draw(true, length);
                                break;
                            case "W":
                                canvas.draw(false, -length);
                                break;
                        }
                    }
                }
            	sock.close();
            	
            }catch(IOException e){System.out.println("I/O Error "+e);}
        }
    }

	//Main method, initialises and displays the whiteboard
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerDrawing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerDrawing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerDrawing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerDrawing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            ServerDrawing server;
            TurtleCanvas c = new TurtleCanvas(WIDTH,HEIGHT);
            public void run() {
                server = new ServerDrawing(c);
                //start server on new thread.
				Thread t = new Thread(new Runnable() {
					public void run(){
						try{
							server.startServer(c);
						}catch (IOException e){ 
							System.out.println("Error: Couldn't start server.'");
						}
					}
				});
				t.start();
			}
        });
    }
    

    // Variables declaration - do not modify                     
    private javax.swing.JPanel panelToDraw;
    // End of variables declaration                   
}
