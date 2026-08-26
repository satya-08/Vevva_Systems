package OOPS_Design;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class DocumentLockManager {
	//User Object
	static HashMap<Integer,User> users=new HashMap<>();
	//User Documents that are locked
	static HashMap<Integer,ArrayList<Integer>> userdocuments=new HashMap<>();
	// Documents Lock Status
	static HashMap<Integer,Boolean> documents=new HashMap<>();
	//  LockRequests
	static HashMap<Integer,LockRequest> lockRequests=new HashMap<>();
	static Scanner scanner=new Scanner(System.in);
	
	
	public static void main(String[] args) {
		ScheduledExecutorService scheduler=Executors.newScheduledThreadPool(1);
		int[] count= {0};
		scheduler.scheduleAtFixedRate(()->{expireLocks(count[0]);count[0]++;},0,20,TimeUnit.MINUTES);
		while(true) {
	        System.out.println("1.Create Document");
	        System.out.println("2.Request Document Lock");
	        System.out.println("3.Release Document Lock");
	        System.out.println("4.Exit");
	        System.out.print("Enter your choice: ");
	        int choice=scanner.nextInt();
	        switch(choice){
	            case 1:
	                createDocument();
	                break;
	            case 2:
	                requestdocument();
	                break;
	            case 3:
	                System.out.print("Enter User Id: ");
	                int userId = scanner.nextInt();
	                System.out.print("Enter Document Id: ");
	                int docId = scanner.nextInt();
	                releaseLock(userId, docId);
	                break;
	            case 4:
	                scheduler.shutdown();
	                System.out.println("Program terminated.");
	                scanner.close();
	                return;
	            default:
	                System.out.println("Invalid choice!");
	        }
	    }
	}
	
	static void createDocument() {
		System.out.println("Enter document Id: ");
		int docid=scanner.nextInt();
		if(documents.containsKey(docid)) {
			System.out.println("Document already Present");
			return;
		}
		documents.put(docid,false);
	}
	
	static void requestdocument() {
		System.out.println("Enter user Id");
		int userid=scanner.nextInt();
		// Checking user present or not
		if(!users.containsKey(userid)) {
			System.out.println("Your UserId doesn't exist\n Enter your name for creating an user");
			scanner.nextLine();
			String name=scanner.nextLine();
			users.put(userid,new User(userid,name));
			System.out.println("User Created Successfully...!");
		}
		System.out.println("Enter document Id: ");
		int docid=scanner.nextInt();
		if(!documents.containsKey(docid)) {
			System.out.println("Document doesn't Exist..!");
			return;
		}
		if(documents.containsKey(docid)&&documents.get(docid))
		{
			System.out.println("Access Denied! Document "+docid+" Locked...");
			return;
		}
		System.out.println("Enter the required time in Minutes");
		int timestamp=scanner.nextInt();
		// Document locked
		documents.put(docid, true);
		ArrayList<Integer> list=userdocuments.get(userid);
		if(list==null) list=new ArrayList<>();
		list.add(docid);
		// Update the user documents
		userdocuments.put(userid,list);
		// LockRequest update
		lockRequests.put(docid,new LockRequest(userid,docid,timestamp));
		System.out.println("\nAccess Granted!");
        System.out.println("Document " + docid + " is now locked.");
        System.out.println("User: " + users.get(userid).getName());
        System.out.println("Lock time: " + timestamp + " minutes");
		
	}
	
	static void releaseLock(int userId,int docId) {
		if(!users.containsKey(userId)||!documents.containsKey(docId)) {
			System.out.println("User/Document doesn't exist!");
			return;
		}
		if(!documents.get(docId)) {
			System.out.println("Document already in Release State");
			return;
		}
		LockRequest request=lockRequests.get(docId);
		if(request==null) {
			System.out.println("No Locks found");
			return;
		}
		if(request.getUser_id()!=userId) {
			System.out.println("You can't release the another user Request document");
			return;
		}
		documents.put(docId, false);
		lockRequests.remove(docId);
		ArrayList<Integer> list=userdocuments.get(userId);
		if(list!=null) {
			list.remove(docId);
			if(list.isEmpty()) {
				userdocuments.remove(userId);
			}
		}
		System.out.println("Document "+docId+" Unlocked!");
		
	}
	
	static void expireLocks(int currentTime) {
	    for (LockRequest request:new ArrayList<>(lockRequests.values())) {
	        if (request.getTimestamp()<=currentTime) {
	        	releaseLock(request.getUser_id(), request.getDocid());
	        }
	    }
	}

}
class LockRequest{
	private int docid;
	private int user_id;
	private int timestamp;
	
	
	public LockRequest(int docid, int user_id, int timestamp) {
		super();
		this.docid = docid;
		this.user_id = user_id;
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "LockRequest [docid=" + docid + ", user_id=" + user_id + ", timestamp=" + timestamp + "]";
	}
	 int getDocid() {
		return docid;
	}
	 void setDocid(int docid) {
		this.docid = docid;
	}
	int getUser_id() {
		return user_id;
	}
	void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	int getTimestamp() {
		return timestamp;
	}
	void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
class User{
	private int userId;
	private String name;
	public User(int userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}
	int getUserId() {
		return userId;
	}
	void setUserId(int userId) {
		this.userId = userId;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + "]";
	}
	
	
}
