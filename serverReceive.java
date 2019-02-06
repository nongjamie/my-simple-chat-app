import java.io.*;
import java.net.*;

class serverReceive implements Runnable {

  server s;

  public serverReceive(server s) {
    this.s = s;
  }

  public void run() {
    try {
      while(!s.messageIn.equals("end")) {
        s.messageIn = s.dataIn.readUTF();
        System.out.println(s.messageIn);
      }
      s.socket.close();
    } catch(Exception e) {

    }
  }

}
