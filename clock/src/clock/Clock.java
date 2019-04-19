package clock;

//import display.Display;

public class Clock {
	private display.Display hour = new display.Display(24);
	private display.Display minute= new display.Display(60);
	
	public void start() {
		while (true) {
			minute.increase();
			if(minute.getValue() == 0) {
				hour.increase();
			}
			System.out.printf("%02d:%02d\n",hour.getValue(),minute.getValue());
		}
	}
	public static void main(String[] args) {
		Clock clock = new Clock();
		clock.start();
	}

}
