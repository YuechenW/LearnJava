import java.util.Scanner;
class lingxing{
    public static void main(String args[]){
        int row;
        Scanner keyin=new Scanner(System.in);
        System.out.print("Please enter the row:");
        row=keyin.nextInt();
        for(int i=1;i<=row/2+1;i++){
            repeat(' ',row/2+1-i);
            repeat('*',2*i-1);
            System.out.println();
        }
        for(int i=row/2;i>=1;i--){
            repeat(' ',row/2+1-i);
            repeat('*',2*i-1);
            System.out.println();
        }
    }
    public static void repeat(char ch,int m){
        for(int i=1;i<=m;i++)
        System.out.print(ch);
    }
}