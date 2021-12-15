package Ex10_1d;

public class ShuffleCipher implements MessageEncoder{
	public int num=0;
	public ShuffleCipher(int n) {
		num=n;
	}
	
	public String encode(String plainText) {
		String front="";
		String back="";
		int mid=0, len= plainText.length();
		mid= len/2;
		if(len%2!=0) {
			for(int i=0; i<num; i++) {
				front=plainText.substring(0, mid+2);
				back=plainText.substring(mid+1);
				plainText="";
				int j=0;
				for(j=0; j<back.length(); j++) {
					plainText+=front.charAt(j);
					plainText+=back.charAt(j);
				}
				plainText+=front.charAt(j);
			}
		}
		else {
			for(int i=0; i<num; i++) {
				front=plainText.substring(0, mid+1);
				back=plainText.substring(mid);
				plainText="";
				int j=0;
				for(j=0; j<back.length(); j++) {
					plainText+=front.charAt(j);
					plainText+=back.charAt(j);
				}
			}
		}
		return plainText;
	}
	 
}
