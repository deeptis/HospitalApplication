
import java.util.HashMap;
import java.util.Vector;

public class Patient {

	   public static int PID = 0001;
	   public String patientID;
	   public String firstName;
	   public String lastName;
	   public String email;
	   public String passwd;
	   public int patient_no;
	   public String address;
	   public int insurancePolicyNumber;
	   public String phoneNumber; 
	   public Vector appointments = new Vector();
	   public Vector history = new Vector();
	   public Vector prescriptions = new Vector();
	   public Vector labTests = new Vector();
	   public static HashMap patientList = new HashMap(); 
	   public Patient(){}
	   public Patient(int patient_no, int insurancePolicyNumber, String firstName, String lastName,  String address, String phoneNumber, String email, String password)
	   {
	   this.firstName = firstName;
	   this.lastName = lastName;
	   this.email = email;
	   this.address = address;
	   //patientID = String.valueOf(++PID);
	   this.insurancePolicyNumber = insurancePolicyNumber;
	   this.phoneNumber = phoneNumber;
	   this.patient_no = patient_no;
	   this.passwd = password;
	   patientList.put(String.valueOf(patient_no),this);  
	}
}
