package p1;

import java.util.Scanner;

public class Registration {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Welcome to student data base management system");
		System.out.println("==============");
		StudentManagementSystem obj =new StudentManagementSystemImpl();
		while(true) {
			System.out.println("1. ADD STUDENT ");
			System.out.println("2. REMOVE STUDENT ");
			System.out.println("3. REMOVE ALL STUDENT");
			System.out.println("4. DISPLAY STUDENT");
			System.out.println("5.DISPLAY ALL STUDENT ");
			System.out.println("6. UPDATE STUDENT");
			System.out.println("7. COUNT STUDENT");
			System.out.println("8. SORT STUDENT");
			System.out.println("9. EXIT");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				obj.addStudent();
				break;
			case 2:
				obj.removeStudent();
				break;
			case 3:
				obj.removeAllStudent();
				break;
			case 4:
				obj.displayStudent();
				break;
			case 5:
				obj.displayAllStudent();
				break;
			case 6:
				obj.updateStudent();
				break;
			case 7:
				obj.countStudent();
				break;
			case 8:
				obj.sortStudent();
				break;
			case 9:
				System.out.println("THANK YOU");
				System.exit(0);
			default:
				System.out.println("INVALID CHOICE");
			}
		}
	}
}
