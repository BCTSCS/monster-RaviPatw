import java.io.*;
import java.net.*;
import java.util.*;
public class SimpleServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    public SimpleServer(int port) throws IOException  {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port "+ port);



    }
    public void acceptClient() throws IOException {
        socket = serverSocket.accept();
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
    public static void main(String[] args) throws IOException{
        SimpleServer s = new SimpleServer(8080);
        String user;
        s.acceptClient();
        // FileOperator file = new FileOperator("server.txt");
        FileOperator file = new FileOperator("index.html");
        user = s.receiveMessage();
        System.out.println("Headers:"+user);
        s.sendMessage("HTTP/1.1 200 OK");
        s.sendMessage("Content-Type: text/html");
        s.sendMessage("");

        while(true){
            String response = file.readLine();
            s.sendMessage(response);
            if(response==null){
                break;
            }
            }
        s.close();
        }
}


