package test2_father;

import java.util.Scanner;

import son.Faculty;
import son.Staff;
import test2.Employee;
import test2.Student;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        System.out.println("Create Person objects");
        System.out.print("Enter name: ");
        String name = input.next();
        System.out.print("Enter address: ");
        String address = input.next();
        System.out.print("Enter phoneNumber: ");
        long phoneNumber = input.nextLong();
        System.out.print("Enter E-mail: ");
        String Email = input.next();
        Person person =new Person(name,address,phoneNumber,Email);
        System.out.println(person.toString());
        
        System.out.println("Create student objects:");
        System.out.print("Enter state(1,2,3 or 4)(年级):");
        int state = input.nextInt();
        Student student = new Student(state,name,address,phoneNumber,Email);
        System.out.println(student.toString());
        
        System.out.println("Create Employee objects:");
        System.out.print("Enter office(办公室):");
        String office = input.next(); 
        System.out.print("Enter Wages（工资）:");
        int wages = input.nextInt();
        Employee employee =new Employee(office,wages,name,address,phoneNumber,Email);
        System.out.println(employee.toString());
        
        System.out.println("Create Faculty objects:");
        System.out.print("Enter startWorkHour（开始时间）:");
        int startWorkHour = input.nextInt();
        System.out.print("Enter endWorkHour（结束时间）:");
        int endWorkHour = input.nextInt();
        System.out.print("Enter rank（级别）:");
        String rank = input.next();
        Faculty faculty=new Faculty(startWorkHour,endWorkHour,rank,office,wages,name,address,phoneNumber,Email);
        System.out.println(faculty.toString());
        
        System.out.println("Create Staff objects:");
        System.out.print("Enter Title_of_duty(职员称号):");
        String Title_of_duty = input.next(); 
        Staff staff=new Staff(Title_of_duty,office,wages,name,address,phoneNumber,Email);
        System.out.println(staff.toString());
        
	}

}
