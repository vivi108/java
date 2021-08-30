package Ex14_14;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		LinkedQueue q= new LinkedQueue();
		q.addToQueue("Banana");
		q.addToQueue("apple");
		q.addToQueue("Amazon");
		q.addToQueue("Paypal");
		q.addToQueue("Google");
		
		q.printlist();
		
		String s= q.removeFromQueue();
		System.out.println(s);
		
		q.printlist();
		s= q.removeFromQueue();
		System.out.println(s);
		
		q.printlist();
	}

}
