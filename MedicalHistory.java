
import java.util.HashMap;

public class MedicalHistory
{
	public Patient patient;
	//public int patientID;
	public String recordID;
	public static int RID = 01;
	public String description;
	public String date;
	public static HashMap medicalhistory = new HashMap();
	public MedicalHistory(Patient patient, String description, String date)
	{
		this.patient = patient;
		//this.patientID = patientID;
		this.description = description;
		this.date = date;
		recordID = String.valueOf(++RID);
    	medicalhistory.put(recordID,this);
    	patient.history.addElement(this);
	}
	
}