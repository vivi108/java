package ARR;

public class arrdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= new int[] {5,4,8,9,3,1,1,7,10,2,3};
		ArraySorter.selectionSort(a);
		System.out.println("selection sort= ");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		
		System.out.println("");
		
		int[] a2= new int[] {5,4,8,9,3,1,1,7,10,2,3};
		ArraySorter.bubbleSort(a2);
		System.out.println("Bubble sort= ");
		for(int i=0; i<a2.length; i++) {
			System.out.print(a2[i]+" ");
		}
	}

}
