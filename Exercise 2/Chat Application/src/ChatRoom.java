import java.io.*;
import java.util.*;

public class ChatRoom {
    private static Map<String, ChatRoom> chatRooms = new HashMap<>();
    private List<ClientHandler> users;
    private List<String> messageHistory;
    private String hostId;

    private ChatRoom(String hostId) {
        this.hostId = hostId;
        this.users = new ArrayList<>();
        this.messageHistory = new ArrayList<>();
    }

    // Singleton: Get or create chat room instance
    public static synchronized ChatRoom getInstance(String hostId) {
        return chatRooms.computeIfAbsent(hostId, id -> new ChatRoom(id));
    }

    // Add user to chat room
    public void addUser(ClientHandler user) {
        users.add(user);
        notifyAllUsers(user.getUserName() + " has joined the chat!");
        updateActiveUsers();
    }

    // Remove user from chat room
    public void removeUser(ClientHandler user) {
        users.remove(user);
        notifyAllUsers(user.getUserName() + " has left the chat.");
        updateActiveUsers();
    }

    // Notify all users in the chat room
    public void notifyAllUsers(String message) {
        messageHistory.add(message);
        for (ClientHandler user : users) {
            user.sendMessage(message);
        }
    }

    // Send the list of active users
    public void updateActiveUsers() {
        StringBuilder activeUsers = new StringBuilder("Active users: ");
        for (ClientHandler user : users) {
            activeUsers.append(user.getUserName()).append(", ");
        }
        notifyAllUsers(activeUsers.toString());
    }

    // Return message history
    public List<String> getMessageHistory() {
        return messageHistory;
    }

    // Save message history to file
    public void saveMessageHistory() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("history_" + hostId + ".txt", true))) {
            for (String message : messageHistory) {
                writer.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load message history from file
    public void loadMessageHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader("history_" + hostId + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                messageHistory.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // New method to return the list of active users (ClientHandler instances)
    public List<ClientHandler> getUsers() {
        return users;
    }
}
