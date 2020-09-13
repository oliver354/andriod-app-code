package java.lang;
public class test5_1{
	private int chess;
	
	public test5_1()
	{
		System.out.println("The default is to get write chess.");
		chess=0;
	}
	public void get_initial_chess(int a)
	{
		chess=a;
		if(chess==0)
		{
			System.out.println("Tou choose the write");
		}
		else
		{
			System.out.println("Tou choose the black");
		}
	}
	public int get_chess()
	{
		return chess;
	}
	
}