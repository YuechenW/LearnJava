package hello;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���");
		Scanner in = new Scanner(System.in);
//		System.out.println("echo:" + in.nextLine());
		int amount = 100;
		int price = 0;
		System.out.print("������Ʊ�棺");
		amount = in.nextInt();
		System.out.print("�������");
		price = in.nextInt();
		System.out.println(amount+"-"+price+"="+(amount-price));
		double a = 1.0;
		double b = 0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1;
		System.out.println(a==b);
		System.out.println(Math.abs(a-b)<1e-6);
	}

}
