package one;

public class Triangle {
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle()
	{
		side1=0;
		side2=0;
		side3=0;
	}
	public Triangle(double a,double b,double c) throws IllegalTriangleException
	{
		if(a+b>c&&a+c>b&&b+c>a)
		{
		side1=a;
		side2=b;
		side3=c;
		}
		else {
			String message = "";
			if(a+b<=c)
			{
				message="a+b<=c";
			}
			if(a+c<=b)
			{
				message="a+c<=b";
			}
			if(b+c<=a)
			{
				message="b+c<=a";
			}
			throw new IllegalTriangleException(message);
		}

	}
}
