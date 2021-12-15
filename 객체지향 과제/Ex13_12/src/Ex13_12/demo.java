package Ex13_12;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class demo {

 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename= "C:\\Users\\82108\\eclipse-workspace\\Ex13_12\\haberman.data";
		
		double sumformore=0, sumforless=0, averageformore=0, averageforless=0;
		int cnt1=0, cnt2=0;
		Scanner inputStream=null;
		try {
			inputStream= new Scanner(new File(filename));
			
			
			while(inputStream.hasNext()) {
				String s= inputStream.next();
				
				String[] arr= s.split(",");
				int live5= Integer.parseInt(arr[3]);
				int num_of = Integer.parseInt(arr[2]);
				if(live5==1) {
					System.out.println("more than 5 years: "+arr[2]);
					sumformore+=num_of;
					cnt1++;
				}
				else if(live5==2) {
					System.out.println("less than 5 years: "+arr[2]);
					sumforless+=num_of;
					cnt2++;
				}
				
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening name "+filename);
			System.exit(0);
		}
		inputStream.close();
		
		averageformore=sumformore/cnt1;
		averageforless=sumforless/cnt2;
		System.out.println();
		System.out.println("average of patients who survived 5years or longer: "+averageformore);
		System.out.println("average of patients who survived within 5years: "+averageforless);
		double dif= averageforless-averageformore;
		System.out.println("differences of averages: "+dif);
		System.out.println("A significant difference between the two averages can't be used to predict survival time");
		System.out.println("Because, In some cases, 46 axillary nodes detected even if person lives for more than five years, and in some cases, the number of axillary nodes detected even if you survive for less than five years is 0.");
		System.out.println("so you cannot make a significant estimate on average");
	}

}
