interface A {
    double g = 3.14;
    void show();
}
class B implements A {
    public void show() {
        //g = 23.4;
        System.out.println("g = "+g);
    }
}
class interfaceTest {
    public static void main(String[] args) {
        A a = new B();
        a.show();
    }
}