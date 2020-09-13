import java.util.Scanner;

public class wuziqi{
	public static int i,j;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String [][] board = new String[6][7];
		
		//initialize
		for(i=0;i<board.length;i++)
		{
			for(j=0;j<board[i].length;j++)
			{
				board[i][j]=" ";
			}
		}
		
		//print
		print_board(board);
		
		//Input
		String judge=" ";
		String color;
		int column,row;
		int n=0;
		boolean istrue;
		while(true)
		{
			row=board.length-1;
			//System.out.println(row);
			if(n%2==0)
			{
				judge="R";
				color="red";
			}
			else
			{
				judge="Y";
				color="yellow";
			}
			System.out.print("Drop a "+color+" disk at column(0-6):");
			column = input.nextInt();
			

			if(isValid(row,column,board))
			{
				istrue=true;
				while(istrue)
				{
					if(isempty(row,column,board))
					    istrue=false;
					else
					    row--;
				}
				if(row>=0)
				{
				    board[row][column]=judge;
					print_board(board);
				}
				else
				{
					System.out.println("The column is full!Please input again.");
					n--;
				}
			}
			else
			{
				System.out.println("The number is out of the range!Input again.");
				continue;
			}
			n++;
			if(isWin(row,column,judge,board))
			{
				System.out.println("The "+color+" player won!");
				break;
			}
			if(isfull(board))
			{
				System.out.println("The game has drawn.");
				break;
			}
		}
	}
	public static void print_board(String[][]arr)
	{
		for(i=0;i<arr.length;i++)
		{		
			for(j=0;j<arr[i].length;j++)
			{
				System.out.print("|"+arr[i][j]);
			}
			System.out.println("|");
		}
		System.out.println("---------------------");
	}
	public static boolean isValid(int row,int column,String[][]arr)
	{
		if(row>=arr.length||row<0||column>=arr[row].length||column<0)
		{
			return false;
		}
		return true;
	}
	public static boolean isempty(int row,int column,String[][]arr)
	{	
		if(arr[row][column].equals(" "))
		{
			System.out.println("the position is empty!");
			return true;
		}
		return false;
	}
	public static boolean isWin(int l,int z,String x,String[][]arr)
	{
		int sum=0;
		int l0=l,l1=l,n;
		while(true)//just OK
		{
			if(l0-1>=0)//
			{
				l0--;
				if(arr[l0][z].equals(x)&&arr[l0+1][z].equals(x))//need 1 
					sum++;
			}
			if(l1+1<arr.length)//judge if the last could be inputed
			{
				if(arr[l1][z].equals(x)&&arr[l1+1][z].equals(x))
					sum++;
				l1++;
			}
			if(l0==0&&l1==arr.length-1)
				break;
		}
		if(sum+1==4)
			return true;
		int z0=z,z1=z;
		sum=0;
		while(true)//The purpose of  sum-1 is to clear thr remain
		{
			if(z0-1>=0)//
			{
				z0--;
				if(arr[l][z0].equals(x)&&arr[l][z0+1].equals(x))
					sum++;
			}
			if(z1+1<arr[0].length)
			{
				if(arr[l][z1].equals(x)&&arr[l][z1+1].equals(x))
					sum++;		
				z1++;
			}
			if(z0==0&&z1==arr[0].length-1)
				break;
		}
		if(sum+1==4)
			return true;
		sum=0;
		for(i=0;i<arr.length;i++)
		{
			for(n=0;n<arr[0].length;n++)
			{
				if((i+n)==(l+z)&&arr[i][n].equals(x))
					if(i!=arr.length-1&&n!=0)
					{
						if(arr[i+1][n-1].equals(x))
						{
					        sum++;
						}
						else
						{
							sum=0;
						}
					}
			}
		}
		if(sum+1==4)
		{
		  return true;
		}
		sum=0;
		for(i=0;i<arr.length;i++)
		{
			for(n=0;n<arr[0].length;n++)
			{
				if((i-n)==(l-z)&&arr[i][n].equals(x))
					if(i!=arr.length-1&&n!=arr[0].length-1)
						if(arr[i+1][n+1].equals(x))
						{
					        sum++;
						}
						else
						{
							sum=0;
						}
			}
		}
		if(sum+1==4)
		{
		  return true;
		}
		return false;
	}
	public static boolean isfull(String [][]arr)
	{
		for(i=0;i<arr.length;i++)
		{
			for(j=0;j<arr[i].length;j++)
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