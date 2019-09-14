
class Printer{
	void printDocuments(int numOfCopies,String docName) {
		for(int i=1;i<=numOfCopies;i++) {
			System.out.println(">> Printing " + docName + " " + i) ;
		}
	}
}

class MyThread extends Thread{
	
	Printer pRef;
	MyThread(Printer p) {
		pRef = p ;
	}
	
	@Override
	public void run() {
		pRef.printDocuments(10, "JohnsProfile.pdf");
	}
}

class YourThread extends Thread{
	
	Printer pRef;
	YourThread(Printer p) {
		pRef = p ;
	}
	
	@Override
	public void run() {
		pRef.printDocuments(10, "FionnasProfile.pdf");
	}
}

class OtherThread extends Thread{
	
	Printer pRef;
	OtherThread(Printer p) {
		pRef = p ;
	}
	
	@Override
	public void run() {
		pRef.printDocuments(10, "Robert.pdf");
	}
}

public class SyncApp {

	public static void main(String[] args) {
		System.out.println("==Application started ===") ;
		
		Printer printer = new Printer() ;
		MyThread mRef = new MyThread(printer);
		mRef.start();
	
		Printer printer2 = new Printer() ;
		YourThread yRef = new YourThread(printer2) ;
		yRef.start();
		

		Printer printer3 = new Printer() ;
		OtherThread oRef = new OtherThread(printer3) ;
		oRef.start();
		
		System.out.println("==Application finished ===") ;
	}
}
