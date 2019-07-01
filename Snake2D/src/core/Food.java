package core;

import java.awt.Graphics;

import constant.Constant;
import util.ImageUtil;

public class Food extends SnakeObject{

	public Food(){
		int random = (int)(1+Math.random()*(10));
		this.live=true;
		//�������ָ�����ˮ����ʽ
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
	 * ʳ�ﱻ�Եķ���
	 */
	public void eaten(MySnake mySnake){
		if(mySnake.getRectangle().intersects(this.getRectangle())&&live&&mySnake.live){
			this.live=false;//ʳ������
			mySnake.setLength(mySnake.getLength()+1);//���ȼ�һ
			mySnake.score+=10*mySnake.getLength();//�ӷ�
		}
	}
	/*
	 * ����ʳ��
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}
}
