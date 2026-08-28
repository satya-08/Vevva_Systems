package DSA;
import DSA.ListNode;
import java.util.Scanner;

public class LinkedListCycle {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter size of the list :");
	int n=scanner.nextInt();
	int[] arr=new int[n];
	System.out.println("Enter list elements:");
	for(int i=0;i<n;i++) arr[i]=scanner.nextInt();
	System.out.println("Enter value where you want to add cycle");
	int index=scanner.nextInt();
	ListNode list=new ListNode();
	ListNode head=list.createCircularList(arr,index);
	System.out.println(isCircularList(head));
}

private static boolean isCircularList(ListNode head) {
	ListNode slow=head;
	ListNode fast=head;
	while(fast.next!=null && fast!=null) {
		slow=slow.next;
		fast=fast.next.next;
		if(fast==slow) return true;
	}
	return false;
}


}
