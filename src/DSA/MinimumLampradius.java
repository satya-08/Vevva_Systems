package DSA;

public class MinimumLampradius {
	public static void main(String[] args) {
		int[] house= {1,3,5,6};
		int[] lamps= {2,4};
		int ans=0;
		for(int hou:house) {
			int neardis=Integer.MAX_VALUE;
			for(int lp:lamps) {
				neardis=Math.min(neardis, Math.abs(hou-lp));
			}
			ans=Math.max(ans,neardis);
		}
		System.out.println(ans);
	}

}
