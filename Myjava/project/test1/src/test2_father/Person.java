package test2_father;

public class Person {
	private String name;
	private String address;
	private long  Phone_number;
	private String Email;
	public Person()
	{
		name=null;
		address=null;
		Phone_number=0;
		Email=null;
	}
	public Person(String name,String address,long  number,String Email)
	{
		this.name=name;
		this.address=address;
		Phone_number=number;
		this.Email=Email;
	}
	public String toString()
	{
		return "Name:"+name+"\naddress:"+address+"\nPhone number"+Phone_number+"\nE-mail:"+Email;
	}
}
