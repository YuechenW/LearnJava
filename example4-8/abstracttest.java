abstract class Employee {
    int basic = 2000;
    abstract void salary();
}
class Manager extends Employee {
    void salary() {
        System.out.println("薪资等于" + basic *5);
        System.out.println("*******************");
    }
}
class Worker extends Employee {
    void salary() {
        System.out.println("薪资等于" + basic*2);
        System.out.println("==================");
    }
}
class abstracttest {
    public static void main(String[] args) {
        Manager m = new Manager();
        Worker w = new Worker();
        m.salary();
        w.salary();
    }
}