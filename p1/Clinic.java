package p1;
abstract class Clinic implements Appointment
{String workinghours,location;
 int numpat;
 String payment;
 static Doctor list[];
 static int nodoc;
 static Patient patients[];
 Clinic(int nodoc)
  {this.nodoc=nodoc;
   list=new Doctor[nodoc];
   for(int index=0;index<nodoc;index++)
   {list[index]=new Doctor();
   }
  }
  Doctor getref(String name)
  {  int i;
     for(i=0;i<nodoc;i++)
     {if((list[i].dname).equals(name))
              return(list[i]);
     }
   return(null);
 }
  public void location()
  {   System.out.println(location); 
  }
   abstract void setdoctordetails();
   static void setpatdetails(Patient pa)
   {System.out.println("nothing");   
   }
}

