import java.util.Scanner;

public class test1{
	public static void main (String[] args){
		Scanner input = new Scanner (System.in);
		System.out.println("*********Game Start*********");
		
		int computerNum = 0;
		int peopleNum = 0;
		String[] select = {"scissor","rock","paper"};
		
		while(computerNum < 2&&peopleNum < 2)
		{
			int computer = (int)(Math.random()*3);
			System.out.print("scissor(0),rock(1),paper(2):");
			int people=input.nextInt();
			if(people>2&&people<0){
				System.out.println("your input is out of the range of the game!please input your number again.");
				people =input.nextInt();
			}
			int judge = people -computer;
			if(judge ==1||judge == -2){
				peopleNum++;
				
			}
			else if(judge !=0)
			{
				computerNum++;
			}
			
			System.out.printf("the computer is %s,you are %s,(computer:%d,you:%d)\n",select[computer],select
			[people],computerNum,peopleNum);
		}
		if(peopleNum==2)
			System.out.print("You won !");
		else
			System.out.print("You lose !");
	}
}