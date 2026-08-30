package DSA;

import java.util.Scanner;

public class AdjacencyMatrixMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of Vertices");
        int n=sc.nextInt();
        AdjacencyMatrix g=new AdjacencyMatrix(n);
        while(true){
            System.out.println("Enter U,V to create edge");
            int x=sc.nextInt();
            int y=sc.nextInt();
            g.addEdge(x,y);
            System.out.println("Enter -1 to quit");
            int ch=sc.nextInt();
            if(ch==-1)
                break;
        }
        boolean[] visited=new boolean[n];
        g.dfsrecursion(1,visited);
	}

}
