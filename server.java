
import java.util.*;
import java.io.*;
import java.net.*;

class server {

  Thread rec;
  Thread send;
  ServerSocket serverSocket;
  Socket socket;
  DataInputStream dataIn;
  DataOutputStream dataOut;
  BufferedReader buffReader;
  String messageIn = "";
  String messageOut = "";
  String username = "";


  public server() {
    try {
      Scanner input = new Scanner(System.in);
      System.out.print("What is server's name? ");
      username = input.nextLine();
      System.out.println("Let's start talking! " + username);
      serverSocket = new ServerSocket(1201);
      socket = serverSocket.accept();
      dataIn = new DataInputStream(socket.getInputStream());
      dataOut = new DataOutputStream(socket.getOutputStream());
      buffReader = new BufferedReader(new InputStreamReader(System.in));
      rec = new Thread(new serverReceive(this));
      send = new Thread(new serverSend(this));
    } catch(Exception e) {
      System.out.print( e );
    }
  }

  public void run() {
    rec.start();
    send.start();
  }

}
