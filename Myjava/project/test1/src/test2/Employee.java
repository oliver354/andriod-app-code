package test2;

import test2_father.Person;

public class Employee extends Person {
	private String office;
	private int wages;
	private myData appointment_data;
	public Employee() {
		
	}
	public Employee(String a,int b) {
		office=a;
	    wages=b;
	    appointment_data=new myData();
	}
	public Employee(String office,int wages,String name,String address,long number,String Email) {
		super(name,address,number,Email);
		this.office=office;
		this.wages=wages;
		appointment_data=new myData();
	}
	public String toString() {
		return super.toString()+"\noffice:"+office+"\nWages:"+wages+"\nData:"+appointment_data.getmyData();
	}
}
