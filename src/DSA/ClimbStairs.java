package DSA;

import java.util.Scanner;

public class ClimbStairs {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter size of the list :");
	int n=scanner.nextInt();
	System.out.println(climbStairs(n));
}
    public static int climbStairs(int n) {
        int[] dp=new int[n+1];
        if(n<=3) return n;
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
}
