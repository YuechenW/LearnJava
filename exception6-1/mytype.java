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
            System.out.println("使用格式错误！正确格式是：java mytype 文本文件名");
            System.exit(0);
        }
        catch(FileNotFoundException e2) {
            System.out.println("文件不存在！");
        }
        catch(IOException e3) {
            System.out.println("输入流异常！");
        }
    }
}