import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;

class Student implements Serializable {
	private String name;
	int age;
	int grade;
	
	public Student(String name, int age, int grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	
	public String toString() {
		return name+" "+age+" "+grade;
	}
}
public class Main {

	public static void main(String[] args) {
//		try {
//			Socket socket = new Socket(InetAddress.getByName("localhost"),12345);
//			PrintWriter out = new PrintWriter(
//					new BufferedWriter(
//							new OutputStreamWriter(
//									socket.getOutputStream())));
//			out.println("Hello");
//			out.flush();
//			BufferedReader in = new BufferedReader(
//					new InputStreamReader(
//							socket.getInputStream()));
//			String line;
//			line = in.readLine();
//			System.out.println(line);
//			out.close();
//			socket.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			Student s1 = new Student("John",18,5);
			System.out.println(s1);
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("obj.dat"));
			out.writeObject(s1);
			out.close();
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream("obj.dat"));
			Student s2 = (Student)in.readObject();
			System.out.println(s2);
			in.close();
			System.out.println(s1==s2);
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
