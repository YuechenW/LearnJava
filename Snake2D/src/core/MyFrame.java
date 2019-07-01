package core;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import client.SnakeClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import constant.Constant;
import util.MusicUtil;

public class MyFrame extends Frame{
	/**
	 * ���The serializable class XXXXXX does not declare a static final serialVersionUID field of type long
	 * �ľ���
	 */
	private static final long serialVersionUID = -9024481014597603696L;
	private MenuBar jmb;
	private Menu jm1;
	protected MenuItem jmi1,jmi2,jmi3; 
	protected MySnake mySnake = new MySnake(100, 100);//��
	
	MyThread mythread = new MyThread();
	static MusicUtil mybgm = new MusicUtil("bgm");
	
	/*
	 * ���ش���
	 */
	
	public void loadFrame(){
		jmb = new MenuBar();
		jm1 = new Menu("ѡ��");
		jmi1 = new MenuItem("��ʼ��Ϸ");
		jmi2 = new MenuItem("��ͣ��Ϸ");
		jmi3 = new MenuItem("�˳�");
		
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jmb.add(jm1);
		
		ActionListener MenuListener = new ActionListener() { 
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) { 
				 
				String cmd = e.getActionCommand(); 
				if(cmd.equals("��ʼ��Ϸ")) {
					//�����ػ��߳�
					mythread.start();
					mybgm = new MusicUtil("bgm");
					mybgm.start();//��ʼ���֣�~~~
					jmi1.setEnabled(false);
				}
				if(cmd.equals("��ͣ��Ϸ")) {
					//��ͣ�߳�
					mythread.pauseT();
					mybgm.stop();
					System.out.println(mythread.pause);
					jmi2.setActionCommand("������Ϸ");
					jmi2.setLabel("������Ϸ");
				}
				if(cmd.equals("������Ϸ")) {
					//��ͣ�߳�
					mythread.resumeT();
					mybgm = new MusicUtil("bgm");
					mybgm.start();
					System.out.println(mythread.pause);
					jmi2.setActionCommand("��ͣ��Ϸ");
					jmi2.setLabel("��ͣ��Ϸ");
				}
				if(cmd.equals("�˳�")) {
					System.exit(0);
				}
				if(cmd.equals("���¿�ʼ")) {
					//�����ػ��߳�
					dispose();
					mythread.stopT();
					mySnake = new MySnake(100, 100);
					mySnake.reset();//�������
					new SnakeClient().loadFrame();
				}
			}
		};
		
		this.setTitle("̰����2D");//���ô������
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//���ô����С
		this.setBackground(Color.BLACK);//���ñ���
		this.setLocationRelativeTo(null);//����
		//���ÿɹر�
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setMenuBar(jmb);
		//���ÿɼ�
		this.setVisible(true);
		
		jmi1.addActionListener(MenuListener);
		jmi2.addActionListener(MenuListener);
		jmi3.addActionListener(MenuListener);
	}
	/*
	 * ��ֹͼƬ��˸��ʹ��˫�ػ��棨��̫��⣬���ϲ�ģ�
	 */
	Image backImg = null;
	
	@SuppressWarnings("deprecation")
	public static void closeBgm() {
		mybgm.stop();
	}

	@Override
	public void update(Graphics g) {
		if (backImg == null) {
			backImg = createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		}
		Graphics backg = backImg.getGraphics();
		Color c = backg.getColor();
		backg.setColor(Color.BLACK);
		backg.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		backg.setColor(c);
		paint(backg);		
		g.drawImage(backImg, 0, 0, null);
	}
	/*
	 * ���ﴴ��һ�������ػ���߳��ڲ���
	 */
	class MyThread extends Thread{	
		/*
		 * ʵ���̵߳���ͣ�����/
		 */
		private boolean stop = false;
		private boolean pause = false;
		private final Object lock = new Object();
		
		public void pauseT() {
			this.pause = !pause;
		}
		
		public void resumeT(){
	        pause = false;
	        synchronized (lock){
	            lock.notify();
	        }
	    }
		public void stopT() {
			this.stop = !stop;
		}
		
		public void onPause() {
			synchronized (lock) {
				try { lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		@Override
		public void run() {
			
			while(!stop){
				while (pause){
					onPause();
				} 
				
				try {
					repaint();
					/*
					 * ʵ���ٶȵĿ���
					 */
					Thread.sleep(Constant.TIME);
				}
				catch (Exception e){
					e.printStackTrace();
					break;
				}
			}
		}
	}
}
