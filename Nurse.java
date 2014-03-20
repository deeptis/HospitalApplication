
import java.util.HashMap;
import java.util.Vector;

public class Nurse extends Employee
{
	public String nurseID;
	public int licenseNum;
	public Vector attendingNurses = new Vector();
	public static int NID = 0001;
	public static HashMap nurses = new HashMap(); 
	public Nurse(){}
    public Nurse(String firstName, String lastName, String address, String department, String phoneNumber, String email, String password,  int licenseNum)
    {
    	super(firstName, lastName, address, department, phoneNumber, email, password);
    	nurseID = String.valueOf(++NID);
    	this.licenseNum = licenseNum;
    	nurses.put(String.valueOf(licenseNum),this);
    }
    public void attendPatient(){};
}
