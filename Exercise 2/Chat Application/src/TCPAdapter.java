import java.io.PrintWriter;

public class TCPAdapter extends CommunicationAdapter {
    private PrintWriter out;

    public TCPAdapter(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void sendMessage(String message) {
        out.println(message);
    }
}
