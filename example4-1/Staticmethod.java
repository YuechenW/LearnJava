class Staticmethod {
    public static int add(int x, int y) {
        return x+y;
    }
    public static void main(String[] args) {
        int result = Staticmethod.add(10,20);
        System.out.println("result = " + result);
    }
}