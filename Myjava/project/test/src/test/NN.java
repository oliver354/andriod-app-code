package test;

public class NN  {  

	 




	  private int t;
	  static int i ;  // Please note that i is static
	  int j ;

	  NN() {
	    i++;
	    j++;
	  }

	  public static void main(String[] args) {
			int[][] tempGrid = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
					{1,0,0,2,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,1,0,0,0,2,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
			System.out.println(tempGrid.length);
           for(int i=0;i<tempGrid.length;i++)
           {
        	   for(int j=0;j<tempGrid.length;j++)
		       System.out.print(tempGrid[i][j]);
		       System.out.println();
           }
		  
		  }  







    public static void cout(int n)
    {
    	System.out.println(n);
    }

	// Print the message n time
}
class Apple extends Fruit {
}

class Fruit {
}
