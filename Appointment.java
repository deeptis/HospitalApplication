


public class Appointment
{
    public String appointmentDate;
    public String purposeOfVisit;
    public int duration;
    public String time;
    public Doctor doctor;
    public Patient patient;
    //public static HashMap appointments = new HashMap();
    
    public Appointment(Doctor doctor, Patient patient, String appointmentDate,
    		String purposeOfVisit,int duration, String time)
    {
    this.doctor = doctor;
    this.patient = patient;
    this.appointmentDate = appointmentDate;
    this.purposeOfVisit = purposeOfVisit;
    this.time = time;
    this.duration = duration;
    doctor.appointments.addElement(this);
	patient.appointments.addElement(this);
    }
}
