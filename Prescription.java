
public class Prescription 
{
	public String medicineName;
	public String dosage;
	public int numberOfRefills;
	public String typeOfMedication; 
	public Pharmacy pharmacy;
	public Doctor doctor;
	public Patient patient;
	public Prescription(Pharmacy pharmacy,Doctor doctor,Patient patient, String medicineName,
			String dosage, int numberOfRefills, String typeOfMedication)
	{
		this.doctor = doctor;
		this.patient = patient;
		this.pharmacy = pharmacy;
		this.dosage = dosage;
		this.medicineName = medicineName;
		this.numberOfRefills = numberOfRefills;
		this.typeOfMedication = typeOfMedication;
		pharmacy.prescriptions.addElement(this);
		doctor.prescriptions.addElement(this);
		patient.prescriptions.addElement(this);
	}
}
