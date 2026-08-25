package LoadBalancing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class ManageServer1 {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> servers=new ArrayList<>();
		servers.add(new ArrayList<>(Arrays.asList(1,2,3)));
		servers.add(new ArrayList<>(Arrays.asList(1,2,4,5)));
		servers.add(new ArrayList<>(Arrays.asList(1,2,3,5,6,7)));
		servers.add(new ArrayList<>(Arrays.asList(1)));
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Enter\n1.Add PORT to new server\n2.End");
			int n=sc.nextInt();
			switch(n) {
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
