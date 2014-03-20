
public class LabTest 
{
    //public int patientID;
    public String type;
    public String date;
    public String time;
    public Laboratory lab;
    public Patient patient;
    public Doctor doctor;
    public LabTest(Doctor doctor, Patient patient, Laboratory lab,
    		 String type, String date, String time)
    {
	    this.doctor = doctor;
	    this.patient = patient;
	    this.lab = lab;
	    //this.patientID = patientID;
	    this.time = time;
	    this.date = date;
	    this.type = type;
	    lab.labTests.addElement(this);
		patient.labTests.addElement(this);
		doctor.labTests.addElement(this);
    }
}