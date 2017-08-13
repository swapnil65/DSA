
public class HourMinute {

	
	public static void main(String[] args)
	{
		String time = "12:45";
		String[] splitTime=time.split(":");
		double angle=calculateAngle(Integer.parseInt(splitTime[0]),Integer.parseInt(splitTime[1]));
		System.out.println("Angle when time is "+time+" : "+angle+" deg");
	}
	
	/*
	 * 	Each hour = 30 degrees 
	 *  Each minute = 5 degrees 
	 *  The hour hand also moves 0.5 degrees per minute
	 */
	public static double  calculateAngle(int hh,int mm)
	{
		double angle=Math.abs(hh*30-mm*5.5);
		if(angle>180)
			return 360-angle;
		return angle;
		
	}
	
}
