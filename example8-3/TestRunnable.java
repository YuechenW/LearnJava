import java.applet.Applet;
import java.awt.*;
public class TestRunnable extends Applet implements Runnable {
    Label prompt1 = new Label("��һ�����߳�");
    Label prompt2 = new Label("���������߳�");
    TextField threadFirst = new TextField(14);
    TextField threadSecond = new TextField(14);
    Thread thread1,thread2;//����Thread���̶߳���
    int count1=0, count2=0; //����������

    public void init() {
        add(prompt1);
        add(threadFirst);
        add(prompt2);
        add(threadSecond);
    }

    public void start() {
        //�����̶߳��󣬾��е�ǰ���run���������������ַ���ָ���̶߳��������
        thread1 = new Thread(this,"FirstThread");
        thread2 = new Thread(this,"secondThread");
        thread1.start();//�����̶߳��󣬽������״̬
        thread2.start();
    }

    public void run() {//ʵ��Runnable�ӿڵ�run�����������ڸ��߳�����ʱ�Զ�ִ��
        String currentRunning;
        while(true) { //����ѭ��
            try {//ʹ��ǰ��߳�����0��3s
                Thread.sleep((int)(Math.random()*3000));
            } catch (InterruptedException e) {}
        currentRunning = Thread.currentThread().getName();
        if(currentRunning.equals("FirstThread")) {
            count1++;
            threadFirst.setText("�߳�1��" + count1 + "�α�����");
        } else if(currentRunning.equals("SecondThread")) {
            count2++;
            threadSecond.setText("�߳�2��" + count2 + "�α�����");
            }
        }
    }
}