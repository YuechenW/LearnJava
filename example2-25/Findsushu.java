import java.util.Scanner;
class FindSushu{
    public static boolean isSushu(long m){
        for(int i=2;i<=Math.sqrt(m);i++){
            if(m%i==0)
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner key=new Scanner(System.in);
        System.out.print("Please input the lower limit of the prime number you want:");
        long m=key.nextLong();

        m=m+(long)(100000000*Math.random());
        while(!isSushu(++m));
        System.out.println("First prime number:"+m);

        m=m+(long)(100000000*Math.random());
        while(!isSushu(++m));
        System.out.println("Second prime number:"+m);
    }
}