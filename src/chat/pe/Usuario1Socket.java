package chat.pe;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Usuario1Socket {
    public static void main(String[] args) throws IOException {
        String message, inFromServer;
        
        Socket usuario1Socket = new Socket("localhost", 6789);
        System.out.println("Establishing connection....");
        
        Scanner inputFromUser = new Scanner(System.in);
        PrintWriter outputToServer = new PrintWriter(usuario1Socket.getOutputStream(),true);
        Scanner inputFromServer = new Scanner(usuario1Socket.getInputStream());
        while(true){
            System.out.print("(Usuario Recurrente) Yeikov: ");
            message = inputFromUser.nextLine();
            
            outputToServer.println(message);
            if(message.equals("**close**"))
                break;
            
            inFromServer = inputFromServer.nextLine();
            System.out.println("(Respuesta del Server) BotIo: "+inFromServer);
        }
        usuario1Socket.close();
    }
}
