import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menutest extends JFrame {

    JMenuItem mi1, mi2, mi3;
    Container con;

    public void init() {
        con = getContentPane();
        JMenuBar mb = new JMenuBar();
        JMenu fillMenu = new JMenu("��ʾ");
        JMenu pullRightMenu = new JMenu("�ʺ�");
        JMenu colormenu = new JMenu("��ɫ");
        mi1 = new JMenuItem("��ɫ");
        mi2 = new JMenuItem("��ɫ");
        mi3 = new JMenuItem("��ɫ");
        colormenu.add(mi1);
        colormenu.add(mi2);
        colormenu.add(mi3);
        myhandle ls = new myhandle();
        mi1.addActionListener(ls);
        mi2.addActionListener(ls);
        mi3.addActionListener(ls);
        fillMenu.add("��ӭ");
        fillMenu.addSeparator();
        fillMenu.add("�˳�").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                System.exit(0);
            }
        });
        pullRightMenu.add(new JCheckBoxMenuItem("���Ϻã�"));
        pullRightMenu.add(new JCheckBoxMenuItem("����ã�"));
        pullRightMenu.add(new JCheckBoxMenuItem("�����ټ���"));
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