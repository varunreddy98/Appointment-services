package p1;
import java.util.*;
import java.io.*;
class Patient implements Serializable
{ String pname,phno,docname;
  String appstatus,disease;
  Date date;
  Doctor docref;
  Clinic cref;
  String test;
  int age;
  int tokeno;
  String gender;
  void settest(String tst)
    {test=tst;
    }
  @SuppressWarnings("static-access")
void getappointment()
  {if(docref.docavailable(this))
      {appstatus="booked";
       cref.setpatdetails(this);
      }
    else
       appstatus="not booked";
  
  }
  @SuppressWarnings({ "rawtypes", "deprecation" })
void set(String nam,String ph,int age1,String gender1,String disease,Rainbow clinic,String docnam) throws ClassNotFoundException, InstantiationException, IllegalAccessException
       { pname=nam;
         this.disease=disease;
         docname=docnam;
         phno=ph;
         age=age1;
         gender=gender1;
		cref=clinic;
		docref=cref.getref(docnam);
       }
  public String toString()
   {  return("name:"+pname+" age:"+age+" gender:"+gender+" phn no:"+phno+"token:"+tokeno+" disease:"+disease+" date:"+date+" doctor name:"+docref.dname);
   }
  void getdoc()
  {System.out.println(docname);
  } 
  void gettest()
  {System.out.println(test); 
  }
public void setdate(Date d1) {
	// TODO Auto-generated method stub
	date=d1;
	
}
}
