package bankaccount;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class Bank {
	private String name;
	private String bincode;
	private String telnum;
	private Account[] bankAccount = new Account[2000];
	private int index=0;//账户下标管理
	
	public Bank() {}
	
	public Bank(String name) {
		this.name = name;
	}

	public Bank(String name, String bincode) {
		this.name = name;
		this.bincode = bincode;
	}
	
	public Bank(String name, String bincode, String telnum) {
		this.name = name;
		this.bincode = bincode;
		this.telnum = telnum;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBincode() {
		return bincode;
	}

	public void setBincode(String bincode) {
		this.bincode = bincode;
	}

	public String getTelnum() {
		return telnum;
	}

	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	
	public Account[] getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Account[] bankAccount) {
		this.bankAccount = bankAccount;
	}

	public void addAccount(String name, String iD) {
		if(iD.substring(0, 6).equals(bincode)) {
			if(!checkID(iD)) {
				this.bankAccount[index] = new Account(name, iD);//保障拥有基本信息
				index++;
			} else
				System.out.println("已有此账户，请勿重复添加！");
		}
	}
	
	public boolean checkID(String idc) {
		int j = 0;
		for(Account i:bankAccount) {
			if(i==null) 
				break;
			else if(i.equalsIDS(idc))
				j=1;
		}
		if(j==1)	
			return true;
		else
			return false;
	}
	
	public Account searchAccount(String idc) {//调用此方法时，先要用checkID判断ID是否存在
		int i = 0;
		for(i=0; i<bankAccount.length; i++) {
			if(bankAccount[i].equalsIDS(idc)) {
				break;
			}	
		}
		return bankAccount[i];
	}
	
	public void save(String ids, double money) {
		if(checkID(ids))
		{
			searchAccount(ids).saveMoney(money);
		}
	}
	
	public void load() {
		ArrayList<String> arrayList = new ArrayList<>();
		try {
			File file = new File("load.txt");
			InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader bf = new BufferedReader(inputReader);
			// 按行读取字符串
			String str;
			while ((str = bf.readLine()) != null) {
				arrayList.add(str);
			}
			bf.close();
			inputReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对ArrayList中存储的字符串进行处理 
		int length = arrayList.size();
		for (int i = 0; i < length; i++) {
			 String[] splited = arrayList.get(i).split("\\s+");
			 if(splited[2].equals("save")) {
				 this.save(splited[0], Double.parseDouble(splited[3]));
			 }
			 else if(splited[2].equals("consume")) {
				 this.consume(splited[0], Double.parseDouble(splited[3]));
			 }
			 else if(splited[2].equals("get")) {
				 this.get(splited[0], Double.parseDouble(splited[3]));
			 }
		}
	}
	
	public void store(String data) {
		try {
			PrintWriter out = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream("store.txt",true))));
			out.println(data);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("储存文件成功！");
	}
	
	public void get(String ids, double money) {
		if(checkID(ids))
		{
			searchAccount(ids).getMoney(money);
		}
	}
	
	public void consume(String ids, double money) {
		if(checkID(ids))
		{
			searchAccount(ids).consumered(money);
		}
	}
	
	public void deleteAccount(String ids) {
		Account[] tmp = new Account[2000];
		int idx = 0;
		if(checkID(ids))
		{
			for(int i=0;i<bankAccount.length;i++) {
				if(bankAccount[i]!=null) {
					if(bankAccount[i].getID().equals(ids)) 
						continue;
					tmp[idx++] = bankAccount[i]; 
				}
			}
		
			bankAccount = tmp;
		}
		else {
			System.out.println("未找到ID，删除失败！");
		}		
	}
	
	public double checkBalance(String ids) {
		while(true) {
			if(checkID(ids))
			{
				return searchAccount(ids).getBalance();
			}
			else {
				System.out.println("未找到账户，请重新输入");
				Scanner in = new Scanner(System.in);
				ids = in.nextLine();
				in.close();
			}
		}
	}
	
	public String showIndividualAccount(String ids) {
		while(true) {
			if(checkID(ids))
			{
				return searchAccount(ids).toString();
			}
			else {
				System.out.println("未找到账户，请重新输入");
				Scanner in = new Scanner(System.in);
				ids = in.nextLine();
				in.close();
			}
		}
	}
	
	public void showAccount() {
		for(Account i:bankAccount) {
			if(i==null) 
				break;
			else 
				i.display();
		}
	}
	
	public void showIndividualOverdraftNum(String ids) {
		if(checkID(ids))
		{
			System.out.println("账号为"+searchAccount(ids).getID()+"的透支次数为"+searchAccount(ids).getOverdraftNum());
		}
	}
	
	public void checkOverdraftAccount() {
		for(Account i:bankAccount) {
			if(i!=null) {
				if(i.getBalance()<0) {
					i.display();
				}
			}
		}
	}
	
	public double stateTotalBalance() {
		double total = 0;
		for(int i=0; i<bankAccount.length; i++) {
			if(bankAccount[i]==null)
				break;
			total += bankAccount[i].getBalance();
		}
		return total;
	}
	
	public String totaldata() {
		String s = "";
		for(Account i:bankAccount) {
			if(i==null) 
				break;
			else 
				s += i.storeToString(i.getWithdrawAndSave());
		}
		return s;
	}
	
	public static void BListGenerate(List<Bank> blist) {//事件初始化
		Bank nongye = new Bank("中国农业银行", "622821", "95599");//数据来源真实
		Bank gongshang = new Bank("中国工商银行", "620302", "95588");
		Bank zhongguo = new Bank("中国银行", "621294", "95566");
		Bank jianshe = new Bank("中国建设银行", "553242", "95533");
		Bank jiaotong = new Bank("中国交通银行", "458123", "95559");
		Bank pufa = new Bank("上海浦东发展银行","456418","95528");

		blist.add(nongye);
		blist.add(gongshang);
		blist.add(zhongguo);
		blist.add(jianshe);
		blist.add(jiaotong);
		blist.add(pufa);
	}

	@Override
	public String toString() {
		return name + ", Bincode为" + bincode + ", 服务电话为" + telnum + "。"+stateTotalBalance();
	}
}
