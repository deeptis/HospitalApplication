
import java.util.Vector;

	public class Hospital 
	{
		public String hospitalName;
		public String hospitalLocation;
		public Vector buildings = new Vector();
	    public Vector facilities = new Vector();
	    public Vector employees = new Vector();
	    public Hospital(String hospitalName,String hospitalLocation)
	    {
	    	this.hospitalName = hospitalName;
	    	this.hospitalLocation = hospitalLocation;
	    }
	}
