package one;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner input = new Scanner(System.in);
		System.out.print("a:");
		double a = input.nextDouble();
		System.out.print("b:");
		double b = input.nextDouble();
		System.out.print("c:");
		double c = input.nextDouble();
		try {
			Triangle tri = new Triangle(a,b,c);
		}catch(IllegalTriangleException i) {
			i.printStackTrace();
		}
	}

}
