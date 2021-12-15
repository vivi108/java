package Ex12_9;

public class getGrain {
	public static double getTotalGrains(int k, double grain) {
		if(k==1) return grain;
		return getTotalGrains(k-1,grain*2)+grain;
	}
}
