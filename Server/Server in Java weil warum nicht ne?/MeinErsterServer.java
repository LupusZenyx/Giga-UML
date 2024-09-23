import java.io.*;
import java.net.*;

public class MeinErsterServer
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
        		outputstream = socket.getOutputStream();
      			outputstream.write(42);
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

