import java.io.*;
import java.net.*;

class clientReceive implements Runnable {

  client c;

  public clientReceive(client c) {
    this.c = c;
  }

  public void run() {
    try {
      while(!c.messageIn.equals("end")) {
        c.messageIn = c.dataIn.readUTF();
        System.out.println(c.messageIn);
      }
    } catch(Exception e) {

    }
  }

}
