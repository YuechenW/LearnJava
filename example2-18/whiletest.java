class whiletest{
    public static void main(String[] args){
        int i,sum;
        i=1;sum=0;
        while(i<=100){
            sum=sum+i;
            i++;
        }
        System.out.println("sum="+sum);
        System.out.println("i="+i);
    }
}