package lzx;

public class Rectangle {
	private double width;
	private double height;
	
	Rectangle()
	{
		width=1;
		height=1;
	}
	Rectangle(double i,double j)
	{
		width = i;
		height = j;
	}
	public double getWidth()
	{
		return width;
	}
	public double getheight()
	{
		return height;
	}
	
	public double getArea()
	{
		return width*height;
	}
	public double getperimeter()
	{
		return 2*(width+height);
	}

}


