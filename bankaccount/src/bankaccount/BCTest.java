package bankaccount;
import java.util.*;

public class BCTest {

	//�������������add
	public static void addAccount(List<Bank> blist,String name, String iD) {
		for(int i=0; i<blist.size(); i++) {
			blist.get(i).addAccount(name, iD);
		}
	}
	
	//����ָ��λ���������
	public static String getRandom(int length){
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return val;
	}
	
	//�������һ��id
	public static String RandomId(List<Bank> blist) {
		String id = "";
		Random random = new Random();
		int i = random.nextInt(blist.size());
		switch (i) {
		case 0:
			id += blist.get(0).getBincode();
			break;
		case 1:
			id += blist.get(1).getBincode();
			break;
		case 2:
			id += blist.get(2).getBincode();
			break;
		case 3:
			id += blist.get(3).getBincode();
			break;
		case 4:
			id += blist.get(4).getBincode();
			break;
		case 5:
			id += blist.get(5).getBincode();
			break;
		}
		return id+getRandom(13);
	}
	
	//��ʾ�������еķ���
	public static String showAll(List<Bank> blist) {
		String s = ""; 
		for(Bank i:blist) {
			s+=i.totaldata();
		}
		return s;
	}
	
	//��ȡ����������blist�ķ���
	public static void loadAll(List<Bank> blist) {
		for(int i=0; i<blist.size(); i++) {
			blist.get(i).load();
		}
		System.out.println("�ļ���ȡ�ɹ���");
	}
	
	public static void main(String[] args) {
		List<Bank> blist = new ArrayList<Bank>();
		//��ʼ����������
		Bank.BListGenerate(blist);
		//System.out.println(RandomId(blist)+"  "+RandomId(blist).length());//�������id
        addAccount(blist,"����", "6228216903524414107");//�������˺�
        addAccount(blist,"����", "6203027491245236379");
        addAccount(blist,"����", "6228217491245909099");
        addAccount(blist,"�����", "6212947491245907629");
        addAccount(blist,"��Դ", "5532423265056332372");
        addAccount(blist,"ʩ����", "6212943093633303844");
        addAccount(blist,"Τ��", "4581230271063369117");
        addAccount(blist,"ʯ��", "4564183336647968756");
        
        
        System.out.println();
        
        blist.get(0).save("6228216903524414107", 300);//��Ǯ
        blist.get(0).save("6228217491245909099", 300);
        System.out.println();
        
        blist.get(0).get("6228216903524414107", 100);//ȡǮ
        System.out.println();
        
        blist.get(0).consume("6228216903524414107", 400);//����
        System.out.println();
        
        loadAll(blist);//�����ļ�
        for(int i=0;i<blist.size();i++) {
        	blist.get(i).showAccount();
        }
        System.out.println();
        
        blist.get(0).store(showAll(blist));//д���ļ�
        System.out.println();
        
        blist.get(0).deleteAccount("6228217491245909099");//�����˻�
        System.out.println();
        
        System.out.print("�������ũ���˺���ϢΪ��");
        blist.get(0).showAccount();//��ʾ�����˺���Ϣ
        System.out.println();
        
        System.out.println("�˺�6203027491245236379�����Ϊ"+
        		blist.get(1).checkBalance("6203027491245236379"));//����˺�ID�����
        System.out.println();
        
        System.out.print("6228216903524414107���˺���ϢΪ��");
        System.out.println(blist.get(0).showIndividualAccount("6228216903524414107"));//��ʾ�����˺���Ϣ
        System.out.print("��͸֧����Ϊ");
        blist.get(0).showIndividualOverdraftNum("6228216903524414107");
        System.out.println();
        
        System.out.print("��Ƿ����˺���ϢΪ��");
        blist.get(0).checkOverdraftAccount();//��ʾ��Ƿ����˺���Ϣ
        System.out.println();
        
        System.out.println("�й�ũҵ���е��ܽ��Ϊ"+blist.get(0).stateTotalBalance());//��ʾ�����ܵĽ����
	}
}
