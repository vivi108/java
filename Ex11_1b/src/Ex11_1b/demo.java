package Ex11_1b;


public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String m= "pm";
		String m2= "60";
		
		String h="pm";
		String h2="5";
		
		try {
			if(!(InvalidHourException.checkHour(h)))
				throw new InvalidTimeException();
		}
		catch(InvalidTimeException e){
			System.out.println("ERROR h");
		}
		try {
			if(!(InvalidHourException.checkHour(h2)))
				throw new InvalidTimeException();
		}
		catch(InvalidTimeException e2){
			System.out.println("ERROR h2");
		}
		
		try {
			if(!(InvalidMinuteException.checkMinute(m2)))
				throw new InvalidMinuteException();
		}
		catch(InvalidMinuteException e3){
			System.out.println("ERROR m2");
		}
		
		try {
			if(!(InvalidMinuteException.checkMinute(m)))
				throw new InvalidMinuteException();
		}
		catch(InvalidMinuteException e4){
			System.out.println("ERROR m");
		}
	}

}
