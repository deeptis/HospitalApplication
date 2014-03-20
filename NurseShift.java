
public class NurseShift
{
	public Nurse nurse;
	public String date;
	public String s_time;
	public String e_time;
	public NurseShift(String date, String s_time, String e_time, Nurse nurse)
	{	
		this.date = date;
		
		this.s_time = s_time;
		this.e_time = e_time;
		this.nurse = nurse;
	}
}
