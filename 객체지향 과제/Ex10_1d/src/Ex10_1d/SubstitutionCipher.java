package Ex10_1d;

public class SubstitutionCipher implements MessageEncoder{
	public int shift=0;
	public SubstitutionCipher(int s) {
		shift=s;
	}
	
	
	public String encode(String plainText) {
		char c;
		String en="";
		for(int i=0; i<plainText.length(); i++) {
			c= plainText.charAt(i);
			if(Character.isLowerCase(c)) {
				c=(char)(((int)c-96+shift)%26+97);
				en= en+c;
			}
		}
		return en;
	}
}
