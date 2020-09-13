import java.util.Scanner;

public class test4{
	public static int i,j,n;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String [][]ticTacToe=new String[3][3];//TicTacToe is short for "JingZiQi"
		
		initialize_ticTacToe(ticTacToe);
		Print_ticTacToe(ticTacToe);
		int k=0;
		String judge=null;
		while(true)
		{
			if(k%2==0)
			{
				judge="X";
			}
			else
			{
				judge="O";
			}
			k++;
			System.out.print("Enter a row(1,2,or 3) for player "+judge+":)");
			int row= input.nextInt();
			System.out.print("Enter a row(1,2,or 3) for player "+judge+":)");
			int colum =input.nextInt();
			if(isValid(row,colum,ticTacToe))
			{
				ticTacToe[row-1][colum-1]=judge;
				Print_ticTacToe(ticTacToe);
			}
			else
			{
				k--;//
			}
			if(isfull(ticTacToe))
			{
				System.out.println("The game has drawn.The game starts again!");
				initialize_ticTacToe(ticTacToe);
				Print_ticTacToe(ticTacToe);
			}			
			if(isWin(row,colum,judge,ticTacToe))
				break;
		}
		System.out.print(judge+" player won!");
	}
	public static void initialize_ticTacToe(String [][]arr)
	{
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				arr[i][j]=" ";//initialize
			}
		}
	}
	public static void Print_ticTacToe(String [][]arr)
	{
		System.out.println("-------------");
		for(i=0;i<3;i++)
		{
			
			for(j=0;j<3;j++)
			{
				System.out.print("|");
				System.out.print(" "+arr[i][j]+" ");
			}
		    System.out.println("|");
			System.out.println("-------------");
		}
	}
	public static boolean isValid(int l,int z,String [][]arr)
	{
		if(l<1||l>3||z<1||z>3)
		{
			System.out.println("The number is out of the range of Tic-Tac-Toe");
			return false;
		}
		if(!arr[l-1][z-1].equals(" "))
		{
			System.out.println("The position is not empty!");
			return false;
		}
		return true;
	}
	public static boolean isWin(int l,int z,String x,String [][]arr)
	{
		int sum=0;
		for(i=0;i<3;i++)
		{
			if(arr[i][z-1].equals(x))
			{
				sum++;
			}
		}
		if(sum==3)
			return true;
		sum=0;
		for(j=0;j<3;j++)
		{
			if(arr[l-1][j].equals(x))
			{
				sum++;
			}
		}
		if(sum==3)
			return true;
		sum=0;
		for(i=1;i<=3;i++)
		{
			for(j=1;j<=3;j++)
			{
				if((i-j)==(l-z)&&arr[i-1][j-1].equals(x))
					sum++; 
			}
		}
		if(sum==3)
			return true;
		sum=0;
		for(i=1;i<=3;i++)
		{
			for(n=1;n<=3;n++)
			{
				if((i+n)==(l+z)&&arr[i-1][n-1].equals(x))
					sum++;
			}
		}
		if(sum==3)
		{
		  return true;
		}
		return false;
	}
	public static boolean isfull(String [][]arr)
	{
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				if(arr[i][j].equals(" "))
				{
					return false;
				}
			}
		}
		return true;
	}
}