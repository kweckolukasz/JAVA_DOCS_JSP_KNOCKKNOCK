import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class KKS_Thread implements Runnable {
    Socket socket;
    PrintWriter out;
    BufferedReader in;
    String inputLine, outputLine;

    public KKS_Thread(Socket socket, PrintWriter out, BufferedReader in) {
        this.socket = socket;
        this.out = out;
        this.in = in;
    }

    @Override
    public void run() {
        out.println("Knock knock!");
        KnockKnockProtocol kkp = new KnockKnockProtocol();
        try {
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client: "+inputLine);
                outputLine = kkp.processInput(inputLine);
                out.println(outputLine);
                if (inputLine.equals("Bye.")) break;
            }
        } catch (IOException e) {
            System.out.println("KKS_Thread.run");
            e.printStackTrace();
        }
    }
}
