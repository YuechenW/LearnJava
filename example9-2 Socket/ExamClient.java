import java.net.*;
import java.io.*;
public class ExamClient {
    static Socket svr;
    public static void main(String[] args) throws Exception {
        System.out.println("�������ӷ����������Ժ�");
        svr = new Socket(InetAddress.getLocalHost(),3300);
        if(svr != null)
            System.out.println("��" + svr.getInetAddress() + 
            "���ӳɹ���������Ҫ���͵���Ϣ��");
        BufferedReader in = new BufferedReader(new 
            InputStreamReader(svr.getInputStream()));
        PrintWriter out = new PrintWriter(svr.getOutputStream());
        BufferedReader wt = new BufferedReader(new
            InputStreamReader(System.in));
        while(true) {
            String str = wt.readLine();
            out.println(str);
            out.flush();
            if(str.equals("bye")) {
                in.close();
                out.close();
                break;
            }
            System.out.print(in.readLine());
        }
        svr.close();
    }
}