
import java.util.Vector;

public class Pharmacy extends Facility
{
	public String pharmacyLocation;
	public Vector prescriptions = new Vector();
	 public Pharmacy(String facilityType, String pharmacyLocation)
	    {
	    	super(facilityType);
	    	this.pharmacyLocation = pharmacyLocation;
	    }
	}
	



