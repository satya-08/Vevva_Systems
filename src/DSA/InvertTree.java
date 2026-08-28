package DSA;

import java.util.Scanner;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){
		
	}
	TreeNode(int val){
		this.val=val;
	}
	public TreeNode(int val, TreeNode left, TreeNode right) {
//		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
public class InvertTree {
	
	public static TreeNode createBSTTree(int[] arr) {
	    if (arr.length==0)
	        return null;
	    TreeNode root=new TreeNode(arr[0]);
	    for (int i=1;i<arr.length;i++){
	        TreeNode temp=root;
	        while (true){
	            if(arr[i]<temp.val) {
	                if(temp.left==null) {
	                    temp.left=new TreeNode(arr[i]);
	                    break;
	                }
	                temp=temp.left;
	            }
	            else{
	                if(temp.right==null) {
	                    temp.right=new TreeNode(arr[i]);
	                    break;
	                }
	                temp=temp.right;
	            }
	        }
	    }
	    return root;
	}
	public static void main(String[] args) {
		System.out.println("Enter the size of tree");
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter tree elements:");
		for(int i=0;i<n;i++) arr[i]=scanner.nextInt();
		TreeNode root=createBSTTree(arr);
		TreeNode invert=invertTree(root);
		displayTree(invert);
	}
	private static TreeNode invertTree(TreeNode root) {
		if(root==null) return null;
		TreeNode temp=root.left;
		root.left=invertTree(root.right);
		root.right=invertTree(temp);
		return root;
	}
	public static void displayTree(TreeNode root){
	    if(root==null)
	        return;

	    displayTree(root.left);
	    System.out.print(root.val+" ");
	    displayTree(root.right);
	}

}
