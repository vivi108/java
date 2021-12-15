package Ex11_1a;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a= "12:11 pm";
		String b= "false";
		try {
			if(!(InvalidTimeException.checkTime(a)))
				throw new InvalidTimeException();
		}
		catch(InvalidTimeException e){
			System.out.println("ERROR");
		}
	
		try {
			if(!(InvalidTimeException.checkTime(b)))
				throw new InvalidTimeException();
		}
		catch(InvalidTimeException e){
			System.out.println("ERROR2");
		}
	}
}

