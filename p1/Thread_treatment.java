package p1;
import java.util.*;
public class Thread_treatment implements Runnable
{Patient pt;
 Thread t;
  Thread_treatment(Patient pt)
  {this.pt=pt;
    t=new Thread(this);
    t.start();
  }
public void run() {
   try {
	System.out.println("patient is being treated");
	pt.setdate(new Date());
	Thread.sleep(10000);
} catch (InterruptedException e) {
	e.printStackTrace();
}	
	
}

}
