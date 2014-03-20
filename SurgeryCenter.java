
import java.util.Vector;

public class SurgeryCenter extends Facility 
{
	public String surgeryCenterLocation;
	public Vector surgeries = new Vector();
	 public SurgeryCenter(String facilityType, String surgeryCenterLocation)
	    {
	    	super(facilityType);
	    	this.surgeryCenterLocation = surgeryCenterLocation;
	    }
	}