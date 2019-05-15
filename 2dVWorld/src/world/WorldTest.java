package world;

import java.util.*;

public class WorldTest {
	
	public static void ListGenerate(List<Event> list) {//事件初始化
		Event event1 = new Event();
		Event event2 = new Event();
		Event event3 = new Event();

		event1.setLat(31.86);
		event1.setLng(117.27);
		event1.setQua(62.1);
		event1.setDiscr("\"合肥民警临时拦停了一辆最近的公交车，并爬上公交车将电缆托起，做起了临时支架，保证车辆通行。\"");
		event1.setTime("2018-01-07");
		event1.setGra(event1.getQua()*9.8);
		
		event2.setLat(36.03);
		event2.setLng(103.73);
		event2.setQua(9999999);
		event2.setDiscr("\"兰州大学将要举办110周年校庆\"");
		event2.setTime("2019-09-17");
		event2.setGra(event2.getQua()*9.8);
		
		event3.setLat(30.26);
		event3.setLng(120.19);
		event3.setDiscr("\"杭州文澜中学乐怡拿下中考状元\"");
		event3.setQua(45.4);
		event3.setTime("2018-06-16");
		event3.setGra(event3.getQua()*9.8);
		
		list.add(event1);
		list.add(event2);
		list.add(event3);
	}
	
	public static void main(String[] args) {
		 List<Event> list = new ArrayList<Event>();
         ListGenerate(list);//初始化
         
         //按时间排序
         System.out.println("********排序前*******");
         	for(Event user: list){
         		System.out.println(user);
         		}
         Event.ListSort(list);
         System.out.println("******排序后*****");
		 for(Event user: list){
			 System.out.println(user);
		 }
		 
		 try {
			 //距离
			 System.out.println();
			 double dis1 = Partical.getDis(list.get(0).getLat(), list.get(0).getLng(), list.get(1).getLat(), list.get(1).getLng());
			 System.out.println("合肥到杭州的距离为"+ dis1+"米");
			 System.out.println("合肥到兰州的距离为"+
					 Partical.getDis(list.get(0).getLat(), list.get(1).getLng(), list.get(2).getLat(), list.get(2).getLng())
			 +"米"
					 );
			 
			 //万有引力
			 System.out.println("合肥的民警和杭州的乐怡间的万有引力是："
					 +Partical.getGravitation(list.get(0).getQua(), list.get(1).getQua(), dis1)+"牛顿");//万有引力太小了 意义不大
			 //System.out.println(Partical.getGravitation(1, 6.67E-11, 6.67E-11));//用于检测公式的正确性，也体现出了小数计算的不准确性
			 
			 //时间差
			 System.out.print("合肥的事件和杭州的事件相差：");
			 System.out.println(Event.TDiffer(list.get(0).getTime(),list.get(1).getTime())+"天");
			 
			 //判断两事件是否相等
			 Event event4 = new Event("\"合肥民警临时拦停了一辆最近的公交车，并爬上公交车将电缆托起，做起了临时支架，保证车辆通行。\"", "2018-01-07");
			 list.add(event4);
			 System.out.print("后加是事件是否与第一个相同：");
			 System.out.println(list.get(0).equals(event4));
		 } catch(ArrayIndexOutOfBoundsException e) { //数组越界异常(便于代码修改，正常运行不会发生)
			 e.printStackTrace();
		 }
	}
}
