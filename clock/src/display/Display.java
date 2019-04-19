package display;

public class Display {
	private int value = 0;//私有是针对类的，不是针对对象的，
	//同一类中不同对象的变量可以互相访问。且是看编译，不是看运行过程。
	private int limit = 0;
	
	public Display(int limit) {
		this.limit = limit;
	}
	
	public void increase() {
		value++;
		if(value == limit) {
			value = 0;
		}
	}
	
	public int getValue() {
		return value;
	}
	public static void main(String[] args) {
		Display d = new Display(24);
		for( ; ; ) {
			d.increase();
			System.out.println(d.getValue());
		}
	}
}
