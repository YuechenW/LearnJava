package exception;

import java.util.Scanner;

public class ArrayIndex {

	public static void f() {
		int[] a = new int[10];
		a[10] = 10;
	}
	
	public static void g() {
		f();
	}
	
	public static void h() {
		int i = 10;
		if(i<100) {
			g();
		}
	}
	
	public static void k() {
		try {
			h();
		}
		catch (/*NullPointerException*/ArrayIndexOutOfBoundsException e) {
			System.out.print("k()");
			throw e;
		}
	}
	
	public static void main(String[] args) {
//		int[] a = new int [10];
//		int idx;
//		Scanner in = new Scanner(System.in);
//		idx = in.nextInt(); 
		try {
//			a[idx] = 10;
//			System.out.println("hello");
			k();
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Cought");
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		System.out.println("main");
	}
}
