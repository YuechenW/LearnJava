class ThrowsDemo {
    public static void main(String[] args) {
        Person zhangsan = new Person();
        try {
            zhangsan.setName("����");
            zhangsan.setAge(160);//�޸Ĵ˴��׳��쳣
            zhangsan.display();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
class Person {
    private int age;
    private String name;
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public void setAge(int a) throws Exception{
        if(a < 0)
            throw new Exception("�����쳣�����䲻��С���㣡");
        if(a > 150)
            throw new Exception("�����쳣���������150�ĸ���̫С��");
        age = a;
    }
    public void setName(String nn) {
        name = nn;
    }
    public void display() {
        System.out.println("�ҽ�"+name+"\n"+"�ҽ���"+age+"�꣡");
    }
}