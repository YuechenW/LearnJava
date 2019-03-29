class Lingxing {
	int x,y;
	int h;
	public Lingxing(int x,int y,int h) {
		this.x=x;
		this.y=y;
		this.h=h;
	}
	public void printme(Screen sc) {
		sc.setY(y);
		for(int i=1; i<=(h+1)/2;i++) {
			sc.setX(x+(h+1)/2-i);
			sc.repeat('*', 2*i-1);
			sc.println();
		}
		for(int i=h/2; i>=1; i--) {
			sc.setX(x+(h+1)/2-i);
			sc.repeat('*', 2*i-1);
			sc.println();
		}
	}
}
