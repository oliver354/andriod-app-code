package file2;

public abstract class GeomertricObject implements Comparable<GeomertricObject>{
	public abstract double getArea();
	@Override
	public int compareTo(GeomertricObject g) {
		//comparison
		if(getArea()>g.getArea())
		{
			return 1;
		}
		else if(getArea()<g.getArea())
		{
			return -1;
		}
		else 
		{
			return 0;
		}	
	}
}
