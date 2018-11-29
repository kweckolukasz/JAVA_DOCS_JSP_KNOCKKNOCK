public class KnockKnockProtocol {

    public String processInput(String inputLine) {
        String response = "error in communication in KKP";
        if (inputLine.equals("Who's there?")) response = "Dexter.";
        else if (inputLine.equals("Dexter who?")) response = "Dexter halls with boughs of holly.";
        else if (inputLine.equals("Bye.")) response = "Bye.";
        return response;
    }
}
