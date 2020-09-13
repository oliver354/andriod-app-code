package test2;
import java.util.GregorianCalendar;
public class myData {
	private int day;
	private int month;
	private int year;
	
	public myData()
	{
		GregorianCalendar calendar=new GregorianCalendar();
		day=calendar.get(GregorianCalendar.DAY_OF_MONTH);
		month=calendar.get(GregorianCalendar.MONTH);
		year=calendar.get(GregorianCalendar.YEAR);
	}
	 public myData(long lostTime)
	    {
	        GregorianCalendar gregorian = new  GregorianCalendar();
	        gregorian.setTimeInMillis(lostTime);//Sets this Calendar's current time from the given long value.
	        year = (int)gregorian.get(GregorianCalendar.YEAR);
	        month = (int)gregorian.get(GregorianCalendar.MONTH);
	        day = (int)gregorian.get(GregorianCalendar.DAY_OF_MONTH);
	    }
	public String getmyData()
	{
		return year+"-"+month+"-"+day;
	}

}
