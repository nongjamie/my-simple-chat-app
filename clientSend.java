import java.io.*;
import java.net.*;

class clientSend implements Runnable {

  client c;

  public clientSend(client c) {
    this.c = c;
  }

  public void run() {
    try {
      while( true ) {
        c.messageOut = c.buffReader.readLine();
        c.messageOut = "(" + c.username + " says:) " + c.messageOut;
        c.dataOut.writeUTF(c.messageOut);
      }
    } catch(Exception e) {

    }
  }

}
