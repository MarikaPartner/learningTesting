package lesson_6.SocetExample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main (String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("The server is running. Waiting for connection...");

            Socket socket = serverSocket.accept();
            System.out.println("The client is connected.");

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while (true) {
                String clientRequest = dataInputStream.readUTF();
                if (clientRequest.equals("end")) break;

                System.out.println("Message received: " + clientRequest);
                dataOutputStream.writeUTF("Reply to the message: " + clientRequest);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
