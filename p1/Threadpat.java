package p1;
class Threadpat implements Runnable
{ Doctor ref;
  Threadpat(Doctor refr)
   {  ref=refr;
      Thread t1=new Thread(this);
      t1.start();
   }
  public void run()
  { ref.starttreatment();
  }
}