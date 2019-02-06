import java.io.*;
import java.net.*;
import java.util.*;

class client {

  Thread rec;
  Thread send;
  Socket socket;
  DataInputStream dataIn;
  DataOutputStream dataOut;
  BufferedReader buffReader;
  String messageIn = "";
  String messageOut = "";
  String username = "";

  public client() {
    try {
      Scanner input = new Scanner(System.in);
      System.out.print("What is client's name? ");
      username = input.nextLine();
      System.out.println("Let's start talking! " + username);
      socket = new Socket("127.0.0.1", 1201);
      dataIn = new DataInputStream(socket.getInputStream());
      dataOut = new DataOutputStream(socket.getOutputStream());
      buffReader = new BufferedReader(new InputStreamReader(System.in));
      rec = new Thread(new clientReceive(this));
      send = new Thread(new clientSend(this));
    } catch(Exception e) {

    }
  }

  public void run() {
    rec.start();
    send.start();
  }

}
