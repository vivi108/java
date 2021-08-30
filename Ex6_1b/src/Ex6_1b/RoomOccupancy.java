package Ex6_1b;

public class RoomOccupancy {
	private int roomNumber;
	private int peopleInRoom;
	private static int totalNumber=0;
	
	public RoomOccupancy(int room, int people){
		roomNumber=room;
		peopleInRoom=people;
		totalNumber+=people;
	}
	public void addOneToRoom() {
		peopleInRoom++;
		totalNumber++;
	}
	public void removeOneFromRoom() {
		if(peopleInRoom>0&&totalNumber>0) {
			peopleInRoom--;
			totalNumber--;
		}
		else System.out.println("some value is Zero");
	}
	public int getNumber() {
		return this.roomNumber;
	}
	public static int getTotal() {
		return totalNumber;
	}
	public void print() {
		System.out.println("roomNum= "+ this.getNumber()+" peopleInRoom= "+this.peopleInRoom);
	}
}
