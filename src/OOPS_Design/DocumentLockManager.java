package OOPS_Design;
import java.util.*;
public class DocumentLockManager {
	static HashMap<Integer,Boolean> document=new HashMap<>();
	static HashMap<Integer,Boolean> users=new HashMap<>();
	static HashMap<Integer,LockRequest> userdata=new HashMap<>();
	Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		

	}
	void requestdocument() {
		System.out.println("Enter user Id");
		int userid=sc.nextInt();
		System.out.println("Enter document Number: ");
		int docid=sc.nextInt();
		System.out.println("Enter the required time in Minutes");
		int timestamp=sc.nextInt();
		if(!users.containsKey(userid)|| users.get(userid)==false) {
			users.put(userid,true);
			if(!document.containsKey(docid)|| document.get(docid)==false) {
				document.put(docid, true);
				userdata.put(userid, new LockRequest(userid,docid,timestamp));
				System.out.println("Access Granted: ");
				System.out.println(userdata.get(userid).toString());
			}else {
				System.out.println("");
			}
		}
	}
	
	void realeselock(int docId,int userId) {
		
	}

}
class LockRequest{
	private int doc_id;
	private int user_id;
	private int timestamp;
	
	public LockRequest(int doc_id, int user_id,int timestamp) {
		super();
		this.doc_id = doc_id;
		this.user_id = user_id;
		this.timestamp=timestamp;
	}
	LockRequest(){
		
	}
	
	
	private int getTimestamp() {
		return timestamp;
	}
	private void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	private int getDoc_id() {
		return doc_id;
	}
	private void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	private int getUser_id() {
		return user_id;
	}
	private void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "LockRequest [doc_id=" + doc_id + ", user_id=" + user_id + ", timestamp=" + timestamp + "]";
	}
	
	
	
	
	
}
