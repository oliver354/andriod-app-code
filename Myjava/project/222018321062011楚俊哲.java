public class 222018321062011楚俊哲 {
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

	public static void main(String[] args){
		Rectangle a = new Rectangle(4,40);
		Rectangle b = new Rectangle(3.5,35.9);
		System.out.printf("width:%f height:%f Area:%f Rectangle:%f\n",a.getWidth(),a.getheight(),a.getArea(),a.getperimeter());
		System.out.printf("width:%f height:%f Area:%f Rectangle:%f",b.getWidth(),b.getheight(),b.getArea(),b.getperimeter());
		}
}



