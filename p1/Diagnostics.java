package p1;

abstract class Diagnostics implements Appointment,Offers
{Radiologists rad[];
 String offername;
  Patient pat[];
  String delivery,tests[],location;
  int notest,nopat,norad;
  Diagnostics(int not,int pats,int nrad,String off)
  {notest=not;
   offername=off;
   tests=new String[not];
   for(int index=0;index<not;index++)
        {tests[index]=new String();
	 }
   nopat=pats;
   pat=new Patient[nopat];
   for(int index=0;index<nopat;index++) 
     {pat[index]=new Patient();
     }
   norad=nrad;
   for(int index=0;index<norad;index++)
    {rad[index]=new Radiologists();
    }
   }
   public void specialisation()
    {System.out.println("specialisations of the centre:");
      for(String val:tests)
	   { System.out.println(val+" ");
           }
     }
    public void location()
    {System.out.println("location:"+location);
    }
    abstract void settests();
     public String getoffer()
     {System.out.println("offer:"+offername);
    	return (offername);
	 
     }
  }