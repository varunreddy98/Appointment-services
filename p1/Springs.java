package p1;
import java.util.*;

class Springs extends Diagnostics
{ static int count=0,suggestion=0;
  static TreeMap<Doctor,HashMap<String,ArrayList<Patient>>> tmp;
  static Doctor d1[]=new Doctor[1];
  String loc; 
  public static Springs ref;
  static Springs getsprings()
  { if(ref==null)
       {ref=new Springs(20);
        return(ref);
       }
    else
      return(ref);
  }
   private Springs(int pats)
   {  super(4,pats,2,"republic checkup");
       ref=null;
      tmp=new TreeMap<Doctor,HashMap<String,ArrayList<Patient>>> ();
   }
public void setpatdetails(Patient pa)
   {pat[count++]=pa;
   }
   void setradiologists()
    { rad[0].setradiologists("ravi",30,"blood test");
	rad[1].setradiologists("anjali",25,"blood pressure");
    }
   void settests()
   {  tests[0]="ecg";
	 tests[1]="Xray";
	 tests[2]="endoscope";
	 tests[3]="blood sugar";
   }
   public void specialisation()
   { System.out.println("specialisations of Springs diagnostics:");
     for(String val:tests)
	  {  System.out.println(val+" ");
	  }
   }
   public void location()
   {System.out.println("location:"+loc); 
   }
   public void method_of_payment()
   {System.out.println("1.cash 2.debit 3.credit");
   }
   public void branches()
   {	System.out.println("branches of springs:*mehedipatnam *abids");
   }
public static void doctorsug_diag(Doctor doctor, HashMap<String,ArrayList<Patient>> ref2) {
      tmp.put(doctor,ref2);
	}
	}


