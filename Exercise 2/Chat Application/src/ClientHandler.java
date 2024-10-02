import java.io.*;
import java.net.*;

class ClientHandler implements Runnable {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String userName;
    private String hostId;
    private ChatRoom chatRoom;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Get the user's name and host ID (chat room ID)
            userName = in.readLine();
            hostId = in.readLine();

            // Get or create the chat room
            chatRoom = ChatRoom.getInstance(hostId);
            chatRoom.loadMessageHistory(); // Load previous messages
            chatRoom.addUser(this);

            // Send message history to the user
            for (String message : chatRoom.getMessageHistory()) {
                sendMessage(message);
            }

            String message;
            while ((message = in.readLine()) != null) {
                if (message.startsWith("/pm")) {
                    // Private message: /pm [username] [message]
                    String[] split = message.split(" ", 3);
                    if (split.length == 3) {
                        String recipient = split[1];
                        String privateMessage = split[2];
                        sendPrivateMessage(recipient, privateMessage);
                    }
                } else {
                    chatRoom.notifyAllUsers(userName + ": " + message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            chatRoom.removeUser(this);
            chatRoom.saveMessageHistory();
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    // Private messaging logic
    private void sendPrivateMessage(String recipientName, String message) {
        for (ClientHandler user : chatRoom.getUsers()) {
            if (user.getUserName().equals(recipientName)) {
                user.sendMessage("[Private] " + userName + ": " + message);
                return;
            }
        }
        sendMessage("User " + recipientName + " not found.");
    }

    public String getUserName() {
        return userName;
    }
}
