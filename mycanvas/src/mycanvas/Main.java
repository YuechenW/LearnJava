package mycanvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class Mycanvas extends JPanel {
    private int flag;
    public int x, y;
    
    Mycanvas() {
        flag = 0;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int i) {
        flag = i;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(1, 1, 400, 1);
        g.drawLine(1, 1, 1, 220);
        g.drawLine(1, 110, 400, 110);
        switch(flag) {
            case 1:
                for(int i=0; i<360; i++) {
                    x = i;
                    y = 110 - (int)(100*Math.sin(x*3.1415926/180.0)) ;
                    g.drawLine(x, y, x, y);
                }
                break;
            case 2:
                for(int i=0; i<360; i++) {
                    x = i;
                    y = 110 - (int)(100*Math.cos(x*3.1415926/180.0)) ;
                    g.drawLine(x, y, x, y);
                }
                break;
            case 3: 
            	System.exit(0);
                break;
            default:
                break;
        }
    }
}

 public class Main extends JFrame {
    JPanel p1;
    JButton b1,b2,b3;
    Mycanvas mc;
    public Main() {
        setTitle("Painting show");
        mc = new Mycanvas();
        b1 = new JButton("SIN");
        b2 = new JButton("COS");
        b3 = new JButton("EXIT");
        p1 = new JPanel();
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        myListener m1 = new myListener();
        b1.addActionListener(m1);
        b2.addActionListener(m1);
        b3.addActionListener(m1);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(p1,BorderLayout.NORTH);
        getContentPane().add(mc,BorderLayout.CENTER);
    }

    private class myListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                mc.setFlag(1);
                mc.repaint();
            } else if(e.getSource() == b2) {
                mc.setFlag(2);
                mc.repaint();
            } else {
                mc.setFlag(3);
                mc.repaint();
            }
        }
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Main myapp = new Main();
        myapp.setSize(400,300);
        myapp.setVisible(true);
        myapp.addWindowFocusListener(new WindowDestroyer());
    }
}
