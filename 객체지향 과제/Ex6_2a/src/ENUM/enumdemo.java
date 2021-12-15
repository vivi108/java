package ENUM;

public class enumdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Suit cardsuit =Suit.SPADES;
		
		System.out.println(cardsuit.ordinal());
		System.out.println(cardsuit.equals(Suit.CLUBS));
		System.out.println(cardsuit.compareTo(Suit.DIAMONDS));
		
		System.out.println(Suit.valueOf("CLUBS"));
		System.out.println(Suit.valueOf(cardsuit.toString()));
		
		System.out.println(cardsuit.getColor());
		System.out.println(cardsuit.toString());
		
		
	}

}
