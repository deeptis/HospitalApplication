
public class DoctorShift
{
	public Doctor doctor;
	public String date;
	public String s_time;
	public String e_time;
	public DoctorShift(String date, String s_time, String e_time, Doctor doctor)
	{	
		this.date = date;
		
		this.s_time = s_time;
		this.e_time = e_time;
		this.doctor = doctor;
	}
}