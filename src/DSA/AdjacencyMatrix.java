package DSA;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
public class AdjacencyMatrix{
		static int mat[][];
		static int n;
		public AdjacencyMatrix(int n) {
			this.n=n;
			this.mat=new int[n][n];
		}
		public void  addEdge(int u,int v) {
			mat[u][v]=1;
			mat[v][u]=1;
		}
		public void display() {
			int row = 0;
			for(int[] r:mat) {
				System.out.println(row+"-> ");
				for(int x:r) {
					System.out.print(x+" ");
				}
				row++;
				System.out.println();
			}
		}
		
		// DFS Recursion
		public void dfsrecursion(int s, boolean[] visited) {
			System.out.print(s+"-> ");
			visited[s]=true;
			for(int i=0;i<n;i++) {
				if(mat[s][i]==1&&!visited[i]) {
					dfsrecursion(i, visited);
				}
			}
			
		}
		
		// DFS Recursion Returning List
		public ArrayList<Integer> dfsrecursionList(int s) {
			boolean[] visited=new boolean[n];
			ArrayList<Integer> res=new ArrayList<>();
			dfsHelper(res,visited,s);
			return res;
		}
		private static void dfsHelper(ArrayList<Integer> res,boolean[] visited,int s) {
			res.add(s);
			visited[s]=true;
			for(int i=0;i<n;i++) {
				if(mat[s][i]==1&&!visited[i]) {
					dfsHelper(res,visited,i);
				}
			}
		}
		
		// DFS without Recursion
		public List<Integer> dfsiteration(int s,boolean[] visited) {
			List<Integer> res=new ArrayList<>();
			Stack<Integer> stack=new Stack<>();
			stack.push(s);
			visited[s]=true;
			while(!stack.isEmpty()) {
				int ele=stack.pop();
				res.add(ele);
				for(int i=0;i<n;i++) {
					if(mat[ele][i]==1&&!visited[i]) {
						stack.push(i);
						visited[i]=true;
					}
				}
			}
			return res;
		}
		
		// DFS Recursion Without start vertex
		public ArrayList<Integer> dfsrecursion() {
			boolean[] visited=new boolean[n];
			ArrayList<Integer> res=new ArrayList<>();
			for(int i=0;i<n;i++)
					if(!visited[i])
						dfsHelper(res, visited, i);
			return res;
		}
	}
