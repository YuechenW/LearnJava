class Staticblock {
    static int[] values = new int[10];
    static {
        System.out.println("运行初始化块");
        for(int i=0; i<values.length; i++) {
            values[i] = (int)(100*Math.random());
        }
    }
    void listValues() {
        System.out.println(this);
        for(int i=0; i<values.length; i++) {
            System.out.print("  "+values);
        }
    }
    public static void main(String[] args) {
        Staticblock test = new Staticblock();
        System.out.println("\n第一个对象：");
        test.listValues();
        test = new Staticblock();
        System.out.println("\n第二个对象：");
        test.listValues();
    }
}