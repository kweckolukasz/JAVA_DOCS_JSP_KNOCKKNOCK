import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class KnockKnockClient {

    /*Server: "Knock knock!"
    Client: "Who's there?"
    Server: "Dexter."
    Client: "Dexter who?"
    Server: "Dexter halls with boughs of holly."
    Client: "Groan."*/

    int port = 8080;
    String host = "localhost";
    String input, output;
    Scanner sc = new Scanner(System.in);

    private void createClientSocket() throws IOException {
        try (
                Socket socket = new Socket(host, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))

        ) {
            while (null != (input = in.readLine())) {
                System.out.println("Server: "+input);
                System.out.println("What's your response?");
                output = sc.nextLine();
                out.println(output);
                if (input.equals("Bye.")) break;
            }
        }
    }

    public static void main(String[] args) {
        KnockKnockClient kkc = new KnockKnockClient();
        try {
            kkc.createClientSocket();
        } catch (IOException e) {
            System.out.println("KnockKnockClient.main.createClientSocket");
            e.printStackTrace();
        }
    }
}
