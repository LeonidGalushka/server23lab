import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerFacade {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public ServerFacade(Socket socket) throws IOException {
        this.socket = socket;
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }


    public String getMessage() throws IOException {
        String clientMessage = Constants.NUN_MESSAGE;
        while (in.available() > 0) {
            clientMessage += in.readUTF() ;//+ '\n';
        }
        return clientMessage;
    }

    public void setMassage(String massage) throws IOException {
        out.writeUTF(massage);
        out.flush();
    }

    public void close() throws IOException {
        socket.close();
        in.close();
        out.close();
    }
}
