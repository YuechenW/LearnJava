import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EventTest extends JFrame implements ActionListener {
    JPanel p1;
    JLabel l1;
    JButton b1;
    JButton b2;
    public JTextField t1;

    public EventTest() {
        setTitle("文本框Action事件测试");
        b1 = new JButton("确定");
        b2 = new JButton("清除");
        p1 = new JPanel();
        l1 = new JLabel("姓名");
        t1 = new JTextField(30);
        p1.add(b1);
        p1.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        t1.addActionListener(this);
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(l1);
        getContentPane().add(t1);
        getContentPane().add(p1);
    }
    
    public void actionPerformed(ActionEvent e) {
    	String s1 = t1.getText();
        if(e.getSource() == b1) {
            t1.setText("您好"+s1+"，欢迎您使用java编程!");
            t1.repaint();
        } else if(e.getSource() == b2) {
        	t1.setText("");
        	t1.repaint();
        } 
   }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        EventTest myt = new EventTest();
        myt.setSize(400,100);
        myt.setVisible(true);
        myt.addWindowFocusListener(new WindowDestroyer());
    }
}

    

