package exception;


import java.util.InputMismatchException;
import java.util.Scanner;

public class task1 {
	public static void main(String[] args)
	{
		System.out.println("My input value:"+inputInt());
	}
	public static int inputInt()
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer:");
		try {
			int a = input.nextInt();
			return a;
		}catch(InputMismatchException e) {
			System.out.println("MisMatch!");
			return inputInt();
		}
	}

}
