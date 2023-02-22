
public class HoursMinutes {
    private static final int DEGREES_HOUR = 30;
    private static final int DEGREES_MINUTE = 6;
	
	public  static void main(String[] args) {
	 int hour = 8 ;
	 int min = 7 ;
	 
	 double angle = findAngle(hour,min) ;
	 System.out.println(angle);
	 
	
		
	}
	
	
	
	



	private static double findAngle(int hour, int min) {
        double distanceMinutesHand = min * DEGREES_MINUTE; 
        double distanceHoursHand = (min  * DEGREES_HOUR)/60.0;
        int x = getHoursDifference(hour);
        double distanceAlreadyCoveredByHoursHand = (x * 360) / 12.0 ; 
        double totalDistance = distanceHoursHand + distanceAlreadyCoveredByHoursHand ;
        double angle = Math.abs(distanceMinutesHand - Math.abs(totalDistance));
		
        if(angle > 180)
            angle = 360-angle;
		return Math.abs(angle);
	}







	private static int getHoursDifference(int hour) {
		if(hour == 12)
		return 0;
		else
			return hour;
	}
}
