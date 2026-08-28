package DSA;

public class ListNode {
	int data;
	ListNode next;
	ListNode(){
		
	}
	ListNode(int data){
		this.data=data;
		this.next=null;
	}
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
	public static ListNode mergeList(ListNode list1, ListNode list2) {
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
	public ListNode createCircularList(int[] arr,int pos){
		
	    if(arr.length==0)
	        return null;
	    ListNode head=new ListNode(arr[0]);
	    ListNode temp=head;
	    ListNode loopNode=null;
	    if(pos==0)
	        loopNode=head;

	    for(int i=1;i<arr.length;i++){
	        ListNode newNode=new ListNode(arr[i]);
	        temp.next=newNode;
	        temp=newNode;
	        if(i==pos)
	            loopNode=temp;
	    }
	    temp.next=loopNode;
	    return head;
	}
}
