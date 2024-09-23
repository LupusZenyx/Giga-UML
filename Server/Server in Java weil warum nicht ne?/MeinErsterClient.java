import java.net.*;
import java.io.*;

class MeinErsterClient
{
	public static void main( String[] args )
  	{
    	Socket socket = null;
		InputStream  inputstream = null;
		int zahl;

    	try
    	{
      		socket = new Socket("localhost",2345);
      		inputstream  = socket.getInputStream();
      		zahl = inputstream.read();
      		System.out.println(zahl);
    		inputstream.close();
    		socket.close();
    	}

    	catch (Exception e)
    	{
      		e.printStackTrace();
    	}
  	}
}