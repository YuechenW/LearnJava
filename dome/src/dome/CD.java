package dome;

public class CD extends Item {

	private String title;
	private String artist;
	private int numofTracks;
    private int playingTime;
    private boolean gotIt = false;
    private String comment;
    
	public CD(String title, String artist, int numofTracks, int playingTime, String comment) {
		//super();
		this.title = title;
		this.artist = artist;
		this.numofTracks = numofTracks;
		this.playingTime = playingTime;
		this.comment = comment;
	}

	public static void main(String[] args) {
		CD cd = new CD("a","b",2,2,"...");
		cd.print();

	}

	public void print() {
		 System.out.println("CD:"+title+":"+artist);
		
	}

}
