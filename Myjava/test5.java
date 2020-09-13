package net;

//dao bao import
//import net.test5_1;
import java.util.Scanner;
public class test5{
	public static int i,j;
	public static String empty="\u2722",white = "\u263B",black = "\u263A";
	public static final int radius=5;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String [][] board = new String[10][10];
		//test5_1 a=new test5_1();
		//initialize
		for(i=0;i<board.length;i++)
		{
			for(j=0;j<board[i].length;j++)
			{
				board[i][j]=empty;
			}
		}
		
		//print
		System.out.println("*********Game Start!*********");
	    System.out.println("Play1:write  Play2:black");
		print_board(board);
		
		//Input
		String judge=empty;
		String color;
		int column,row;
		
		//System.out.print("Choose white(0) or black(1) to go black to go first:");
		//int who_gofirst = input.nextInt();
		//a.get_initial_chess(who_gofirst);
		//int n=a.get_chess();
		int n=0;
		while(true)
		{
			if(n%2==0)
			{
				judge= white;
				color="white";
			}
			else
			{
				judge= black;
				color="black";
			}
			System.out.print("Drop a "+color+" disk at row(1-10) and column (1-10):");
		    row = input.nextInt();
			column = input.nextInt();
			row--;
            column--;
			if(isValid(row,column,board))
			{
				if(isempty(row,column,board))
				{
				    board[row][column]=judge;
					print_board(board);
				}
				else
				{
					System.out.println("The position is full!Please input again.");
					n--;
				}
			}
			else
			{
				System.out.println("The number is out of the range!Input again.");
				continue;
			}
			n++;
			if(iswin_row(row,column,judge,board)
		       ||iswin_col(row,column,judge,board)
		       ||iswin_bias(row,column,judge,board)
		       ||iswin_anti_bias(row,column,judge,board))
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
		System.out.println("  1 2 3 4 5 6 7 8 9 10");
		for(i=0;i<arr.length;i++)
		{
            System.out.print(i+1);			
			for(j=0;j<arr[i].length;j++)
			{
				if(i!=arr.length-1&&j==0)
				    System.out.print(" ");	
				System.out.print(arr[i][j]);
			}
			System.out.println();
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
		if(!arr[row][column].equals(empty))
		{
			System.out.println("the position is not empty!");
			return false;
		}
		return true;
	}
	public static boolean isequal5(int sum1,int sum2)
	{
		if(sum1==radius||sum2==radius)
		{
			return true;
		}
		return false;
	}
	public static boolean iswin_row(int l,int z,String x,String[][]arr)
	{
		int sum1=0,sum2=0;
		if(l-radius>=-1)//l zui xiao shi 4 | 4-5=-1 | equal l>=4 
		{
			for(i=l;i>=0;i--)
			{
				if(arr[i][z].equals(x))
					sum1++;
			}
		}
		if(l+radius<=arr.length)//l zui da shi 5 |  5+5=10 |equal l<=5
		{
			for(j=l;j<arr.length;j++)
			{
				if(arr[j][z].equals(x))
					sum2++;
			}
		}
	    return isequal5(sum1,sum2);
	}
	public static boolean iswin_col(int l,int z,String x,String[][]arr)
	{
		int sum1=0,sum2=0;
		if(l-radius>=-1)//l zui xiao shi 4 | 4-5=-1 | equal l>=4 
		{
			for(i=z;i>=0;i--)
			{
				if(arr[l][i].equals(x))
					sum1++;
			}
		}
		if(l+radius<=arr[0].length)//l zui da shi 5 |  5+5=10 |equal l<=5
		{
			for(j=z;j<arr[0].length;j++)
			{
				if(arr[l][j].equals(x))
					sum2++;
			}
		}
        return isequal5(sum1,sum2);
	}
	public static boolean iswin_bias(int l,int z,String x,String[][]arr)
	{
		int sum1=0,sum2=0;
		if(l-radius+1>=0&&z-radius+1>=0)//left top
		{
			for(i=l;i>=0;i--)
			{
				for(j=z;j>=0;j--)
				{
					if((i-j)==(l-z)&&arr[i][j].equals(x))
					{
						sum1++;
					}
				}
			}
		}
		if(l<=arr.length-1-radius+1&&z<=arr[0].length-1-radius+1)//right bottom
		{
			for(i=l;i<arr.length;i++)
			{
				for(j=z;j<arr[0].length;j++)
				{
					if((i-j)==(l-z)&&arr[i][j].equals(x))
					{
						sum2++;
					}
				}
			}
		}
		return isequal5(sum1,sum2);
	}
	public static boolean iswin_anti_bias(int l,int z,String x,String[][]arr)
	{
		int sum1=0,sum2=0;
		if(l-radius+1>=0&&z<=arr[0].length-1-radius+1)//right top
		{
			for(i=l;i>=0;i--)//row
			{
				for(j=z;j<arr[0].length;j++)//col
				{
					if((i+j)==(l+z)&&arr[i][j].equals(x))
					{
						sum1++;
					}
				}
			}
		}
		if(l<=arr.length-1-radius+1&&z<=arr[0].length-1-radius+1)//left bottom
		{
			for(i=l;i<=arr.length;i++)//row
			{
				for(j=z;j>=0;j--)//col
				{
					if((i+j)==(l+z)&&arr[i][j].equals(x))
					{
						sum2++;
					}
				}
			}
		}
		return isequal5(sum1,sum2);
	}
	public static boolean isfull(String [][]arr)
	{
		for(i=0;i<arr.length;i++)
		{
			for(j=0;j<arr[i].length;j++)
			{
				if(arr[i][j].equals(empty))
				{
					return false;
				}
			}
		}
		return true;
	}
}