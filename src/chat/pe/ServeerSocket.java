package chat.pe;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServeerSocket {
	public static void main(String[] args) throws IOException {
        String input, output;
        
        ServerSocket serverSocket = new ServerSocket(6789);
        
        Socket connectionSocket = serverSocket.accept();
        
        Scanner inFromClient = new Scanner(connectionSocket.getInputStream());
        PrintWriter outFromServer = new PrintWriter(connectionSocket.getOutputStream(),true);
        Scanner inFromServer = new Scanner(System.in);
        
        while (true) {
            input = inFromClient.nextLine();
            System.out.println("(Usuario Recurrente) Yeikov: "+input);
            
            if(input.equals("**close**")){
                break;
            }
            
            System.out.print("(Respuesta del Server) BotIo: ");
            output = inFromServer.nextLine();

            outFromServer.println(output);
           
            //outFromServer.flush();
            
        }
        serverSocket.close();
    }
}
