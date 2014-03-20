
import java.util.HashMap;
import java.util.Vector;

public class Surgery
{
	public static int OID = 0001;
	public String operationID;
	public Patient patient;
	public Nurse nurse;
	public Doctor doctor;
	public int roomNo;
	public String comments;
	public String date;
    public String time;
    public String surgeryType;
	public SurgeryCenter surgeryCenter;
	public InPatient inpatient;
	
	public static Vector attendingDoctors = new Vector();
	public static Vector attendingNurses = new Vector();
	public static HashMap surgeries = new HashMap();
	
	public Surgery(Patient P, Nurse N, Doctor D, int roomNo, String comments, String date, String time)
	{
		operationID = String.valueOf(++OID);
        this.patient = P;
        this.nurse = N;
        this.doctor = D;
		this.roomNo = roomNo;
		this.comments = comments;
		this.date = date;
		this.time = time;
		//surgeryCenter.surgeries.addElement(this);
		//inpatient.surgery.addElement(this);
		surgeries.put(String.valueOf(operationID), this);
		//attendingNurses.addElement(arg0)
		AttendingNurse an = new AttendingNurse(N, this);
		attendingNurses.addElement(an);
		AttendingDoctor ad = new AttendingDoctor(this, D);
		attendingDoctors.addElement(ad);
		
	}
}