package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

import listener.SnakeListener;
import util.Global;

public class Snake {
	private SnakeListener snakeListener;
	private LinkedList<Point> body=new LinkedList<Point>(); 
	public static final int UP=1;
	public static final int DOWN=-1;
	public static final int LEFT=3;
	public static final int RIGHT=-3;
	//private int direction;//�洢��ǰ����
	private int oldDirection,newDirection;
	private Point tail;
	private boolean life=true;
	public Snake(){
		init();
	}
	private void init(){
		int x=Global.WIDTH/2;
		int y=Global.HEIGHT/2;
		for(int i=0;i<3;i++){
			body.add(new Point(x-i,y));
		}
		this.oldDirection=this.newDirection=RIGHT;

	}
	public void setLife(boolean life){
		this.life=life;
	}
    public void move(){
        //ȥβ��
    	tail=body.removeLast();
    	//��ͷ
    	int x=body.getFirst().x;
    	int y=body.getFirst().y;
    	//����µ�ͷ��,��Ҫ��÷���
    	//�ڳ�ʼ�������ʱ��Ĭ������

    	if(oldDirection+newDirection!=0)     	
    		this.oldDirection=this.newDirection;
    	switch(oldDirection){
    	case UP:
    		y--;
    		if(y<0){
    			y=Global.HEIGHT-1;
    		}
    		break;
    	case DOWN:
    		y++;
    		if(y==Global.HEIGHT){
    			y=0;
    		}
    		break;
    	case LEFT:
    		x--;
    		if(x<0){
    			x=Global.WIDTH-1;
    		}
    		break;
    	case RIGHT:
    		x++;
    		if(x==Global.WIDTH){
    			x=0;
    		}
    		break;
    	}
    	body.addFirst(new Point(x,y));
    	System.out.println("�ƶ�");
    }
    /**
     * ������ͷ
     * @return
     */
    public Point getHead(){
    	return body.getFirst();
    }
    public void eatFood(Food food){
    	System.out.println("�߳�ʳ��");
    	body.addLast(tail);
    	
    }
    public void changeDirection(int direction){
    	System.out.println("�߸ı��˷���");
    	this.newDirection=direction;
    }
    public void drawMe(Graphics g){
    	System.out.println("�����ڻ��Լ�");
    	g.setColor(Color.green);
    	for(Point p:body){
    		g.fill3DRect(p.x*Global.CELL_SIZE,p.y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
    	}
    }
    public boolean isEatSelf(){
    	for(int i=1;i<body.size();i++){
    		if(body.get(i).equals(getHead())){
    			return true;
    		}
    	}
    	return false;
    }
    public void addSnakeListener(SnakeListener listener){
    	if(listener!=null){
    		this.snakeListener=listener;
    	}
    }
	public void start() {
		// TODO Auto-generated method stub
		new SnakeDriver().start();
	}
	private class SnakeDriver extends Thread{
		@Override
		public void run() {
            while(life){
            	move();
            	snakeListener.snakeMoved();
            	try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
		}
	}
	public boolean inSnake(int x, int y) {
        Point p=new Point(x,y);
		return body.contains(p);
	}
}
