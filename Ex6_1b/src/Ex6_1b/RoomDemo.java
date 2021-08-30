package Ex6_1b;

public class RoomDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoomOccupancy demo1= new RoomOccupancy(13,5);
		RoomOccupancy demo2= new RoomOccupancy(205,2);
		demo1.print();
		demo2.print();
		System.out.println(" totalNum= "+RoomOccupancy.getTotal());
		
		demo1.addOneToRoom();
		demo2.removeOneFromRoom();
		demo2.removeOneFromRoom();
		
		demo1.print();
		demo2.print();
		System.out.println(" totalNum= "+RoomOccupancy.getTotal());
	}

}
