public class Rectangle {
	private int x,y;
	private int w,h;
	public Rectangle(int x, int y,int w,int h) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	public void printme(Screen sc) {
		sc.setY(y);
		for(int r=1; r<=h; r++) {
			sc.setX(x);
			sc.repeat('*', w);
			sc.println();
		}
	}
}
