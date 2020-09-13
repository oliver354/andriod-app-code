package son;

import test2.Employee;

public class Staff extends Employee{
	private String Title_of_duty;
	public Staff(){
		
	}
	public Staff(String Title_of_duty) {
		this.Title_of_duty=Title_of_duty;
	}
	public Staff(String Title_of_duty,String office,int wages,String name,String address,long  number,String Email) {	
		super(office,wages,name,address,number,Email);
		this.Title_of_duty=Title_of_duty;
	}
	public String toString() {
		return super.toString()+"\nTitle_of_duty:"+Title_of_duty;
	}

}
