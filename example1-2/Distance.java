//Distance.java
class Point
{	private int x, y;
	Point(int a,int b){x=a;y=b;}
	public int getx(){return x;}
	public int gety(){return y;}
}
public class Distance
{	public static void main(String[] args)
	{
		Point A = new Point(2,3);
		Point B = new Point(5,7);
		int x = B.getx() - A.getx(),y = B.gety() - A.gety();
		double dist = Math.sqrt(x*x+y*y);
		System.out.println("A-->B:"+dist);
	}
}