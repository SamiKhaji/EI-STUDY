## Real-Time Chat Room System

This project implements a real-time chat room system in Java, allowing users to create or join chat rooms using unique room IDs. Users can interact with others in the same chat room by sending and receiving messages in real-time. The system displays a list of active users in the chat room and supports private messaging. Additionally, the chat history is preserved, allowing users to view past messages even after rejoining a chat room.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources and codes
- `lib`: the folder to maintain dependencies
## Key Features:
Create/Join Chat Rooms: Users can enter a unique room ID to join an existing chat room or create a new one.
Real-Time Messaging: Users can send and receive messages in real-time within a chat room.
Active Users List: The system displays the list of active users in the chat room.
Private Messaging: Users can send private messages to specific participants.
Message History: Chat history is saved and loaded, so users can view messages from previous sessions.
Observer Pattern: Automatically notifies users of new messages and user activities.
Singleton Pattern: Manages the chat rooms to ensure a single instance per room.
Adapter Pattern: Provides flexibility to support different communication protocols.

## How to Run the Project:
Server:

Run the Server.java file to start the chat server.
The server listens on a specified port (default: 12345).

Client:
Run the ChatClient.java file to start the client.
Enter the server address, username, and a unique room ID to join or create a chat room.
Start sending and receiving messages in real-time.

## private messaging
To send a private message, a user types the command in the format:
# /pm [recipient_username] [message]


