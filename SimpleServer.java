import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    public SimpleServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started and Listing "+port);
    }
    public void acceptClient() throws IOException {
        socket=serverSocket.accept();
        InputStream i = socket.getInputStream();
        OutputStream o = socket.getOutputStream();
        in = new Scanner(i);
        out = new PrintWriter(o, true);

    }
    public String receiveMessage() {
        return in.nextLine();
    }
    public void sendMessage(String message) {
        out.println(message);
    }
    public void close() {
    }
    public static void main(String[] args) {
        try{
            SimpleServer s = new SimpleServer(8888);
            s.acceptClient();
            String user = s.receiveMessage();
            s.sendMessage("Recivied:" + user);
            s.close();
        }
        catch(Exception e){
            System.out.println("Exception occured");
            e.printStackTrace();
        }
    }
}
