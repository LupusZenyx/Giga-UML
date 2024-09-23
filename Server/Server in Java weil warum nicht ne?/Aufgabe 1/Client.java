import java.net.*;
import java.io.*;
import java.util.Random;

class Client
{
	public static void main( String[] args )
  	{
    	Socket socket = null;
		InputStream  inputstream = null;
		int sum;

    	try
    	{
      		socket = new Socket("localhost",2345);
      		inputstream  = socket.getInputStream();
            OutputStream outputstream = socket.getOutputStream();
            Random random = new Random();
            int num1 = random.nextInt(100);
            int num2 = random.nextInt(100);

            outputstream.write(num1);
            outputstream.write(num2);
      		sum = inputstream.read();
      		System.out.println(sum);
    		inputstream.close();
            outputstream.close();
    		socket.close();
    	}

    	catch (Exception e)
    	{
      		e.printStackTrace();
    	}
  	}
}