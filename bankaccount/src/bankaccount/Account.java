package bankaccount;

import java.util.ArrayList;
import java.util.List;

public class Account{
	private String name;
	private String ID;
	private double balance=0;
	private int overdraftNum=0;
	private double[] withdrawAndSave = new double[1000];
	private double overdraftLimit=2000;
	private int index=0;
	private List<Integer> cumi = new ArrayList<Integer>();//��������get��consume
	
	public Account(String name, String iD) {
		this.name = name;
		this.ID = iD;
	}
	
	public Account(String name, String iD, double balance) {
		this.name = name;
		this.ID = iD;
		this.balance = balance;
	}

	public Account(String name, String iD, double balance, int overdraftNum, double[] withdrawAndSave,
			double overdraftLimit, int index) {
		this.name = name;
		this.ID = iD;
		this.balance = balance;
		this.overdraftNum = overdraftNum;
		this.withdrawAndSave = withdrawAndSave;
		this.overdraftLimit = overdraftLimit;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		this.ID = iD;
	}

	public double[] getWithdrawAndSave() {
		return withdrawAndSave;
	}

	public void setWithdrawAndSave(double[] withdrawAndSave) {
		this.withdrawAndSave = withdrawAndSave;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setOverdraftNum(int overdraftNum) {
		this.overdraftNum = overdraftNum;
	}

	public int campareID(Account a) {
		return a.ID.compareTo(this.ID);
	}
	
	public boolean equalsID(Account a) {
		return a.ID.equals(this.ID);
	}
	
	public boolean equalsIDS(String a) {
		return a.equals(this.ID);
	}
	
	public void saveMoney(double money) {
		this.balance += money;
		this.withdrawAndSave[index] = money;
		index++;		
	}
	
	public void getMoney(double money) {
		if(this.balance-money>=0) {
			this.balance -= money;
			this.withdrawAndSave[index] = (-money);
			index++;
		}
		else {
			System.out.println("�������㣬�޷�ȡǮ��");
		}
	}
	
	public void consumered(double money) {
		if(this.balance-money>=0) {
			this.balance -= money;
			this.withdrawAndSave[index] = (-money);
			cumi.add(index);
			index++;
		}
		else if(this.overdraftLimit-(money-this.balance)>=0) {
			this.balance -= money;
			this.withdrawAndSave[index] = (-money);
			this.overdraftNum++;
			cumi.add(index);
			index++;
		}
		else {
			System.out.println("�������㣬��͸֧���㣬�޷����ѡ�");
		}
	}
	
	public double getBalance() {
		return balance;
	}	

	public int getOverdraftNum() {
		return overdraftNum;
	}
	
	public void display() {
		System.out.println(this);
	}
	
	public String WaStoString(double[] w) {
		String l = "";
		for(int i=0; i<w.length; i++) {
			if(w[i]>0) {
				l += " ����"+w[i]+"Ԫ";
			}
			else if(w[i]<0) {
				int m=0;
				for(int j=0;j<cumi.size();j++) {
					if(cumi.get(j)==i) {
						l += " ����"+(-w[i])+"Ԫ";
						m=1;
						break;
					}
				}
				if(m==0)
					l += " ȡ��"+(-w[i])+"Ԫ";
			}
		}
		return l;
	}

	@Override
	public String toString() {
		return "�˻�����Ϊ��" + name + ", IDΪ" + ID + ", ���Ϊ" + balance + ", ͸֧����Ϊ" + overdraftNum
				+ ", ��ˮ��ϸΪ" + WaStoString(withdrawAndSave) + ", ��͸֧���Ϊ" + overdraftLimit
				+ ", ����������Ϊ" + index;
	}
	
	public String storeToString(double[] w) {
		String l = "";
		String s = ""; 
		int i=0;
		for(int j=0;j<w.length; j++) {
			for(;i<w.length;i++) {
				if(w[i]>0) {
					l = "save "+w[i];
					i++;
					break;
				}
				else if(w[i]<0) {
					int m=0;
					for(int k=0;k<cumi.size();k++) {
						if(cumi.get(k)==i) {
							l = "consume "+(-w[i]);
							m=1;
							break;
						}
					}
					if(m==0) {
						l = "get "+(-w[i]);
					}
					i++;
					break;
				}
				else if(w[i]==0) {
					l="";
				}
			}
			if(!l.equals(""))
			s += ID+" "+name+" "+ l+"\n";
		}
		return s;
	}
}
