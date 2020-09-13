import java.util.Scanner;

public class test3{
	public static int i,j,k;
	static Scanner input = new Scanner (System.in);
	public static void main (String[] args){
		//Scanner input = new Scanner (System.in);
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
					grid[l-1][z-1]=x;
					System.out.println("The current state of grid:");
					remain=Printgrid(grid);
				}
				else
				{
					System.out.println("The number is irrational.");
				}
			    if(Isremove())
				{
					reset_number(grid);
					System.out.println("The current state of grid:");
					Printgrid(grid);
				}
			}
		}
		System.out.println("You win!");
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
				System.out.printf("%2d",arr[i][j]);				
				if(j==2||j==5||j==8)
				{
					System.out.printf("%2s","|");
				}
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
		{
			if((i!=l-1)&&arr[i][z-1]==x)//colum
				return false;
            if((i!=z-1)&&arr[l-1][i]==x)//row
				return false;				
		}
		
        for(j=(l-1)/3*3;j<(l-1)/3*3+3;j++)
		{
			for(k=(z-1)/3*3;k<(z-1)/3*3+3;k++)
			{
				if(arr[j][k]==x)
				{
					System.out.println("the number repeats in a box");
					return false;
				}
			}
		}	
		return true;
	}
	public static boolean Isremove()
	{
		//Scanner input = new Scanner (System.in);
		System.out.println("Do you want to modify the value of the number you entered? '1'or'0'");
		String a=input.next();//No String after the "input"!!!
		if(a.equals("1"))
			return true;
		else
			return false;		
	}
	public static void reset_number(int [][]arr)
	{
		int n=0;
		System.out.print("Please input the row and column of the number you want to reset:");
		int row = input.nextInt();
		int colum = input.nextInt();
		int [][]grid_fixed = {{5,3,0,0,7,0,0,0,0},
			                 {6,0,0,1,9,5,0,0,0},
				             {0,9,8,0,0,0,0,6,0},
				      	     {8,0,0,0,6,0,0,0,3},
						     {4,0,0,8,0,3,0,0,1},
					         {7,0,0,0,2,0,0,0,6},
						     {0,6,0,0,0,0,0,0,0},
						     {0,0,0,4,1,9,0,0,5},
		                     {0,0,0,0,8,0,0,7,9}};
		if(grid_fixed[row-1][colum-1]!=0)
			{
				System.out.println("The modified number isn't legal! please input again!");
				reset_number(arr);
			}
			
		for(k = 0;k < 10; k++)
		{
			System.out.print("The number value:");
			n = input.nextInt();
	  	    if(n>9||n<0)
			{
				System.out.println("The number error!");
			}
			else
			{
				break;
			}
		}
		arr[row-1][colum-1]=n;
	}
}
			
		//小九宫格不能重复
		/*int temp1=3;
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
			
		}*/			
	








	
			