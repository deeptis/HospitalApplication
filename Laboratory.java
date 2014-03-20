
import java.util.Vector;

public class Laboratory extends Facility
{
    public String labLocation;
    public Vector labTests = new Vector();
    public Laboratory(String facilityType, String labLocation)
    {
    	super(facilityType);
    	this.labLocation = labLocation;
    }
}