class staticvartest {
    int a;
    static int b;
    staticvartest() {
        a=20;
        b=30;
    }
    public static void main(String[] args) {
        staticvartest ss = new staticvartest();
        staticvartest sb = new staticvartest();
        ss.a=60;ss.b=80;
        sb.a=100;sb.b=10000;
        System.out.println("ss.a="+ss.a);
        System.out.println("ss.b="+b); 
        System.out.println("sb.a="+sb.a);
        System.out.println("sb.b="+b); 
    }
}