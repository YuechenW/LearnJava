import java.util.Scanner;

class Scannertest {
    public static void main(String[] args) {
        double d;
        float f;
        int i;
        long l;
        boolean b;
        Scanner keyin = new Scanner(System.in);
        System.out.println("������һ��˫��������");
        d = keyin.nextDouble();
        System.out.println("������һ����������: ");
        f = keyin.nextFloat();
        System.out.println("������һ������: ");
        i = keyin.nextInt();
        System.out.println("������һ��������: ");
        l = keyin.nextLong();
        System.out.println("������һ���߼�ֵ: ");
        b = keyin.nextBoolean();
        System.out.println("����������ֱ���: ");
        System.out.print("d=" + d + "\nf=" + f + "\ni=" + i + "\nl=" + l + "\nb=" + b);
    }
}