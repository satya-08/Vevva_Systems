package LoadBalancing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
		
		ScheduledExecutorService schedular=Executors.newScheduledThreadPool(1);
		int[] count= {0};
		//scheduleAtFixedRate(task, initialDelay, period, timeUnit)
		schedular.scheduleAtFixedRate(()->{connChecker(servers,count[0]);count[0]++;},0,1,TimeUnit.MINUTES);
		
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
				System.out.println("Status of Each port");
				for(int i=0;i<servers.size();i++) {
					System.out.println("Server "+i+" :");
					for(int[] arr:servers.get(i)) {
						System.out.println(Arrays.toString(arr));
					}
					System.out.println();
				}
				
			case 2:
				break;
			default :
				break;
			}
	}
	}

	private static void connChecker(ArrayList<ArrayList<int[]>> servers, int currentTime) {
		for(int i=0;i<servers.size();i++) {
			int index=0;
			ArrayList<int[]> list=servers.get(i);
			while(index<list.size()) {
				int[] ans=list.get(index);
				if(ans[1]<currentTime) {
					list.remove(index);
				}else 
					index++;
			}
			servers.set(i, list);
		}
	}

}
