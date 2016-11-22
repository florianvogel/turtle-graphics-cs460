## turtle-graphics-cs460
#Server

This is the second part of our last programming assignment, working on the rest of the application (i.e. the server) that mimics a distributed white board.

What to develop

After you developed the client in the prior assignment, now I ask you to work on the server part, that actually represents the distributed white board. Much of the information that you already saw will be repeated in the following.

The server interprets and executes the commands, which results in simple lines being drawn on the white board. At any time there may be several clients talking to the server and thus drawing on the white board.

The white board behaves like a turtle graphics application. This means that there is a single pen, which may be lifted (and thus does not draw) or put down (when it is supposed to draw). The pen can be moved in any one direction of north/south/east/west. When it is moved, it will do so in a pre-configured (but not hard-coded) increment in terms of length. This may or may not result in a line being drawn, depending on whether the pen is lifted (up) or not (down).

At a minimum, the server needs to be able to receive a batch of commands (like pen up, move N x, pen down, move S x, ...) within the context of one connection. It is up to you whether you leave the connection open or not thereafter.

What to submit

Submit the following on the due date:

    The source file(s) of the client, as well as of the server, to be written in Java.
    Two runnable jar files, one that contains the client and one that contains the server. Please understand that jar archives contain compiled code and normally no source code, so make sure that you comply to the first bullet above. Just submitting the jar archives alone is not enough.
    A quick write-up that has detailed information about how to make your code run on any system that has Java installed. The above jar files should help a lot. This includes requirements as to what libraries need to be provided, in addition to what normally comprises a standard Java installation.
    IMPORTANT: I want to see your code running! Submit a video clip that shows two "players" trying to draw a circle on the distributed white board. You want to make sure that both the clients' screens as well as the server screen are visible.

Hints

The signaling is of the essence. You will want to make a wise decision as to whether you leave the connection open to the server for any number of commands or just follow the request/response pattern that you saw in HTTP. Similarly, you will want to think about using a parallel server versus a non-parallel server. In this assignment you will not get dinged for simplicity. At the minimum, however, your server needs to be able to receive, and process, a batch of atomic commands.
