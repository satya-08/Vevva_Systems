package LoadBalancing;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageServer3 {
	public static void main(String[] args) {
		ArrayList<ArrayList<int[]>> servers=new ArrayList<>();
		System.out.println("Enter Total number of servers initially");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			ArrayList<int []> list=new ArrayList<>();
			System.out.println("Enter size of Server "+i);
			int size=sc.nextInt();
			System.out.println("Enter the Starting and Ending time of server connection"+i);
			for(int j=0;j<size;j++) {
				list.add(new int[] {sc.nextInt(),sc.nextInt()});
			}
			servers.add(list);
		}
		while(true){
			System.out.println("Enter\n1.Add PORT to new server\n2.End");
			int m=sc.nextInt();
			switch(m) {
			case 1:
				System.out.println("Enter the Starting and Ending time of server connection");
				int[] port=new int[2];
				port[0]=sc.nextInt();
				port[1]=sc.nextInt();
				int min=servers.get(0).size();
				int index=0;
				for(int i=1;i<servers.size();i++) {
					if(min>servers.get(i).size()) {
						min=servers.get(i).size();
						index=i;
					}
				}
				ArrayList<int[]> list=servers.get(index);
				list.add(port);
				servers.set(index, list);
				System.out.println(servers.get(index).toString());
				
			case 2:
				break;
			default :
				break;
			}
	}
	}

}
