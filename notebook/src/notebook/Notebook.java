package notebook;

import java.util.ArrayList;
import java.util.HashSet;

public class Notebook {
	private ArrayList<String> notes = new ArrayList<String>();//˳�������༴���������࣬Ҳ������foreach��������
	
	public void add(String s) {
		notes.add(s);
	}
	
	public void add(String s,int location) {
		notes.add(location,s);
	}
	
	public int getSize() {
		return notes.size();
	}
	
	public String getNote(int index) {
		return notes.get(index);
	}
	
	public void removeNote(int index) {
		notes.remove(index);
	}
	
	public String[] list() {
		String[] a = new String[notes.size()];
//		for(int i=0; i<notes.size(); i++) {
//			a[i] = notes.get(i)
//		}
		/*����foreachѭ�����ܵõ����������ֵ���޸ĵģ���Ϊ��Ȼ���Ƴ����ˣ������ܹ�ָ��Ŀ��ֵ*/
		notes.toArray(a);
		return a;
	}
	
	public static void main(String[] args) {
		Notebook nb = new Notebook();
		nb.add("first");
		nb.add("Second");
		nb.add("third",1);
		System.out.println(nb.getSize());
		System.out.println(nb.getNote(0));
		System.out.println(nb.getNote(1));
		nb.removeNote(1);
		String[] a = nb.list();
		for(String s : a) {
			System.out.println(s);
		}
		System.out.println("****************");
		HashSet<String> s = new HashSet<String>();//��������,�����򣬲��ظ�
		s.add("first");
		s.add("second");
		s.add("first");
//		for(String k : s) {
//			System.out.println(k);
//		}
		System.out.println(s);//��toString����������������
	}
}

