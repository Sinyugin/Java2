import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Ждем подключение клиента...");
            final Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            final DataInputStream in = new DataInputStream(socket.getInputStream());
            final DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {              //поток для отправки сообщений из сервера
                Scanner scanner = new Scanner(System.in);
                while (!socket.isClosed()) {
                    final String messageServer = (scanner.nextLine());
                    try {
                        if ("/end".equals(messageServer)) {
                            break;
                        }
                        System.out.println("Сообщение от сервера: " + messageServer);
                        out.writeUTF(messageServer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Поток отправки от сервера завершен");
            }).start();


            while (true) {
                final String message = in.readUTF();
                if ("/end".equals(message)) {
                    out.writeUTF("/end");
                    break;
                }
                System.out.println("Сообщение от клиента: " + message);
                out.writeUTF("[echo]" + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
