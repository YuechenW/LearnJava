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
	 * 解决The serializable class XXXXXX does not declare a static final serialVersionUID field of type long
	 * 的警告
	 */
	private static final long serialVersionUID = -9024481014597603696L;
	private MenuBar jmb;
	private Menu jm1;
	protected MenuItem jmi1,jmi2,jmi3; 
	protected MySnake mySnake = new MySnake(100, 100);//蛇
	
	MyThread mythread = new MyThread();
	static MusicUtil mybgm = new MusicUtil("bgm");
	
	/*
	 * 加载窗体
	 */
	
	public void loadFrame(){
		jmb = new MenuBar();
		jm1 = new Menu("选项");
		jmi1 = new MenuItem("开始游戏");
		jmi2 = new MenuItem("暂停游戏");
		jmi3 = new MenuItem("退出");
		
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jmb.add(jm1);
		
		ActionListener MenuListener = new ActionListener() { 
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) { 
				 
				String cmd = e.getActionCommand(); 
				if(cmd.equals("开始游戏")) {
					//运行重绘线程
					mythread.start();
					mybgm = new MusicUtil("bgm");
					mybgm.start();//开始音乐！~~~
					jmi1.setEnabled(false);
				}
				if(cmd.equals("暂停游戏")) {
					//暂停线程
					mythread.pauseT();
					mybgm.stop();
					System.out.println(mythread.pause);
					jmi2.setActionCommand("继续游戏");
					jmi2.setLabel("继续游戏");
				}
				if(cmd.equals("继续游戏")) {
					//暂停线程
					mythread.resumeT();
					mybgm = new MusicUtil("bgm");
					mybgm.start();
					System.out.println(mythread.pause);
					jmi2.setActionCommand("暂停游戏");
					jmi2.setLabel("暂停游戏");
				}
				if(cmd.equals("退出")) {
					System.exit(0);
				}
				if(cmd.equals("重新开始")) {
					//运行重绘线程
					dispose();
					mythread.stopT();
					mySnake = new MySnake(100, 100);
					mySnake.reset();//清除蛇身
					new SnakeClient().loadFrame();
				}
			}
		};
		
		this.setTitle("贪吃蛇2D");//设置窗体标题
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);//设置窗体大小
		this.setBackground(Color.BLACK);//设置背景
		this.setLocationRelativeTo(null);//居中
		//设置可关闭
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setMenuBar(jmb);
		//设置可见
		this.setVisible(true);
		
		jmi1.addActionListener(MenuListener);
		jmi2.addActionListener(MenuListener);
		jmi3.addActionListener(MenuListener);
	}
	/*
	 * 防止图片闪烁，使用双重缓存（不太理解，网上查的）
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
	 * 这里创建一个不断重绘的线程内部类
	 */
	class MyThread extends Thread{	
		/*
		 * 实现线程的暂停与继续/
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
					 * 实现速度的控制
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
