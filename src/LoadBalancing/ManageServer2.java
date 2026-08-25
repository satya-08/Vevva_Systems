package LoadBalancing;

import java.util.ArrayList;
import java.util.Scanner;
public class ManageServer2 {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> servers=new ArrayList<>();
		System.out.println("Enter Total number of servers initially");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.println("Enter size of Server "+i);
			int size=sc.nextInt();
			ArrayList<Integer> list=new ArrayList<>();
			System.out.println("Enter Ports in Server "+i);
			for(int j=0;j<size;j++) {
				list.add(sc.nextInt());
			}
			servers.add(list);
		}
		while(true){
			System.out.println("Enter\n1.Add PORT to new server\n2.End");
			int m=sc.nextInt();
			switch(m) {
			case 1:
				System.out.println("Enter System number:");
				int x=sc.nextInt();
				int min=servers.get(0).size();
				int index=0;
				for(int i=1;i<servers.size();i++) {
					if(min>servers.get(i).size()) {
						min=servers.get(i).size();
						index=i;
					}
				}
				ArrayList<Integer> list=servers.get(index);
				list.add(x);
				servers.set(index, list);
				System.out.println(servers.toString());
			case 2:
				break;
			default :
				break;
			}
	}

}
}
