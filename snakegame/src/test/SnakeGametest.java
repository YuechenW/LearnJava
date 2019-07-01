package test;

import javax.swing.JFrame;

import control.Controller;
import entity.Food;
import entity.Snake;
import entity.Wall;
import util.Global;
import view.GamePanel;

public class SnakeGametest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Snake snake=new Snake();
        Food food=new Food();
        Wall wall=new Wall();
        
        GamePanel gamePanel=new GamePanel(snake,food,wall);
        
        Controller c=new Controller(snake,food,wall,gamePanel);
        snake.addSnakeListener(c);
        gamePanel.addKeyListener(c);
        
        JFrame frame=new JFrame("贪吃蛇 version 1.0");
        frame.setSize(Global.CELL_SIZE*Global.WIDTH+20,Global.CELL_SIZE*Global.HEIGHT+40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        gamePanel.setFocusable(true);
        frame.add(gamePanel);

        c.startGame();
        frame.setVisible(true);
	}

}
