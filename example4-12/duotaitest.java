abstract class Employee {
    int basic = 2000;
    abstract void salary();
}
class Manager extends Employee {
    void salary() {
        System.out.println("н�ʵ���" + basic *5);
        System.out.println("*******************");
    }
}
class Worker extends Employee {
    void salary() {
        System.out.println("н�ʵ���" + basic*2);
        System.out.println("==================");
    }
}
class duotaitest {
    public static void main(String[] args) {
        Employee[] p = new Employee[5];
        p[0] = new Manager();
        p[1] = new Worker();
        p[2] = new Worker();
        p[3] = new Manager();
        p[4] = new Worker();
        for(int i = 0; i < p.length; i++)
            p[i].salary();
    }
}