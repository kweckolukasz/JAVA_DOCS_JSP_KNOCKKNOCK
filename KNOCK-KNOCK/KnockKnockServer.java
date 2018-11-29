import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class KnockKnockServer {


    private void createServerSocket() throws IOException {

        try (
                ServerSocket serverSocket = new ServerSocket(8080);
                Socket socket = serverSocket.accept();
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(socket.getOutputStream()),true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))
        ) {
                KKS_Thread thread = new KKS_Thread(socket, out, in);
                thread.run();
        }
    }

    public static void main(String[] args) {
        KnockKnockServer knockKnockServer = new KnockKnockServer();
        while (true) {
            try {
                knockKnockServer.createServerSocket();
            } catch (IOException e) {
                System.out.println("createServerSocket.KnockKnockServer.main");
                e.printStackTrace();
            }
        }
    }
}
