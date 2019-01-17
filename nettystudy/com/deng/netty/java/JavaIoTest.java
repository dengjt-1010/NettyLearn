import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by deng on 19-1-16.
 *  nc 100.81.132.85 8889 不能有两个进程连接
 */
public class JavaIoTest {

    public static void test() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8889);
        Socket clientSocket = serverSocket.accept();

        System.out.println("link established");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        System.out.println("create in and out");
        String request, response;
        while ((request = in.readLine()) != null) {
            if ("Done".equals(request)) {
                break;
            }
            response = "qqqq"+request;
            out.println(response);
        }
    }

    }
