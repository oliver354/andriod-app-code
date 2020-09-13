package file2;

public class Rectangle extends GeomertricObject{
	private double w;
	private double h;
	public Rectangle(double w, double h){
       //initialization
		this.w=w;
		this.h=h;
	}
	@Override
	public double getArea() {
       //calculate area
	    return w*h;
	}
	public String toString(){
		//return information;
	   return "rectangle,"+w+","+h+","+getArea();
	}
}
