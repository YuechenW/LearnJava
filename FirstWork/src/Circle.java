
class Circle extends Shape{
	int x,y;
	int h;
	public Circle(int x,int y,int h){
		this.x=x;
		this.y=y;
		this.h=h;
	}
	public void printme(Screen sc){
		sc.setY(y);
		for(int a=0;a<=2*h;a+=2){
			int b=(int)Math.round(h-Math.sqrt(h*h-(h-a)*(h-a)));
			sc.setX(x+b);
			sc.repeat('*',2*(h-b+1)+1);
			sc.println();
		}
	}
}
