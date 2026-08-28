package DSA;

import java.util.Scanner;
import DSA.ListNode;
public class MergeTwoSortedLists {
	public static void main(String[] args) {
		ListNode list=new ListNode();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter size of the list 1:");
		int n=scanner.nextInt();
		int[] arr1=new int[n];
		System.out.println("Enter list 1 elements:");
		for(int i=0;i<n;i++) {
			arr1[i]=scanner.nextInt();
		}
		System.out.println("Enter size of the list 2:");
		int m=scanner.nextInt();
		int[] arr2=new int[m];
		System.out.println("Enter list 2 elements:");
		for(int i=0;i<m;i++) {
			arr2[i]=scanner.nextInt();
		}
		ListNode list1=list.createList(arr1);
		ListNode list2=list.createList(arr2);
		
		ListNode mergedList=mergeList(list1,list2);
		list.displayList(mergedList);
	}
	
	private static ListNode mergeList(ListNode list1, ListNode list2) {
		ListNode dummy=new ListNode(-1);
		ListNode temp=dummy;
		while(list1!=null && list2!=null) {
			if(list1.data>list2.data) {
				temp.next=list2;
				list2=list2.next;
			}
			else {
				temp.next=list1;
				list1=list1.next;
			}
			temp=temp.next;
		}
		if(list1!=null) {
			temp.next=list1;
		}
		if(list2!=null) temp.next=list2;
		return dummy.next;
	}

}
