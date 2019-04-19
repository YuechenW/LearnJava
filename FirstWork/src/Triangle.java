
class Triangle extends Shape{
	int x,y;
	int h;
	public Triangle(int x,int y,int h){
		this.x=x;
		this.y=y;
		this.h=h;
	}
	public void printme(Screen sc){
		sc.setY(y);
		for(int i=1; i<=h+1;i++){
			sc.setX(x+h+1-i);
			sc.repeat('*',2*i-1);
			sc.println();
		}
	}
}
