package DSA;

public class WordSearch {
	public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean result =exist(board, word);
        System.out.println("Word: " + word);
        System.out.println("Exists: " + result);
    }
	public static  boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0))
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board,String word,int r,int c,int index){
        if(index==word.length()) return true;
        if(r<0||c<0||r>=board.length||c>=board[0].length||board[r][c]!=word.charAt(index))
        return false;
        char temp=board[r][c];
        board[r][c]='#';
        boolean found=(dfs(board,word,r+1,c,index+1)||dfs(board,word,r-1,c,index+1)||dfs(board,word,r,c+1,index+1)||dfs(board,word,r,c-1,index+1));
        board[r][c]=temp;
        return found;

    }
}

