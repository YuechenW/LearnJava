import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menutest extends JFrame {

    JMenuItem mi1, mi2, mi3;
    Container con;

    public void init() {
        con = getContentPane();
        JMenuBar mb = new JMenuBar();
        JMenu fillMenu = new JMenu("显示");
        JMenu pullRightMenu = new JMenu("问好");
        JMenu colormenu = new JMenu("颜色");
        mi1 = new JMenuItem("红色");
        mi2 = new JMenuItem("蓝色");
        mi3 = new JMenuItem("绿色");
        colormenu.add(mi1);
        colormenu.add(mi2);
        colormenu.add(mi3);
        myhandle ls = new myhandle();
        mi1.addActionListener(ls);
        mi2.addActionListener(ls);
        mi3.addActionListener(ls);
        fillMenu.add("欢迎");
        fillMenu.addSeparator();
        fillMenu.add("退出").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                System.exit(0);
            }
        });
        pullRightMenu.add(new JCheckBoxMenuItem("早上好！"));
        pullRightMenu.add(new JCheckBoxMenuItem("下午好！"));
        pullRightMenu.add(new JCheckBoxMenuItem("晚安！再见！"));
        mb.add(fillMenu);
        mb.add(colormenu);
        setJMenuBar(mb); 
    }

    private class myhandle implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == mi1)
                con.setBackground(Color.red);
            if(e.getSource() == mi1)
                con.setBackground(Color.blue);
            if(e.getSource() == mi1)
                con.setBackground(Color.green);
        }
    }
}