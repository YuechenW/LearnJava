package bankaccount;
import java.util.*;

public class BCTest {

	//整个银联层面的add
	public static void addAccount(List<Bank> blist,String name, String iD) {
		for(int i=0; i<blist.size(); i++) {
			blist.get(i).addAccount(name, iD);
		}
	}
	
	//产生指定位数的随机数
	public static String getRandom(int length){
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return val;
	}
	
	//随机产生一个id
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
	
	//显示所有银行的方法
	public static String showAll(List<Bank> blist) {
		String s = ""; 
		for(Bank i:blist) {
			s+=i.totaldata();
		}
		return s;
	}
	
	//读取到所有银行blist的方法
	public static void loadAll(List<Bank> blist) {
		for(int i=0; i<blist.size(); i++) {
			blist.get(i).load();
		}
		System.out.println("文件读取成功！");
	}
	
	public static void main(String[] args) {
		List<Bank> blist = new ArrayList<Bank>();
		//初始化各大银行
		Bank.BListGenerate(blist);
		//System.out.println(RandomId(blist)+"  "+RandomId(blist).length());//测试随机id
        addAccount(blist,"张三", "6228216903524414107");//增加新账号
        addAccount(blist,"李四", "6203027491245236379");
        addAccount(blist,"王五", "6228217491245909099");
        addAccount(blist,"孙二娘", "6212947491245907629");
        addAccount(blist,"邵源", "5532423265056332372");
        addAccount(blist,"施豪杰", "6212943093633303844");
        addAccount(blist,"韦超", "4581230271063369117");
        addAccount(blist,"石波", "4564183336647968756");
        
        
        System.out.println();
        
        blist.get(0).save("6228216903524414107", 300);//存钱
        blist.get(0).save("6228217491245909099", 300);
        System.out.println();
        
        blist.get(0).get("6228216903524414107", 100);//取钱
        System.out.println();
        
        blist.get(0).consume("6228216903524414107", 400);//消费
        System.out.println();
        
        loadAll(blist);//读入文件
        for(int i=0;i<blist.size();i++) {
        	blist.get(i).showAccount();
        }
        System.out.println();
        
        blist.get(0).store(showAll(blist));//写入文件
        System.out.println();
        
        blist.get(0).deleteAccount("6228217491245909099");//撤销账户
        System.out.println();
        
        System.out.print("撤销后的农行账号信息为：");
        blist.get(0).showAccount();//显示所有账号信息
        System.out.println();
        
        System.out.println("账号6203027491245236379的余额为"+
        		blist.get(1).checkBalance("6203027491245236379"));//检查账号ID的余额
        System.out.println();
        
        System.out.print("6228216903524414107的账号信息为：");
        System.out.println(blist.get(0).showIndividualAccount("6228216903524414107"));//显示个人账号信息
        System.out.print("的透支次数为");
        blist.get(0).showIndividualOverdraftNum("6228216903524414107");
        System.out.println();
        
        System.out.print("有欠款的账号信息为：");
        blist.get(0).checkOverdraftAccount();//显示有欠款的账号信息
        System.out.println();
        
        System.out.println("中国农业银行的总金额为"+blist.get(0).stateTotalBalance());//显示银行总的金额数
	}
}
