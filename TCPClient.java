import java.io.*;
import java.net.*;

public class TCPClient {
	public static void main(String argv[]) throws Exception {
		String sentence;
		String modifiedSentence;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 6761);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		while(true)
		{
			sentence = inFromUser.readLine();
			if(sentence.equalsIgnoreCase("bye") || sentence.equalsIgnoreCase("quit") || sentence.equalsIgnoreCase("exist")) {
				outToServer.writeBytes(sentence + '\n');
				modifiedSentence = inFromServer.readLine();
				clientSocket.close();
				break;
			
			}
			outToServer.writeBytes(sentence + '\n');
			modifiedSentence = inFromServer.readLine();
			System.out.println("FROM SERVER: " + modifiedSentence);
		}
		
		
	}
}