import java.io.*;
import java.net.*;

public class Server
{
	public static void main(String[] args)
  	{
    	ServerSocket serversocket = null;
   		Socket socket = null;
   		OutputStream outputstream = null;


    	try
      	{
        	serversocket = new ServerSocket(2345);

        	while(true)
        	{
				System.out.println("Warte auf Client...");
				socket = serversocket.accept();
				System.out.println("Bin mit Client verbunden.");
				InputStream inputstream = socket.getInputStream();

				int num1 = inputstream.read();
				int num2 = inputstream.read();
				int sum = num1 + num2;

				outputstream = socket.getOutputStream();

				outputstream.write(sum);

				inputstream.close();
				outputstream.close();
				socket.close();
      		}
		}

  		catch (Exception e)
   		{
   			e.printStackTrace();
   		}
 	}
}

