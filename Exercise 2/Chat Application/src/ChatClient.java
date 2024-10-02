import java.io.*;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        String serverAddress;
        String userName;
        String hostId;
        int port = 12345; // Must match the server port

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter server address:");
            serverAddress = consoleReader.readLine();

            System.out.println("Enter your username:");
            userName = consoleReader.readLine();

            System.out.println("Enter host ID to join:");
            hostId = consoleReader.readLine();

            try (Socket socket = new Socket(serverAddress, port);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                out.println(userName); // Send username to server
                out.println(hostId);   // Send host ID to server

                // Listen for incoming messages from server
                Thread listenerThread = new Thread(() -> {
                    String incomingMessage;
                    try {
                        while ((incomingMessage = in.readLine()) != null) {
                            System.out.println(incomingMessage);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                listenerThread.start();

                // Send messages to the server
                String message;
                while ((message = consoleReader.readLine()) != null) {
                    out.println(message);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
