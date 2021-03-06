/**
 * Author: Jayden Urch
 * Student No: 5388406
 * Email: jsu22@nau.edu
 *
 * Author: Florian Vogel
 * Student No: 5373720
 * Email: fv69@nau.edu
 *
 * Date: 11/30/2016
 */
 
import java.io.*;
import java.net.*;

public class ClientDrawingControlUI extends javax.swing.JFrame {

    Socket socket;
    PrintStream toServer;

	//Constructor to call initalize function
    public ClientDrawingControlUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // BEGIN Creating GUI                        
    private void initComponents() {

        groupPenStatus = new javax.swing.ButtonGroup();
        buttonNorth = new javax.swing.JButton();
        buttonWest = new javax.swing.JButton();
        buttonEast = new javax.swing.JButton();
        buttonSouth = new javax.swing.JButton();
        textFieldServerIP = new javax.swing.JTextField();
        textFieldServerPort = new javax.swing.JTextField();
        labelServerIP = new javax.swing.JLabel();
        labelServerPort = new javax.swing.JLabel();
        labelPenStatus = new javax.swing.JLabel();
        radioPenUp = new javax.swing.JRadioButton();
        radioPenDown = new javax.swing.JRadioButton();
        buttonEnd = new javax.swing.JButton();
        textFieldLength = new javax.swing.JTextField();
        labelLength = new javax.swing.JLabel();
        buttonConnect = new javax.swing.JButton();
        labelError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Drawing Client");
        setName("frameClient"); // NOI18N
        setResizable(false);

        buttonNorth.setText("^");
        buttonNorth.setPreferredSize(new java.awt.Dimension(40, 40));
        buttonNorth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNorthActionPerformed(evt);
            }
        });

        buttonWest.setText("<");
        buttonWest.setPreferredSize(new java.awt.Dimension(40, 40));
        buttonWest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWestActionPerformed(evt);
            }
        });

        buttonEast.setText(">");
        buttonEast.setPreferredSize(new java.awt.Dimension(40, 40));
        buttonEast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEastActionPerformed(evt);
            }
        });

        buttonSouth.setText("v");
        buttonSouth.setPreferredSize(new java.awt.Dimension(40, 40));
        buttonSouth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSouthActionPerformed(evt);
            }
        });

        textFieldServerIP.setToolTipText("");
        textFieldServerIP.setMinimumSize(new java.awt.Dimension(10, 100));
        textFieldServerIP.setPreferredSize(new java.awt.Dimension(120, 26));
        textFieldServerIP.setSize(new java.awt.Dimension(120, 26));

        textFieldServerPort.setMinimumSize(new java.awt.Dimension(40, 26));
        textFieldServerPort.setPreferredSize(new java.awt.Dimension(55, 26));
        textFieldServerPort.setSize(new java.awt.Dimension(60, 26));

        labelServerIP.setText("Server IP");

        labelServerPort.setText("Server Port");

        labelPenStatus.setText("Pen status");

        groupPenStatus.add(radioPenUp);
        radioPenUp.setSelected(true);
        radioPenUp.setText("up");
        radioPenUp.setActionCommand("up");

        groupPenStatus.add(radioPenDown);
        radioPenDown.setText("down");
        radioPenDown.setActionCommand("down");

        buttonEnd.setText("End");
        buttonEnd.setMaximumSize(new java.awt.Dimension(100, 29));
        buttonEnd.setMinimumSize(new java.awt.Dimension(100, 29));
        buttonEnd.setPreferredSize(new java.awt.Dimension(100, 29));
        buttonEnd.setSize(new java.awt.Dimension(100, 29));
        buttonEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEndActionPerformed(evt);
            }
        });

        textFieldLength.setMinimumSize(new java.awt.Dimension(50, 26));
        textFieldLength.setPreferredSize(new java.awt.Dimension(50, 26));
        textFieldLength.setSize(new java.awt.Dimension(50, 26));

        labelLength.setText("Length");

        buttonConnect.setText("Connect");
        buttonConnect.setMaximumSize(new java.awt.Dimension(100, 29));
        buttonConnect.setMinimumSize(new java.awt.Dimension(100, 29));
        buttonConnect.setPreferredSize(new java.awt.Dimension(100, 29));
        buttonConnect.setSize(new java.awt.Dimension(100, 29));
        buttonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectActionPerformed(evt);
            }
        });

        labelError.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelError.setToolTipText("");
        labelError.setMaximumSize(new java.awt.Dimension(33, 10));
        labelError.setMinimumSize(new java.awt.Dimension(33, 10));
        labelError.setPreferredSize(new java.awt.Dimension(300, 10));
        labelError.setSize(new java.awt.Dimension(300, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPenStatus)
                        .addGap(18, 18, 18)
                        .addComponent(labelLength))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioPenDown)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioPenUp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(textFieldLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonWest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonSouth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonNorth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonEast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textFieldServerIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelServerIP)
                                        .addGap(73, 73, 73)
                                        .addComponent(labelServerPort)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(buttonConnect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelServerIP)
                            .addComponent(labelServerPort))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldServerIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPenStatus)
                            .addComponent(labelLength, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(radioPenUp)
                                    .addComponent(textFieldLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioPenDown))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(buttonEast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonWest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)))
                        .addGap(22, 22, 22)
                        .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(buttonNorth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonSouth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// END Creating GUI                       

	//Will be called when the End button is clicked.
	//Closes the connection and exits the program
    private void buttonEndActionPerformed(java.awt.event.ActionEvent evt){                                          
        try {
            socket.close();
            toServer.close();
            System.exit(0);
        } catch (Exception e) { 
            System.exit(0);
        }
    }                        

	//Will be called when the Connect/Disconnect button is clicked.
	//If button is "Connect", attempts to connect to the server with the given IP and Port
	//numbers found in the textFieldServerIP and textFieldServerPort respectively.
	//Otherwise will attempt to close the connection to the server
    private void buttonConnectActionPerformed(java.awt.event.ActionEvent evt) {                                              
        //Connect to server
        if(buttonConnect.getText()=="Connect"){
            
            try {
                socket = new Socket(textFieldServerIP.getText(),Integer.parseInt(textFieldServerPort.getText())); //open Socket
                toServer = new PrintStream(socket.getOutputStream());
                buttonConnect.setText("Disconnect");
                labelError.setText("");

            } catch (Exception e) {
                labelError.setText("Check Server IP and Port");
                }
            
        }else{
            //Disconnect form server
            try {
                socket.close();
                toServer.close();
                buttonConnect.setText("Connect");
            } catch (Exception e) {
                labelError.setText("Connection not Closed");
            }
        }
    }                                             


	//Will form the string to be sent to the server. Takes a direction
	//and will gather data from the textFieldLength and pen up/down radio box.
	//Then sends the string to the server and prints it to the console.
    public void formText(String direction){
        labelError.setText("");
	    if(socket != null && socket.isConnected()){
	        if(textFieldLength.getText().isEmpty()){
	            labelError.setText("Error: Lengthfield is empty");
	        }else{
	            toServer.println(direction+":"+textFieldLength.getText()+":"+groupPenStatus.getSelection().getActionCommand());
	            System.out.println(direction+":"+textFieldLength.getText()+":"+groupPenStatus.getSelection().getActionCommand());
	        }
	    }else{labelError.setText("Error: Not connected");}
    }

    //Called when North button is clicked. Will send "N" to formText method
    public void buttonNorthActionPerformed(java.awt.event.ActionEvent evt) {
        formText("N");
    }                                           

    //Called when West button is clicked. Will send "N" to formText method
    public void buttonWestActionPerformed(java.awt.event.ActionEvent evt) {                                           
        formText("W");
    }                                          

    //Called when South button is clicked. Will send "N" to formText method
    public void buttonSouthActionPerformed(java.awt.event.ActionEvent evt) {                                            
        formText("S");
    }                                           

    //Called when East button is clicked. Will send "N" to formText method
    public void buttonEastActionPerformed(java.awt.event.ActionEvent evt) {                                           
        formText("E");
    }                                          

	//Main class used to start the GUI interface.
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientDrawingControlUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientDrawingControlUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientDrawingControlUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientDrawingControlUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientDrawingControlUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton buttonConnect;
    private javax.swing.JButton buttonEast;
    private javax.swing.JButton buttonEnd;
    private javax.swing.JButton buttonNorth;
    private javax.swing.JButton buttonSouth;
    private javax.swing.JButton buttonWest;
    private javax.swing.ButtonGroup groupPenStatus;
    private javax.swing.JLabel labelError;
    private javax.swing.JLabel labelLength;
    private javax.swing.JLabel labelPenStatus;
    private javax.swing.JLabel labelServerIP;
    private javax.swing.JLabel labelServerPort;
    private javax.swing.JRadioButton radioPenDown;
    private javax.swing.JRadioButton radioPenUp;
    private javax.swing.JTextField textFieldLength;
    private javax.swing.JTextField textFieldServerIP;
    private javax.swing.JTextField textFieldServerPort;
    // End of variables declaration                   
}
