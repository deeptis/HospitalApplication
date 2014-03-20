

import java.util.Vector;

public class InPatient extends Patient {
	public boolean isAdmitted = true;

	public Vector surgery = new Vector();

	public InPatient(int patient_no, int insurancePolicyNumber, String firstName, String lastName,
			 String address, String email,
			String phoneNumber, String password, boolean isAdmitted) {
		
		super(patient_no, insurancePolicyNumber, firstName, lastName, address, phoneNumber, email, password);
		this.isAdmitted = isAdmitted;
	}
}
