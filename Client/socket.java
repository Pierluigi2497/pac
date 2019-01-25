import java.io.*;
import java.net.*;
public class socket{
  public ObjectInputStream inFromServer;
  public ObjectOutputStream outToServer;
  public Socket clientSocket;

  public void Send(char g) throws IOException{
    outToServer.writeObject(""+g);
  }

  public String Receive() throws Exception{
    return (String)inFromServer.readObject();
  }

  public socket(){
    try{clientSocket= new Socket("192.168.1.118", 1234);
    outToServer= new ObjectOutputStream(clientSocket.getOutputStream());
    inFromServer= new ObjectInputStream(clientSocket.getInputStream());
  }
    catch(Exception e){e.printStackTrace();}
  }
  
}
