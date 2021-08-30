package Ex10_1d;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubstitutionCipher s = new SubstitutionCipher(5);
		System.out.println(s.encode("zebra"));
		SubstitutionCipher s2 = new SubstitutionCipher(5);
		System.out.println(s2.encode("apple"));
		
		ShuffleCipher sc  = new ShuffleCipher(2);
		System.out.println(sc.encode("abcde"));
		ShuffleCipher sc2  = new ShuffleCipher(3);
		System.out.println(sc2.encode("abcd"));
	}

}
