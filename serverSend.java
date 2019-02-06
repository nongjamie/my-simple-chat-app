import java.io.*;
import java.net.*;

class serverSend implements Runnable {

  server s;

  public serverSend(server s) {
    this.s = s;
  }

  public void run() {
    try {
      while( true ) {
        s.messageOut = s.buffReader.readLine();
        s.messageOut  = "(" + s.username + " says:) " + s.messageOut;
        s.dataOut.writeUTF(s.messageOut);
        s.dataOut.flush();
      }
    } catch(Exception e) {

    }
  }

}
