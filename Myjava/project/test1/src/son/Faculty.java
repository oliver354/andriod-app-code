package son;

import test2.Employee;

public class Faculty extends Employee{
	 private int startWorkHour;
	 private int endWorkHour;
	 private String rank;
	 public Faculty() {
		 
	 }
	 public Faculty(int startWorkHour,int endWorkHour,String rank) {
		 this.startWorkHour=startWorkHour;
		 this.endWorkHour=startWorkHour;
		 this.rank=rank;
	 }
	 public Faculty(int startWorkHour,int endWorkHour,String rank,String office,int wages,String name,String address,long  number,String Email) {
		 super(office,wages,name,address,number,Email);
		 this.startWorkHour=startWorkHour;
		 this.endWorkHour=endWorkHour;
		 this.rank=rank;
	 }
	 public String toString() {
		 return super.toString()+"\nWorkHour:"+startWorkHour+":00 -"+endWorkHour+":00\nrank:"+rank;
	 }

}
