package dome;

public class CD extends Item {

	private String artist;
	private int numofTracks;
	public CD(String title, String artist, int numofTracks, int playingTime, String comment) {
		super(title,playingTime,false,comment);
//		this.title = title;
		this.artist = artist;
		this.numofTracks = numofTracks;
//		this.playingTime = playingTime;
//		this.comment = comment;
	}

	public void print() {
		 System.out.println("CD:");
		 super.print();
		 System.out.print("artist");
	}
	
	@Override
	public String toString() {
		return "CD [artist=" + artist + ", numofTracks=" + numofTracks + ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		CD cc = (CD)obj;//向下造型
		return artist.equals(cc.artist);
	}

	public static void main(String[] args) {
		CD cd = new CD("a","b",2,2,"...");
		CD cd1 = new CD("a","b",2,2,"...");
		cd.print();
		System.out.println(cd);
		System.out.println(cd.equals(cd1));
	}
}