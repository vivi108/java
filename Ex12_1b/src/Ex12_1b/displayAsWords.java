package Ex12_1b;

public class displayAsWords {
	public static void displayAsWords(int num) {
		int n=0;
		String word="";
		while(true) {
			if(num>=10) {
				word=word.concat(getWordFromDigit(num%10));
			}
			else {
				word=word.concat(getWordFromDigit(num%10));
				break;
			}

			num=(num/10);//맨 뒷자리 제외
		}
		
		String[] sArr = word.split(" ");
		
		for(int i=0; i<sArr.length; i++) {
			System.out.print(sArr[sArr.length-i-1]+" ");
		}




	}	
	public static String getWordFromDigit(int digit) {
		String[] word=new String[] {
				" zero", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine"
		};
		return word[digit];
	}
}
