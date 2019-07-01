package util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;


import javazoom.jl.player.Player;
/*
 * ���ֲ�����
 */
public class MusicUtil extends Thread {
	private boolean loop;
	private String fileName;
	
	public MusicUtil(String fileName,boolean loop) {
		this.loop = loop;
		this.fileName = fileName;
	}

	public MusicUtil(String fileName) {
		this.fileName = fileName;
	}
	/*
	 * �����Ƿ�ѭ����������
	 */
	@Override
	public void run() {
		try{
			if(loop){
				while(true){
					play();
				}
			}else{
				play();
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	/*
	 * �������ֵ����·����ȡ����(mp3)
	 */
	private void play(){
        Player p=null;
		try {   
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream("src/music/"+fileName+".mp3"));   
            p = new Player(buffer);
            p.play(); 
        } catch (Exception e) {   
             System.out.println(e);   
        }  
	}
}
