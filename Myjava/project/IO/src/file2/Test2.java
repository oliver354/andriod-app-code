package file2;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the number of random geometry you want to generate:");
		int num=input.nextInt();
		String in="C:/Users/安登/Desktop/Myjava/project/source/Src.txt";
		String out="C:/Users/安登/Desktop/Myjava/project/source/sort.txt";
		generate(in,num);
		sortByArea(in,out);
		System.out.println("Success!");
		input.close();
		
	}
	public static void sortByArea(String srcPath, String sortPath){
		List<GeomertricObject> list = new ArrayList<GeomertricObject>();
		try {
			String line = "";
			int position1,position2,position3;
			Scanner input = new Scanner(new FileInputStream(srcPath));
			// get geometric objects from file
			while(input.hasNext())	
			{
				line = input.nextLine();
				position1=line.indexOf(",",line.indexOf(","));
				position2=line.indexOf(",",line.indexOf(",")+1);
				if(line.indexOf("Circle")==0)
				{
					double r=Double.parseDouble(line.substring(position1+1,position2));
					GeomertricObject circle=new Circle(r);
				    list.add(circle);
				}
				else
				{
					position3=line.lastIndexOf(",");
					double a=Double.parseDouble(line.substring(position1+1,position2));
					double b=Double.parseDouble(line.substring(position2+1,position3));
					GeomertricObject rectangle = new Rectangle(a,b);
					list.add(rectangle);
				}
			}
			Collections.sort(list);
			PrintWriter pw = new PrintWriter(sortPath);
			// output sorted geometric object to file
			for(int i=0;i<list.size();i++)
			{
				pw.println(list.get(i).toString());
			}
			pw.close();
			input.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void generate(String path, int num){
		try {
			PrintWriter pw = new PrintWriter(path);
			// generate num geometric objects
			double a,b,c;
			for(int i=0;i<num;i++)
			{
				a=Math.random();
				b=Math.random();
				c=Math.random();
				if(a<0.5)
				{
					GeomertricObject circle=new Circle(b);
					pw.println(((Circle)circle).toString());			
				}
				else 
				{
					GeomertricObject rectangle = new Rectangle(b,c);
					pw.println(((Rectangle)rectangle).toString());
				}
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
