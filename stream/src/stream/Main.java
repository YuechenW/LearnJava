package stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World");
		/*byte[] buffer = new byte[1024];
		try {
			int len = System.in.read(buffer);
			String s = new String(buffer,0,len);
			System.out.println("读到了"+len+"字节");//字节
			System.out.println(s);
			System.out.println("s的长度是："+s.length());//字符
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
		byte[] buf = new byte[10];
		for(int i=0; i<buf.length; i++) {
			buf[i] = (byte)i;
		}
		try {
//			DataOutputStream out = new DataOutputStream(
//					new BufferedOutputStream(
//							new FileOutputStream("a.dat")));
			PrintWriter out = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream("a.txt"))));
			int i = /*0xcafebabe*/123456;
//			out.writeInt(i);
			out.println(i);
			out.close();
//			DataInputStream in = new DataInputStream(
//					new BufferedInputStream(
//							new FileInputStream("a.dat")));
//			int j = in.readInt();
//			System.out.println(j);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("utf8.txt"),"utf8"));
			String line;
			while((line=in.readLine())!=null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 
	}
}
