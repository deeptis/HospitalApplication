
import java.util.HashMap;
import java.util.Vector;

public class Doctor extends Employee
{
	public String doctorID;
	public int licenseNum;
	public static int DID = 0001;
	public Vector appointments = new Vector();
	public Vector labTests = new Vector();
	public Vector attendingDoctors = new Vector();
	public Vector prescriptions = new Vector();
	public static HashMap doctors = new HashMap(); 
	public Doctor(){}
    public Doctor(String firstName, String lastName, String address, String department, String phoneNumber, String email, String password, int licenseNum)
    {
    	super(firstName, lastName, address, department, phoneNumber, email, password);
    	doctorID = String.valueOf(++DID);
    	this.licenseNum = licenseNum;
    	doctors.put(doctorID,this);
    }
}
