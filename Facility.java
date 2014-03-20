
import java.util.Hashtable;

public class Facility 
{
	public String facilityType;
	public String facilityID;
	public static int FID = 1;
	public static Hashtable facility = new Hashtable();
	public Facility(String facilityType)
	{
		this.facilityType = facilityType;
		facilityID = String.valueOf(++FID);
		facility.put(facilityID,this);
	}
	
}