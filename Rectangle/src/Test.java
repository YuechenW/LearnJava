//将命令行窗口设置为80*25来运行
public class Test {
	public static void main(String[] args) {
		Screen myscreen = new Screen();
		Rectangle rt1 = new Rectangle(4,5,5,7);
		rt1.printme(myscreen);
		
		Rectangle rt2 = new Rectangle(10,2,7,5);
		rt2.printme(myscreen);
		
		Lingxing lx1 = new Lingxing(22,1,9);
		lx1.printme(myscreen);
		
		myscreen.display();
	}
}