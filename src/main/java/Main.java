import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Server.getInstance().serverStart();
        } catch (IOException e) {
            System.out.println(Constants.ERROR_START_SERVER);
        }
    }

}
