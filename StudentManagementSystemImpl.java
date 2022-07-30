package p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StudentManagementSystemImpl implements StudentManagementSystem {
	Scanner scan=new Scanner(System.in); 
	LinkedHashMap<Integer, Student> db= new LinkedHashMap<Integer,Student>();
	@Override
	public void addStudent() {
		System.out.println("enter Id,Name,Age and Marks");
		int id=scan.nextInt();
		String name=scan.next();
		int age=scan.nextInt();
		double marks=scan.nextDouble();

		//db.put(id,new Student(id,name,age,marks));
		Student std=new Student(id, name, age, marks);
		db.put(id, std);//db.put(std.getId(),std);
		System.out.println("Student Record Inserted Sucessfully");
	}
	@Override
	public void removeStudent() {
		System.out.println("Enter The Student Id");
		int id=scan.nextInt();
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Student Record Deleted");
		}
		else {
			try {
				throw new StudentNotFoundException("Student Data Not Found");

			}
			catch(StudentNotFoundException e){
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudent() {
		db.clear();
		System.out.println("All Students Data Removed Successfully");
	}
	@Override
	public void displayStudent() {
		System.out.println("Enter Student Id");
		int id=scan.nextInt();
		if(db.containsKey(id)) { 
			//System.out.println(db.get(id));
			Student std=db.get(id);//Student std=new Student(10,"a",24,65.66.....);
			//System.out.println(std);//since toString is Overriden);
			System.out.println("Id:"+std.getId());
			System.out.println("Name:"+std.getName());
			System.out.println("Age:"+std.getAge());
			System.out.println("Marks:"+std.getMarks());
		}
		else {
			try {
				throw new StudentNotFoundException("Student Data Not Found");
			}
			catch(StudentNotFoundException e){
				System.out.println(e.getMessage());
			}
		}
	}
	@Override  
	public void displayAllStudent() {
		Set<Integer> s=db.keySet();
		for(Integer id:s) {
			System.out.println(db.get(id));
		}
		/*for(integer key:setOfKeys){
		 * student s=db.get(key);
		 * System.out.println("Id:"+s.getId()+"\tName:"+s.getName());
		 * System.out.println("\tAge:"+s.getAge()+"\tMarks:"+getMarks());
		 */
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter Student Id");
		int id=scan.nextInt();
		if(db.containsKey(id)) {
			Student s=db.get(id);
			System.out.println("1.Update Name\n2:Update Age\n3:Update Marks");
			System.out.println("Enter Choice");
			int choice=scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter name");
				String name=scan.next();
				s.setName(name);
				break;
			case 2:
				System.out.println("Enter Age");
				int age=scan.nextInt();
				s.setAge(age);
				break;
			case 3:
				System.out.println("Enter Marks");
				double marks=scan.nextDouble();
				s.setMarks(marks);
				break;
			default :
				System.out.println("Invalid Id");
			}
			System.out.println("Student Data Update Successfully");
		}
		else {
			try {
				throw new StudentNotFoundException("Student Data Not Found");
			}
			catch(StudentNotFoundException e){
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countStudent() {
		System.out.println("No Of Student Record Present: "+db.size());

	}

	@Override
	public void sortStudent() {
		ArrayList<Student>l=new ArrayList<Student>();
		Set<Integer>s= db.keySet();
		for(int key:s) {
			l.add(db.get(key));
		}
		System.out.println("1.Sort Student By Id \n2:Sort Student By Name");
		System.out.println("3:Sort Student By Age\n4:Sort Student By Marks");
		System.out.println("Enter Choice");
		int choice=scan.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(l,new SortStudentById());
			display(l);
			break;
		case 2:
			Collections.sort(l,new SortStudentByName());
			display(l);

			break;
		case 3:
			Collections.sort(l,new SortStudentByAge());
			display(l);
			break;
		case 4:
			Collections.sort(l,new SortStudentByMarks());
			display(l);
			break;

		default:
			System.out.println("INVALID CHOICE");
		}
	}
	private static void display(List<Student> l) {
		for(Student s1:l){
			System.out.println(s1);
		}
	}
}
