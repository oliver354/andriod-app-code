package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO �Զ����ɵķ������
		String subString=args[0];
		Scanner input = new Scanner (new File("C:/Users/����/Desktop/Myjava/project/source/words.txt"));
		PrintWriter pw = new PrintWriter("C:/Users/����/Desktop/Myjava/project/source/words_copy.txt");
		while(input.hasNext())
		{
			String word = input.nextLine();
			int index = word.indexOf(subString);
			if(index<word.length()&&index>-1)
			{
				pw.print(word);
				pw.println();
			}	
		}
		input.close();
		pw.close();
	}

}
