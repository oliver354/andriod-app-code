package test2;

import test2_father.Person;

public class Student extends Person{
	private int state;
    public static final int FRRESHMAN = 1;
    public static final int SOPHOMORE = 2;
    public static final int JUNIOR = 3;
    public static final int SENIOR = 4;
	 public Student(int state, String name, String address, long phoneNumber, String Email) {
		 super(name,address,phoneNumber,Email);
		 this.state=state;
	 }
	 public Student(final int s) throws Exception {
		 System.out.println("�༶״̬��Χ��1,2,3,4");
		 if(s==1||s==2||s==3||s==4) {
			 state=s;
		 }
		 else {
			 throw new Exception ("������ѧ���༶״��δ���ڹ涨��Χ�ڣ�");
		 }
	 }
	 public String toString() {
		 return super.toString()+"\nState:"+state;
	 }
	 
}
