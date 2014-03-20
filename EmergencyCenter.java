
public class EmergencyCenter extends Facility
{
	public int patientID;
	public String patientName;
	public int patientPriority;
	public int severity;
	public EmergencyCenter(String facilityType, int patientID, String patientName,
			 int patientPriority, int severity )
	{
		super(facilityType);
		this.patientID = patientID;
		this.patientName = patientName;
		this.patientPriority = patientPriority;
		this.severity = severity;
	}
}