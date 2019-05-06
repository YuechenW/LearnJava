package throwable;

class OpenException extends Exception {}

class CloseException extends OpenException {}

class NewException extends Exception {}

public class ArrayIndex {
//	public static int open() {
//		int[] a = new int[10];
//		a[10] = 10;
//		return -1;
//	}
//	
//	public static void readFile() throws OpenException, CloseException {
//		if(open() == -1) {
//			throw new CloseException();
//		}
//	}
	public ArrayIndex() throws OpenException {}
	public void f() throws OpenException{}
	public static void main(String[] args) {
//		try {
//			readFile();
//		} catch (CloseException e) {
//	 		e.printStackTrace();
//	 		System.out.println("Close");
//		} catch (Exception e) {
//	 		e.printStackTrace();
//	 		System.out.println("Anything");
//		} 
	}
}
	class NewClass extends ArrayIndex {
		public NewClass() throws OpenException,NewException {}
		public void f() {}
		public static void main(String[] args) {
			try {
				ArrayIndex p = new NewClass();
				p.f();
			} catch (OpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NewException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
