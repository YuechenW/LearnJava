
public class Screen{
	private int W,H;
	private int x,y;
	private char[][] data;
	public Screen(int H,int W){
		this.H=H;
		this.W=W;
		data = new char[H][W];
		x=0;
		y=0;
	}
	public void cls(){
		for(int i=0; i<H ;i++){
			for(int j=0; j<W; j++){
				data[i][j]=' ';
			}
		}
	}
	public void print(char ch){
		data[y][x]=ch;
		x++;
		if(x==W){
			y++;
			x=0;
		}
	}
	public void display(){
		for(int i=0; i<H; i++){
			for(int j=0; j<W; j++){
				System.out.print(data[i][j]);
			}
			System.out.println();
		}
	}
	public void repeat(char ch,int m){
		for(int i=1; i<=m; i++)
			print(ch);
	}
	public void setX(int x){
		if(x>=0&&x<=W) 
			this.x=x;
		else this.x=0;
	}
	public void setY(int y){
		if(y>=0&&y<=H) 
			this.y=y;
		else this.y=0;
	}
	public void println(){
		y++;
		x=0;
	}
	public void scroll() {
		for(int i=0; i<this.H-1;i++) {
			data[i] = data[i+1];
		}
	}
}
