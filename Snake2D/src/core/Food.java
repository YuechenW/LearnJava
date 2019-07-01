package core;

import java.awt.Graphics;

import constant.Constant;
import util.ImageUtil;

public class Food extends SnakeObject{

	public Food(){
		int random = (int)(1+Math.random()*(10));
		this.live=true;
		//产生各种各样的水果样式
		switch(random) {
			case 1:
				this.img=ImageUtil.images.get("pineapple");
				break;
			case 2:
				this.img=ImageUtil.images.get("apple");
				break;
			case 3:
				this.img=ImageUtil.images.get("banana");
				break;
			case 4:
				this.img=ImageUtil.images.get("cherry");
				break;
			case 5:
				this.img=ImageUtil.images.get("grape");
				break;
			case 6:
				this.img=ImageUtil.images.get("mango");
				break;
			case 7:
				this.img=ImageUtil.images.get("orange");
				break;
			case 8:
				this.img=ImageUtil.images.get("pear");
				break;
			case 9:
				this.img=ImageUtil.images.get("strawberry");
				break;
			case 10:
				this.img=ImageUtil.images.get("watermelon");
				break;	
		}
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
		this.x=(int) (Math.random()*(Constant.GAME_WIDTH-width-80));
		this.y=(int) (60+Math.random()*(Constant.GAME_HEIGHT-height-80));

	}
	
	public Food(Boolean b) {
		this.live=b;
	}
	
	/*
	 * 食物被吃的方法
	 */
	public void eaten(MySnake mySnake){
		if(mySnake.getRectangle().intersects(this.getRectangle())&&live&&mySnake.live){
			this.live=false;//食物死亡
			mySnake.setLength(mySnake.getLength()+1);//长度加一
			mySnake.score+=10*mySnake.getLength();//加分
		}
	}
	/*
	 * 绘制食物
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}
}
