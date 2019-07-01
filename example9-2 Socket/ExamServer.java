import java.io.*;
import java.net.*;
public class ExamServer {
    public static void main(String[] args) throws IOException {
        ServerSocket svr = new ServerSocket(3300);
        System.out.println("等待连接");
        Socket clt = svr.accept();
        BufferedReader in = new BufferedReader(new
            InputStreamReader(clt.getInputStream()));
            PrintWriter out = new PrintWriter(clt.getOutputStream());
            while(true) {
                String str = in.readLine();
                System.out.println(str);
                out.println("服务器已收到您发送的:" + str);
                out.flush();
                if(str.equals("bye")) {
                    in.close();
                    out.close();
                    break;
                }
            }
            clt.close();
    }
}