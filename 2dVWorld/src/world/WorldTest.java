package world;

import java.util.*;

public class WorldTest {
	
	public static void ListGenerate(List<Event> list) {//�¼���ʼ��
		Event event1 = new Event();
		Event event2 = new Event();
		Event event3 = new Event();

		event1.setLat(31.86);
		event1.setLng(117.27);
		event1.setQua(62.1);
		event1.setDiscr("\"�Ϸ�����ʱ��ͣ��һ������Ĺ������������Ϲ�����������������������ʱ֧�ܣ���֤����ͨ�С�\"");
		event1.setTime("2018-01-07");
		event1.setGra(event1.getQua()*9.8);
		
		event2.setLat(36.03);
		event2.setLng(103.73);
		event2.setQua(9999999);
		event2.setDiscr("\"���ݴ�ѧ��Ҫ�ٰ�110����У��\"");
		event2.setTime("2019-09-17");
		event2.setGra(event2.getQua()*9.8);
		
		event3.setLat(30.26);
		event3.setLng(120.19);
		event3.setDiscr("\"����������ѧ���������п�״Ԫ\"");
		event3.setQua(45.4);
		event3.setTime("2018-06-16");
		event3.setGra(event3.getQua()*9.8);
		
		list.add(event1);
		list.add(event2);
		list.add(event3);
	}
	
	public static void main(String[] args) {
		 List<Event> list = new ArrayList<Event>();
         ListGenerate(list);//��ʼ��
         
         //��ʱ������
         System.out.println("********����ǰ*******");
         	for(Event user: list){
         		System.out.println(user);
         		}
         Event.ListSort(list);
         System.out.println("******�����*****");
		 for(Event user: list){
			 System.out.println(user);
		 }
		 
		 try {
			 //����
			 System.out.println();
			 double dis1 = Partical.getDis(list.get(0).getLat(), list.get(0).getLng(), list.get(1).getLat(), list.get(1).getLng());
			 System.out.println("�Ϸʵ����ݵľ���Ϊ"+ dis1+"��");
			 System.out.println("�Ϸʵ����ݵľ���Ϊ"+
					 Partical.getDis(list.get(0).getLat(), list.get(1).getLng(), list.get(2).getLat(), list.get(2).getLng())
			 +"��"
					 );
			 
			 //��������
			 System.out.println("�Ϸʵ��񾯺ͺ��ݵ�����������������ǣ�"
					 +Partical.getGravitation(list.get(0).getQua(), list.get(1).getQua(), dis1)+"ţ��");//��������̫С�� ���岻��
			 //System.out.println(Partical.getGravitation(1, 6.67E-11, 6.67E-11));//���ڼ�⹫ʽ����ȷ�ԣ�Ҳ���ֳ���С������Ĳ�׼ȷ��
			 
			 //ʱ���
			 System.out.print("�Ϸʵ��¼��ͺ��ݵ��¼���");
			 System.out.println(Event.TDiffer(list.get(0).getTime(),list.get(1).getTime())+"��");
			 
			 //�ж����¼��Ƿ����
			 Event event4 = new Event("\"�Ϸ�����ʱ��ͣ��һ������Ĺ������������Ϲ�����������������������ʱ֧�ܣ���֤����ͨ�С�\"", "2018-01-07");
			 list.add(event4);
			 System.out.print("������¼��Ƿ����һ����ͬ��");
			 System.out.println(list.get(0).equals(event4));
		 } catch(ArrayIndexOutOfBoundsException e) { //����Խ���쳣(���ڴ����޸ģ��������в��ᷢ��)
			 e.printStackTrace();
		 }
	}
}
