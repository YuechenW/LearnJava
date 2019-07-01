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
	 * ���The serializable class XXXXXX does not declare a static final serialVersionUID field of type long
	 * �ľ���
	 */
	private static final long serialVersionUID = 5498503296404646865L;

	Food food1 = new Food();//ʳ��
	Food food2 = new Food(false);
	Food food3 = new Food(false);
	Food food4 = new Food(false);
	Food food5 = new Food(false);
	Image background = ImageUtil.images.get("background");//����ͼƬ
	Image fail = ImageUtil.images.get("fail");//��Ϸ����������
	@Override
	public void loadFrame() {
		super.loadFrame();
		//��Ӽ��̼�������������̰����¼�
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				mySnake.keyPressed(e);//ί�и�mysnake
			}
			@Override
			public void keyReleased(KeyEvent e) {
				mySnake.keyReleased(e);//ʵ�ּ���
			}
		});
	}
	/*
	 * ���ƽ���
	 */

	@SuppressWarnings("deprecation")
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 30, null);//���Ʊ���
		if(mySnake.live){//����߻��ţ��ͻ���
			mySnake.draw(g);
			if(food1.live){//���ʳ����ţ��ͻ���
				food1.draw(g);
				food1.eaten(mySnake);//�ж��Ƿ񱻳�
			} else
			{//���򣬲�����ʳ��
				food1 = new Food();
			}
			
			if(food2.live){//���ʳ����ţ��ͻ���
				food2.draw(g);
				food2.eaten(mySnake);//�ж��Ƿ񱻳�
			} else if(mySnake.score>=200)
			{//���򣬲�����ʳ��
				food2 = new Food();
			}
			
			if(food3.live){//���ʳ����ţ��ͻ���
				food3.draw(g);
				food3.eaten(mySnake);//�ж��Ƿ񱻳�
			} else if(mySnake.score>=400)
			{//���򣬲�����ʳ��
				food3 = new Food();
			}
			
			if(food4.live){//���ʳ����ţ��ͻ���
				food4.draw(g);
				food4.eaten(mySnake);//�ж��Ƿ񱻳�
			} else if(mySnake.score>=600)
			{//���򣬲�����ʳ��
				food4 = new Food();
			}
			
			if(food5.live){//���ʳ����ţ��ͻ���
				food5.draw(g);
				food5.eaten(mySnake);//�ж��Ƿ񱻳�
			} else if(mySnake.score>=800)
			{//���򣬲�����ʳ��
				food5 = new Food();
			}
			
		}else{//��������������Ϸ��������
			closeBgm();
			jmi2.enable(false);
			jmi1.enable(true);
			jmi1.setLabel("���¿�ʼ");
			jmi1.setActionCommand("���¿�ʼ");
			g.drawImage(fail, (background.getWidth(null)-fail.getWidth(null))/2, (background.getHeight(null)-fail.getHeight(null))/2, null);
		}
		drawScore(g);//���Ʒ���
	}
	/*
	 * ���Ʒ���
	 */
	public void drawScore(Graphics g){
		g.setFont(new Font("Courier New", Font.BOLD, 40));
		g.setColor(Color.WHITE);
		g.drawString("SCORE:"+mySnake.score,820,730);
	}
	
	public static void main(String[] args) {
		new SnakeClient().loadFrame();//���ش���
	}
}
