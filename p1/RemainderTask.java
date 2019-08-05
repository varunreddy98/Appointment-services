package p1;
import java.io.FileOutputStream;
import java.io.*;
import java.io.ObjectOutputStream;
import java.util.TimerTask;
class RemainderTask extends TimerTask{
	Patient patients[];
	File f;
	RemainderTask(Patient pats[],String filename)
	{patients=pats;
	 f=new File(filename);
	}
    public void run()
    {   try{FileOutputStream fr=new FileOutputStream(f);
		    ObjectOutputStream os=new ObjectOutputStream(fr);
		    for(Patient tempat:patients)
		    {os.writeObject(tempat);
	     	}
		    os.flush();
		      os.close();
	       } catch (IOException e) {
		// TODO Auto-generated catch block
	     	  e.printStackTrace();
	        }
    }
  }