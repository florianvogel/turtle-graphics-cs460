# turtle-graphics-cs460
This last programming assignment in this class is a fun application, which mimics a distributed white board that can be 
drawn on. The work will be split in two assignments. In this first step, you are going to develop the protocol to be used 
and the client   . 
What to develop - Overview  
  The application to be developed has two parts: 
    a server, that represents a distributed "white board" and 
    a client application, that sends commands to the server. 
The server interprets and executes the commands, which results in simple lines being drawn on the white board. 
At any time there may be several clients talking to the server and thus drawing on the white board.  
The white board behaves like a turtle graphics application. This means that there is a single pen, which may be 
lifted (and thus does not draw) or put down (when it is supposed to draw). The pen can be moved in any one direction of 
north/south/east/west. When it is moved, it will do so in a pre-configured (but not hard-coded) increment in terms 
of length. This may or may not result in a line being drawn, depending on whether the pen is lifted (up) or not (down).  
The client has a simple GUI with these input elements:
  Server address/port
  Buttons that represent the geographic directions N/S/E/W. 
    If any one of these buttons is hit the pen is moved in that direction hit, at a length that is configurable.
  Buttons UP/DOWN for lifting the pen or putting it down
  Field to input the length of the distance to be moved upon hitting one of N/S/E/W
What to submit  Submit the following:
  A write-up that specifies the protocol you plan to use, which contains a detailed description of the commands that the 
  server needs to be able to understand. You also need to specify if you plan to keep the connection to the server open or 
  not, after a batch of commands was send.
  The source file(s) of the client, to be written in Java.
