import java.net.*;
import java.util.Scanner;

public class inetaddress {
    public static InetAddress ina;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String host = in.nextLine();
        try {
            ina = InetAddress.getByName(host);
            System.out.println(ina.getHostAddress());
            System.out.println(ina.getHostName());
            System.out.println("********************");
            ina = InetAddress.getLocalHost();
            System.out.println("" + ina);
        } catch(ArrayIndexOutOfBoundsException e1) {}
        catch(Exception e) {
            System.out.println(e);
        }
    }
}