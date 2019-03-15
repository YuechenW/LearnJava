//HelloApplet1.java
import java.applet.*;
import java.awt.*;
public class HelloApplet1 extends Applet
{
	public void init()
	{
		Label lb1 = new Label("Name");
		TextField nm = new TextField(10);
		Button bt1 = new Button("Yes");
		add(lb1);
		add(nm);
		add(bt1);
	}
	public void paint(Graphics g)
	{
		g.drawString("Hello World!",20,60);
		g.drawLine(20,100,100,100);
		g.setColor(Color.red);
		g.fillOval(110,110,40,40);
	}
}