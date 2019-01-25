import java.io.*;
import java.net.*;

public class socketS implements Runnable{

	public static void main(String Argv[]) throws Exception {
		new Thread(new socketS()).start();
	}

	public void run(){
		ServerSocket ssocket = null;
		Socket s = null;
		String i = null;
		String o;
		try {
			ssocket =new ServerSocket(1234);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while(true){


				try {
					s= ssocket.accept();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			while(true){
			BufferedReader inFromClient = null;
			System.out.println("asd");
				try {
					inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					break;
				}
				try {
					i = inFromClient.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					break;
				}
			System.out.println(i);}
		}
	}

}
