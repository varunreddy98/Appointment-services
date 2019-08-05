package p1;
import java.util.ArrayList;
import java.util.*;
class Doctor
{  String[] days;
Patient patients_doc[]=new Patient[20];
   static LinkedList<Doctor> ll=new LinkedList<Doctor> ();
   String dname;
   int count=0;
   int cap=2;
   static int docount=0;
   String specialisation;
   int experience;
   String start_timings,end_timings;
   boolean docavailable(Patient pt)
    {if(count<cap)
        {patients_doc[count++]=pt;
    	 return(true);
         }
     return(false);
    }
   @SuppressWarnings({ "unchecked" })
   Doctor()
   {ll.add(this);   
    docount++;
   }
public void share_diseasedata()
   {  
 	   @SuppressWarnings("unused")
 	ArrayList<Patient> tlist=new ArrayList<Patient>();
 	for(int i=0;i<count;i++)
 	{tlist.add(patients_doc[i]);
 	}
 	Sort_patient comparator=new Sort_patient();
 	Collections.sort(tlist,comparator);
 	ArrayList<Patient>[] diag=new ArrayList[3];
 	for(Patient p:tlist)
 	{if((p.disease).equals("fever"))
 	   diag[0].add(p);
 	else
 	  if((p.disease).equals("stomachache"))
 		  diag[1].add(p);
 	else
 	  if((p.disease).equals("cold"))
 		  diag[2].add(p);
 	} 
 	HashMap<String,ArrayList<Patient>> ref=new HashMap<String,ArrayList<Patient>> ();
 	ref.put("fever",diag[0]);
 	ref.put("stomachache",diag[1]);
 	ref.put("cold",diag[2]);
 	Springs.doctorsug_diag(this,ref);
   }
 	
  void starttreatment()
   { for(int i=0;i<cap;i++)
       {Thread_treatment tr=new Thread_treatment(patients_doc[i]);
         try{tr.t.join();
            }
         catch(InterruptedException e)
         {
        	 System.out.println(e);
         }
      }
  } 
   void setdoctor(String name,String special,String time,String time1,int exp,String s[])
    {   dname=name;
        specialisation=special;
        start_timings=time;
        end_timings=time1;
	experience=exp;
	days=s;
    }
   void getdoctor()
   {  System.out.println("doctor name:"+dname+"Specialisation:"+specialisation+"experience:"+experience+"timings:"+start_timings+"   ");
   }
}