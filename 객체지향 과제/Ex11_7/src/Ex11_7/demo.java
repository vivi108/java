package Ex11_7;
import java.util.Scanner;
public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard= new Scanner(System.in);
		Employee[] e= new Employee[] {new Employee("123456789",100, "James"),new Employee("1",230, "Apple"),new Employee("987654321",180, "Banana"),new Employee("notdigits",500, "Rob")};//Max=100
		for(Employee i: e) {
			try {
			
				if(!SSNLengthException.illegal(i.getSSN()))
					throw new SSNLengthException();
				if(!SSNCharacterException.illegal(i.getSSN()))
					throw new SSNCharacterException();
				
			
			}
			catch (SSNLengthException a) {
				System.out.println("\nLength is inappropriate, Please reenter "+i.getName()+"'s SSN: ");
				String s= keyboard.next();
				i.setSSN(s);
				
			}
			catch (SSNCharacterException b) {
				System.out.println("\nIt is not digit, Please reenter"+i.getName()+"'s SSN: ");
				String s= keyboard.next();
				i.setSSN(s);
				
			}
		}
		double sum=0;
		int cnt=0;
		for(Employee i: e) {
			sum+=i.getSalary();
			cnt++;
		}
		
		for(Employee i: e) {
			i.writeOutput();
			if(i.getSalary()>(sum/cnt))System.out.println("Salary is above the average\n");
			else if(i.getSalary()==(sum/cnt))System.out.println("Salary is same as the average\n");
			else System.out.println("Salary is below the average\n");
		}
		keyboard.close();	
	}

}
