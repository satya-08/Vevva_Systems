package OOPS_Design;


/*9. store list of students based on branch in a university for every branch 
 * store list of students , so that , students can be accessed based on branch 
 * name , for every student maintain following details RollNo,Name,Branch,Section,
 * Marks, Cgpa , grade when we store data RollNo,Name,Branch,Section,Marks 
 * and cgpa are the input grade should be computed and 
1.now display list off students branch wise 
2.list of students branch wise sorted descending order of grade 
3. list of students branch wise sorted in ascending order of marks 
4.given a branch find no.of students in that branch and names of students with 
   S grade 
5. find departments where we have highest no.of s grades*/

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class StudentCourseManagement {
	static HashMap<String,ArrayList<Student>> students=new HashMap<>();
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		students.put("ServiceNow", new ArrayList<>(Arrays.asList(
	            new Student(101, "Satya", "CAI", 'A', 8.89f, 90),
	            new Student(102, "Ravi", "CAI", 'B', 9.10f, 95),
	            new Student(103, "Kiran", "CAI", 'A', 7.80f, 75),
	            new Student(104, "Rahul", "CAI", 'C', 8.20f, 82),
	            new Student(105, "Anil", "CAI", 'B', 6.90f, 65)
	    )));

	    students.put("SAP", new ArrayList<>(Arrays.asList(
	            new Student(106, "Arjun", "CSE", 'A', 9.20f, 96),
	            new Student(107, "Vijay", "CSE", 'B', 8.70f, 88),
	            new Student(108, "Suresh", "CSE", 'A', 7.50f, 72),
	            new Student(109, "Nikhil", "CSE", 'C', 8.10f, 84),
	            new Student(110, "Karthik", "CSE", 'B', 6.80f, 60)
	    )));

	    students.put("UI/UX", new ArrayList<>(Arrays.asList(
	            new Student(111, "Pavan", "ECE", 'A', 9.30f, 98),
	            new Student(112, "Manoj", "ECE", 'B', 8.60f, 86),
	            new Student(113, "Tarun", "ECE", 'A', 7.90f, 78),
	            new Student(114, "Sai", "ECE", 'C', 8.40f, 91),
	            new Student(115, "Varun", "ECE", 'B', 6.70f, 55)
	    )));

	    students.put("DSA", new ArrayList<>(Arrays.asList(
	            new Student(116, "Rohit", "EEE", 'A', 9.40f, 97),
	            new Student(117, "Ajay", "EEE", 'B', 8.30f, 92),
	            new Student(118, "Mohan", "EEE", 'A', 7.60f, 96),
	            new Student(119, "Prakash", "EEE", 'C', 8.00f, 89),
	            new Student(120, "Vamsi", "EEE", 'A', 6.50f, 58)
	    )));

	    students.put("Python", new ArrayList<>(Arrays.asList(
	            new Student(121, "Surya", "MECH", 'A', 9.00f, 93),
	            new Student(122, "Ramesh", "MECH", 'B', 8.40f, 87),
	            new Student(123, "Dinesh", "MECH", 'A', 7.70f, 74),
	            new Student(124, "Harish", "MECH", 'C', 8.20f, 81),
	            new Student(125, "Naveen", "MECH", 'B', 6.60f, 52)
	    )));

//	    System.out.println("Total Students = " + Student.totalStudents);
	    
	    while(true) {
	    	System.out.println("Student Management System");
	    	System.out.println("1.Display all students Course wise\n"
	    			         + "2.Display all students cousre wise and marks in Desceding\n"
	    			         + "3.Display all students cousre wise and Grades in Desceding\n"
	    			         + "4.Display all students cousre wise and marks in Ascending\n"
	    			         + "5.Total Students and Students with A grade\n"
	    			         + "6.Find departments where we have highest no.of s grades"
	    			         + "7.End");
	    	int ch=scanner.nextInt();
	    	switch(ch) {
	    	case 1:
	    		getAllStudents();
	    		break;
	    	case 2:
	    		getstudentsmarksDesc();
	    		break;
	    	case 3:
	    		getstudentsgradeDesc();
	    		break;
	    	case 4:
	    		getstudentsmarksAsc();
	    		break;
	    	case 5:
	    		System.out.println("Enter which Branch want to see");
	    		scanner.nextLine();
	    		String course=scanner.nextLine();
	    		getgradeAStudents(course);
	    		break;
	    	case 6:
	    		gettoppers();
	    		break;
	    	case 7:
	    		System.exit(1);
	    	}
	    }

	}
	private static void gettoppers() {
		String tCourse="";
		int count=0;
		for(String course:students.keySet()){
			int aGradeCount=count;
			count=0;
			ArrayList<Student> list=students.get(course);
			for(Student stu:list) {
				if(stu.getGrade()=='A') count++;
			}
			if(count>aGradeCount) {
				tCourse=course;
			}
	}
		System.out.println(tCourse);
	}
	private static void getgradeAStudents(String course) {
		ArrayList<Student> list=students.get(course);
		System.out.println("Total Students in "+course+" : "+list.size());
		System.out.println("Students with A Grade: ");
		for(Student stu:list) {
			if(stu.getGrade()=='A')
			System.out.println(stu.toString());
		}
		
	}
	private static void getstudentsmarksAsc() {
		System.out.println("Students list Course wise with Marks Ascndig :");
		for(String course:students.keySet()) {
			System.out.println("Course :"+course);
			ArrayList<Student> list=students.get(course);
			list.sort(Comparator.comparing(Student::getMarks));
			for(Student stu:list) {
				System.out.println(stu.toString());
			}
		}
		
	}
	private static void getstudentsgradeDesc() {
		System.out.println("Students list Course wise with Grade Descending :");
		for(String course:students.keySet()) {
			System.out.println("Course :"+course);
			ArrayList<Student> list=students.get(course);
			list.sort(Comparator.comparing(Student::getGrade).reversed());
			for(Student stu:list) {
				System.out.println(stu.toString());
			}
		}
	}
	private static void getstudentsmarksDesc() {
		System.out.println("Students list Course wise with Marks Descending :");
		for(String course:students.keySet()) {
			System.out.println("Course :"+course);
			ArrayList<Student> list=students.get(course);
			list.sort(Comparator.comparing(Student::getMarks).reversed());
			for(Student stu:list) {
				System.out.println(stu.toString());
			}
		}
		
	
	}
	private static void getAllStudents() {
		System.out.println("Students list Course wise");
		for(String course:students.keySet()) {
			System.out.println("Course :"+course);
			ArrayList<Student> list=students.get(course);
			for(Student stu:list) {
				System.out.println(stu.toString());
			}
		}
		
	}

}

class Student{
	private int rollNo;
	private String name;
	private String branch;
	private char section;
	private float CGPA;
	private float marks;
	private char grade;
	static int totalStudents;
	
	public Student(int rollNo, String name, String branch, char section, float CGPA, float marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.branch = branch;
		this.section = section;
		this.CGPA = CGPA;
		this.marks = marks;
		totalStudents++;
		if(marks>=90) grade='A';
		else if(marks>=70 && marks<90) grade='B';
		else if(marks>=50 && marks<70) grade='C';
		else grade='F';
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public char getSection() {
		return section;
	}
	public void setSection(char section) {
		this.section = section;
	}
	public float getCGPA() {
		return CGPA;
	}
	public void setCGPA(float cGPA) {
		CGPA = cGPA;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public int getTotalStudents() {
		return totalStudents;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", branch=" + branch + ", section=" + section
				+ ", CGPA=" + CGPA + ", marks=" + marks + ", grade=" + grade + "]";
	}
	
	
}
