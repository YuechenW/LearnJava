import java.io.*;
class mytype {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream(args[0]);
            int ch = fin.read();
            while(ch!=-1) {
                System.out.println((char)ch);
                ch = fin.read();
            }
            fin.close();
        }
        catch(ArrayIndexOutOfBoundsException e1) {
            System.out.println("ʹ�ø�ʽ������ȷ��ʽ�ǣ�java mytype �ı��ļ���");
            System.exit(0);
        }
        catch(FileNotFoundException e2) {
            System.out.println("�ļ������ڣ�");
        }
        catch(IOException e3) {
            System.out.println("�������쳣��");
        }
    }
}