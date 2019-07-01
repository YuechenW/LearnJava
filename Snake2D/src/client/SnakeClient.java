package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import core.Food;
import core.MyFrame;
import util.ImageUtil;

public class SnakeClient extends MyFrame{
	/**
	 * 解决The serializable class XXXXXX does not declare a static final serialVersionUID field of type long
	 * 的警告
	 */
	private static final long serialVersionUID = 5498503296404646865L;

	Food food1 = new Food();//食物
	Food food2 = new Food(false);
	Food food3 = new Food(false);
	Food food4 = new Food(false);
	Food food5 = new Food(false);
	Image background = ImageUtil.images.get("background");//背景图片
	Image fail = ImageUtil.images.get("fail");//游戏结束的文字
	@Override
	public void loadFrame() {
		super.loadFrame();
		//添加键盘监听器，处理键盘按下事件
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				mySnake.keyPressed(e);//委托给mysnake
			}
			@Override
			public void keyReleased(KeyEvent e) {
				mySnake.keyReleased(e);//实现加速
			}
		});
	}
	/*
	 * 绘制界面
	 */

	@SuppressWarnings("deprecation")
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 30, null);//绘制背景
		if(mySnake.live){//如果蛇活着，就绘制
			mySnake.draw(g);
			if(food1.live){//如果食物活着，就绘制
				food1.draw(g);
				food1.eaten(mySnake);//判断是否被吃
			} else
			{//否则，产生新食物
				food1 = new Food();
			}
			
			if(food2.live){//如果食物活着，就绘制
				food2.draw(g);
				food2.eaten(mySnake);//判断是否被吃
			} else if(mySnake.score>=200)
			{//否则，产生新食物
				food2 = new Food();
			}
			
			if(food3.live){//如果食物活着，就绘制
				food3.draw(g);
				food3.eaten(mySnake);//判断是否被吃
			} else if(mySnake.score>=400)
			{//否则，产生新食物
				food3 = new Food();
			}
			
			if(food4.live){//如果食物活着，就绘制
				food4.draw(g);
				food4.eaten(mySnake);//判断是否被吃
			} else if(mySnake.score>=600)
			{//否则，产生新食物
				food4 = new Food();
			}
			
			if(food5.live){//如果食物活着，就绘制
				food5.draw(g);
				food5.eaten(mySnake);//判断是否被吃
			} else if(mySnake.score>=800)
			{//否则，产生新食物
				food5 = new Food();
			}
			
		}else{//蛇死亡，弹出游戏结束字样
			closeBgm();
			jmi2.enable(false);
			jmi1.enable(true);
			jmi1.setLabel("重新开始");
			jmi1.setActionCommand("重新开始");
			g.drawImage(fail, (background.getWidth(null)-fail.getWidth(null))/2, (background.getHeight(null)-fail.getHeight(null))/2, null);
		}
		drawScore(g);//绘制分数
	}
	/*
	 * 绘制分数
	 */
	public void drawScore(Graphics g){
		g.setFont(new Font("Courier New", Font.BOLD, 40));
		g.setColor(Color.WHITE);
		g.drawString("SCORE:"+mySnake.score,820,730);
	}
	
	public static void main(String[] args) {
		new SnakeClient().loadFrame();//加载窗体
	}
}
