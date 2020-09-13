package ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class as {
	public static void main(String[] args) throws FileNotFoundException {
		String subString= args[0];
		System.out.println(subString);
		Scanner input = new Scanner (new File("C:/Users/°²µÇ/Desktop/Myjava/project/source/words.txt"));
		PrintWriter pw = new PrintWriter("C:/Users/°²µÇ/Desktop/Myjava/project/source/words_copy.txt");
		while(input.hasNext())
		{
			String word = input.nextLine();
			int index = word.indexOf(subString);
			if(index<word.length())
			{
				pw.print(word);
				pw.println();
			}
		
		}
		
		input.close();
		pw.close();
	}
}
