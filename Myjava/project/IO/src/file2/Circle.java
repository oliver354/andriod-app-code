package file2;

public class Circle extends GeomertricObject {
	private double r;
	public Circle(double r){
		//initialization
		this.r=r;
	}
	@Override
	public double getArea() {
        //calculate area
		return r*r*Math.PI;
	}
	public String toString(){
		//return information;
		return "Circle,"+r+","+getArea();
	}
}


