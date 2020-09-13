import java.util.Scanner;

public class test2{
	public static int i,j,m,k;
	public static void main (String[] args){
		Scanner input = new Scanner (System.in);
		int [][] grid = {{5,3,0,0,7,0,0,0,0},
			             {6,0,0,1,9,5,0,0,0},
				         {0,9,8,0,0,0,0,6,0},
				      	 {8,0,0,0,6,0,0,0,3},
						 {4,0,0,8,0,3,0,0,1},
					     {7,0,0,0,2,0,0,0,6},
						 {0,6,0,0,0,0,0,0,0},
						 {0,0,0,4,1,9,0,0,5},
		                 {0,0,0,0,8,0,0,7,9}};
		
		int remain=0;
		//Printgrid
		remain=Printgrid(grid);//Alalyze and Print
		
		while(remain>0)
		{
			System.out.print("Enter row,colum and number([1-9] [1-9] [1-9]): ");
			int l = input.nextInt();
			int z = input.nextInt();
			int x = input.nextInt();
			if(grid[l-1][z-1]!=0)
			{
				System.out.println("The cell is not empty!");
			}
			else
			{
				if(isValid(l,z,x,grid))
				{
					grid[l][z]=x;
					System.out.println("The current state of grid:");
					remain=Printgrid(grid);
				}
				else
				{
					System.out.println("The number is irrational.");
				}
			}
		}
		
	}
	public static int Printgrid(int [][]arr)
	{
		int remain=0;
		for(i=0;i<arr.length;i++)
		{
			for(j=0;j<arr[i].length;j++)
			{
				if(arr[i][j]==0)
				{
					remain++;
				}
				if(j==3||j==6||j==9)
				{
					System.out.printf("%2s","|");
				}
				System.out.printf("%2d",arr[i][j]);
			}
			System.out.println();
			if(i==2||i==5||i==8)
			{
				System.out.println("-------|-------|-------|");
			}
		}
		return remain;
	}
	public static boolean isValid(int l,int z,int x,int [][]arr)
	{
		if(l>0&&l<=9)
		{
			if(z>0&&z<=9)
			{
				if(x>=0&&x<=9)
				{
					
				}
				else
				{
			        System.out.println("number error!");
					return false;
				}
			}
		    else
			{
			    System.out.println("colums error!");
				return false;
			}
		}
		else
		{
			System.out.println("rows error!");
			return false;
		}
		for(i=0;i<arr.length;i++)
			if(!(i!=l&&arr[i][z-1]==x))
				return false;
			
		for(j=0;j<arr[l-1].length;j++)
			if(!(j!=z&&arr[l-1][j]==x))
				return false;
			
		//小九宫格不能重复
		int temp1=3;
		int temp2=3;
		for(i=0;i<3;i++)
		{
			if(l-1<temp1)//3 6 9
			{
				i=3;
				for(j=0;j<3;j++)
				{
				    if(z-1<temp2)
					{   
			        	j=3; 
						for(m=temp1-1;m>temp1-1-3;m--)
						{
							for(k=temp2-1;k>temp2-1-3;k--)
							{
								if(arr[m][k]==x)
								{
									return false;
								}
							}
						}
			
					}
					else
					{
						temp2+=3;
					}
				}
			}
			else
			{
				temp1+=3;
			}
			
		}
		return true;
	}
}
			
			
	








	
			