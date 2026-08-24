package OOPS_Design;

import java.util.*;

public class Student_Course {
	private static HashMap<String,ArrayList<Students>> student=new HashMap<>();
	public static void main(String[] args) {
		student.put("CAI", new ArrayList<>(Arrays.asList(
			    new Students(101, "Satya", "satya@gmail.com", 51),
			    new Students(102, "Anu", "anu@gmail.com", 98),
			    new Students(103, "Pranay", "pranay@gmail.com", 79),
			    new Students(104, "Jannu", "jannu@gmail.com", 91),
			    new Students(105, "Bhanu", "bhanu@gmail.com", 70)
			)));

			student.put("CSE", new ArrayList<>(Arrays.asList(
			    new Students(201, "Rahul", "rahul@gmail.com", 88),
			    new Students(202, "Sneha", "sneha@gmail.com", 76),
			    new Students(203, "Kiran", "kiran@gmail.com", 95),
			    new Students(204, "Priya", "priya@gmail.com", 67),
			    new Students(205, "Vijay", "vijay@gmail.com", 82)
			)));

			student.put("ECE", new ArrayList<>(Arrays.asList(
			    new Students(301, "Arjun", "arjun@gmail.com", 72),
			    new Students(302, "Divya", "divya@gmail.com", 89),
			    new Students(303, "Manoj", "manoj@gmail.com", 64),
			    new Students(304, "Swathi", "swathi@gmail.com", 93),
			    new Students(305, "Nikhil", "nikhil@gmail.com", 78)
			)));

			student.put("EEE", new ArrayList<>(Arrays.asList(
			    new Students(401, "Ravi", "ravi@gmail.com", 81),
			    new Students(402, "Pooja", "pooja@gmail.com", 69),
			    new Students(403, "Suresh", "suresh@gmail.com", 96),
			    new Students(404, "Lakshmi", "lakshmi@gmail.com", 74),
			    new Students(405, "Harsha", "harsha@gmail.com", 87)
			)));

			student.put("MECH", new ArrayList<>(Arrays.asList(
			    new Students(501, "Vamsi", "vamsi@gmail.com", 100),
			    new Students(502, "Keerthi", "keerthi@gmail.com", 92),
			    new Students(503, "Naresh", "naresh@gmail.com", 77),
			    new Students(504, "Teja", "teja@gmail.com", 84),
			    new Students(505, "Deepak", "deepak@gmail.com", 71)
			)));
		  getstudentsbyDept("CAI");
		  gethighestmarksoverall();
		  gethighestmarkseachdept();
	}
	private static void gethighestmarkseachdept() {
		for(String dept:student.keySet()) {
			int marks=0;
			Students topper=new Students();
			for(Students stud:student.get(dept)) {
				if(marks<stud.getMarks()) {
					marks=stud.getMarks();
					topper=stud;
				}
			}
			System.out.println("Highest marks in "+dept+" :");
			System.out.println(topper.toString());
		}
	}
	private static void gethighestmarksoverall() {
		int marks=0;
		Students topper=new Students();
		for(String dept:student.keySet()) {
			for(Students stud:student.get(dept)) {
				if(marks<stud.getMarks()) {
					marks=stud.getMarks();
					topper=stud;
				}
			}
		}
		System.out.println("Highest Marks Student: ");
		System.out.println(topper.toString());
		
	}
	private static void getstudentsbyDept(String dept) {
		if(student.containsKey(dept)) {
		for(Students stud:student.get(dept)) {
			System.out.println(stud.toString());
		}
	}else {
		System.out.println("No Department found with :"+dept);
	}
	}
	
	
}
class Students{
	private int id;
	private String name;
	private String email;
	private int marks;
	private static int total_students;
	
	Students(){
		
	}
	
	public Students(int id, String name, String email, int marks) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.marks = marks;
		total_students++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", email=" + email + ", marks=" + marks + "]";
	}
	
	
	
}
	