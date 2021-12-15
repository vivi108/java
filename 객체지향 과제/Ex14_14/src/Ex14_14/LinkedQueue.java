package Ex14_14;
import java.util.LinkedList;
import java.util.Iterator;
public class LinkedQueue extends LinkedList{
	
	private LinkedList<String> q=new LinkedList<String>();
	private int count=0;
	private Iterator<String> front=q.listIterator(0);
	
	public void addToQueue(String item) {
		q.add(item);
		count++;
	}
	public String removeFromQueue(){
		if(this.isEmpty()) return null;
		
		String s= q.getFirst();
		q.remove(0);
		count--;
		return s;
		
	}
	public boolean isEmpty() {
		if(count==0) return true;
		return false;
	}
	public void printlist() {
		front=q.listIterator(0);
		while(front.hasNext()) {
			System.out.print(front.next() + " ");
		}
		System.out.print(": count ="+ this.count+"\n\n");
	}
}
