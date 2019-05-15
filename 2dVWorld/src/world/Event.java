package world;

import java.text.SimpleDateFormat;
import java.util.*;

public class Event extends Partical{
	
	private String discribe;
	private String time;
	
	public Event() {
		super();
	}
	
	public Event(String discribe, String time) {
		super(31.86, 117.27, 62.1);
		this.discribe = discribe;
		this.time = time;
	}

	public String getDiscr() {
		return discribe;
	}
	
	public void setDiscr(String disc) {
		this.discribe = disc;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public static long TDiffer(String t1,String t2) {;
	long diff = 0;	
	long nd = 1000 * 24 * 60 * 60;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = format.parse(t1); 
			Date dt2 = format.parse(t2);
			if(dt1.getTime() - dt2.getTime()>0) {
				diff = dt1.getTime() - dt2.getTime();
			} else {
				diff = dt2.getTime() - dt1.getTime();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return diff / nd;
	}
	
	@Override
	public String toString() {
		return super.toString()+", 事件描述为" + discribe + ", 时间为" + time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((discribe == null) ? 0 : discribe.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	public boolean equals(Event evt) {
		if((this.getDiscr()==evt.getDiscr())&&((this.getTime()==evt.getTime()))&&(super.equals(evt)))
			return true;
		else
			return false;
	}

	public static void ListSort(List<Event> list) {
		Collections.sort(list, new Comparator<Event>() {
			public int compare(Event o1, Event o2) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		            try {
		            	Date dt1 = format.parse(o1.getTime()); 
		            	Date dt2 = format.parse(o2.getTime());
		            	if (dt1.getTime() > dt2.getTime()) {
		            		return 1;
		                } else if (dt1.getTime() < dt2.getTime()) {
		                    return -1;
		                } else {
		                    return 0;
		                }
		            } catch (Exception e) {
		            	e.printStackTrace();
		            }
		                return 0;
		     }
		});
	}
}
	
