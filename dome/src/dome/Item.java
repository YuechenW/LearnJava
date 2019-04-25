package dome;

public class Item {
	private String title;
	int playingTime;
    private boolean gotIt = false;
    private String comment;
    
	public void print() {
		System.out.println(title);
	}
	
	public Item() {
		
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Item(String title, int playingTime, boolean gotIt, String comment) {
		super();
		this.title = title;
		this.playingTime = playingTime;
		this.gotIt = gotIt;
		this.comment = comment;
	}
}