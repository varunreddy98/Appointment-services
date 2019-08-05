package p1;
import java.util.Date;
import java.util.Timer;
class Rainbow extends Clinic
{ static int count=0;
  static Doctor list[]=new Doctor[3];
  Timer time; 
  public static Rainbow ref; 
  static Rainbow getrainbow()
   { if(ref==null)
     {ref=new Rainbow();
      return(ref);
     }
    else
      return(ref);
   }
  static int id=111;	
  private Rainbow()
   {super(3);
    ref=null;
    numpat=50;
    patients=new Patient[50];
    for(int i=0;i<3;i++)
    	list[i]=new Doctor();
    time=new Timer();
   }
  void setdoctordetails()
  {String t[]={"sunady","monday"};
   list[0].setdoctor("varun","pediatrician","04:00","06:00",4,t);
   t[0]="tuesday";
   t[1]="saturday";
   list[1].setdoctor("arjun","cardiologist","06:00","08:00",8,t);
   t[0]="thursday";
   t[1]="friday";
   list[2].setdoctor("reddy","physician","08:00","10:00",9,t);
  }
  public static void setpatdetails(Patient pa)
 { patients[count++]=pa;
  }
  public void serialize_patients()
  {
	  time.schedule(new RemainderTask(patients,"rainbow.txt"),get12am(),1000*60*60*24);
  }
  
@SuppressWarnings("deprecation")
private Date get12am() {
	// TODO Auto-generated method stub

    Date date= new Date(); 
       date.setHours(24); 
       date.setMinutes(0); 

       return date;
}
public void specialisation()
   {    System.out.println("clinic jubilehills has:");
	 for(int index=0;index<nodoc;index++)
	   {list[index].getdoctor();
           }
   }
    public void method_of_payment()
    {   System.out.println("time of visit");
    }
    public void branches()
    {System.out.println(" branches of Rainbow clinic are *dilshuknagar  *banjarahills *mehedipatnam");
    } 
}
