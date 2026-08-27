package DSA;

import java.util.Scanner;

class ListNode{
	int data;
	ListNode next;
	ListNode(int data){
		this.data=data;
		this.next=null;
	}
}

public class MergeTwoSortedLists {
	
	public static ListNode createList(int[] arr) {
		ListNode head=new ListNode(arr[0]);
		ListNode temp=head;
		for(int i=1;i<arr.length;i++) {
			ListNode newnode=new ListNode(arr[i]);
			temp.next=newnode;
			temp=temp.next;
		}
		return head;
	}
	
	public static void displayList(ListNode head) {
			ListNode temp=head;
			System.out.print("List values: [ ");
			while(temp!=null) {
				System.out.print(temp.data);
				if(temp.next!=null)
				System.out.print(" -> ");
				temp=temp.next;
			}
			System.out.print(" ]");
		}

	public static void main(String[] args) {
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
		ListNode list1=createList(arr1);
		ListNode list2=createList(arr2);
		
		ListNode mergedList=mergeList(list1,list2);
		displayList(mergedList);
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
