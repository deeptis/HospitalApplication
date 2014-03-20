
import java.util.Vector;


public class Building
{

  public int build_no;
  public String build_add;
  public Vector departments = new Vector();

  public Building(int build_no,String build_add)
  {
          this.build_no = build_no;
          this.build_add = build_add;

  }
}
