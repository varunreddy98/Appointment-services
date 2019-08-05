package p1;
import java.io.*;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.*;
public class Jframe implements ActionListener{
 	String str;
 	static JButton bd;
 	static Person pa;
 	static boolean check=true;
 	static JLabel j2;
 	static JLabel j3=new JLabel();
 	static Person p[]=new Person[10];
 	static Person cp=null;
 	static int c=0,dc=0;
 	static JPanel p1,jpp,j1,j5,pll;
 	static JTextField mail;
 	static JPasswordField pass;
 	static JFrame j=new JFrame("varun's blog");
 	static JTabbedPane jp=new JTabbedPane();
 	static
 	{   
 		j.setVisible(true);
 		j.add(jp);
 		
 	}
 	Jframe()
 	{

 	}
 	Jframe(int n)
 	{   
 		p1=new JPanel(new BorderLayout());
 		p1.setBackground(Color.BLUE);
 		new Entry1(p1,pass,mail,j2);
 		p1.add(j2);
 		jp.add(p1);
 		//jp.add(p2);

 		j.addWindowListener(new WindowAdapter() {
 		   public void windowClosing(WindowEvent evt) {
 			     try {
					onExit();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			   }
		});
 	}
 	public void onExit() throws IOException
 	{
		FileOutputStream fo=new FileOutputStream("E:\\java\\appointmnent services\\Appointmnent\\appt.txt");
		ObjectOutputStream oj=new ObjectOutputStream(fo);
		for(int i=0;i<Jframe.c;i++)
		{   //Jframedemo.p[i].display();
		     System.out.println(p[i]);
			oj.writeObject(Jframe.p[i]);
		}
		oj.flush();
		oj.close();
 	 System.out.println("closed");
 	 System.exit(0);
 	}
 	public void actionPerformed(ActionEvent e) {
 		int indc=0;
 		str=e.getActionCommand();
 		if(str.equals("Login"))
 		{   String em=mail.getText();
 			String pa;
 			pa=pass.getText();
 			System.out.println(em+" "+pa);
 			//System.out.println(p[0]);
 			if(c!=0) {
 				for(int i=0;i<c;i++)
 				{if((p[i].email).equals(em)&&(p[i].password).equals(pa))
 					      {indc=1;
 					        cp=p[i];
 					        break;
 					      }
 				  // System.out.println(p[i]+" "+indc);
 				} 				if(indc==1) { 
 					jpp=new JPanel(new GridLayout(1,3));
 					Gui l=new Gui(jpp);
 					jp.remove(p1);
 					jp.add(jpp);
 				}
 			else
				{j2.setText("Invalid Email or Password");
				}
 			}

 		}
 		if(str.equals("Create account"))
 		{ JPanel aa=new JPanel(new GridBagLayout());
 		Createacc p=new Createacc(aa,jp,bd);
 		jp.remove(p1);
 		jp.add(aa);
 		//while(p.check()==0);
 		}
 	}
 	// TODO Auto-generated method stub
 	public static void main(String args[]) throws IOException, ClassNotFoundException,FileNotFoundException, InterruptedException
 	{   File f=new File("E:\\java\\appointmnent services\\Appointmnent\\appt.txt");
 		FileInputStream oi=new FileInputStream(f);
 		ObjectInputStream os = null;
 		try{os=new ObjectInputStream(oi);
 		Person pp=null;
 		while((pp=(Person) os.readObject())!=null) {
 		System.out.println(pp);
 		Jframe.p[Jframe.c++]=pp;	
 		}
 		os.close();
 		}
 		catch(EOFException e)
 		{
 			System.out.println(e);
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}
 		Jframe d=new Jframe(1);
 		
 	}

 	public static void createPanel()
 	{p[c++]=pa;
 	  //System.out.println(p[c-1].email);
 	 p1=new JPanel();
 	Entry1 e=new Entry1(p1,pass,mail,j2);
 	jp.add(p1);
 	
 	}
}
class Gui implements ItemListener,ActionListener
{   JTable tb;
    static Rainbow ref;
    static JPanel tp;
    static JPanel p1;
    int avail[]= {0,0,0};
    JTextField jt;
    DefaultTableModel def;
    String doc;
    JLabel jj;
    String[] col= {"Dr name","specialisation","Date","timings","availability"};
    JPanel p2;
	 Gui(JPanel pp)
	 {   
		 p1=new JPanel();
	     int cout=0;
	     ref=Rainbow.getrainbow();
	     ref.setdoctordetails();
		 String str[]= {"Rainbow","",""}; 
	      JComboBox jb=new JComboBox(str);
	      p1.add(jb);
	      //p2=new JPanel();
	      String data[][]=new String[Rainbow.nodoc][5];
	      for(int i=0;i<Rainbow.nodoc;i++)
	      {for(int j=0;j<5;j++)
	         {
	    	      data[i][j]="";
	         }
	      } 
	     def= new DefaultTableModel(data,col);
	     tb=new JTable(def);
	     tb.getTableHeader().setToolTipText("Table Header!");
        p1.add(new JScrollPane(tb));
        JPanel p3=new JPanel();
	     JLabel llb=new JLabel("Doctor name:");
	     jt=new JTextField(15);
	     p3.add(llb);
	     p3.add(jt);
	     JButton btt=new JButton("Submit");
	     jj=new JLabel();
	     p1.add(btt);
	     p1.add(jj);
	     p1.add(p3);
	     ImageIcon ic=new ImageIcon("E:\\java\\appointmnent services\\Appointmnent\\src\\images.jpg");
	     btt.addActionListener(this);
	     jt.addActionListener(this);
	     jb.addItemListener(this);
	     //Image newimg = (ic).getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
	     JLabel ll=new JLabel(ic);
	     ll.setSize(25,25);
	     p1.add(ll);
	     pp.add(p1);
	     //ppl.add(p2);
	     //ppl.add(p3);
	 }
@Override
public void itemStateChanged(ItemEvent e1) {
	// TODO Auto-generated method stub 
	if(e1.getStateChange() == ItemEvent.SELECTED) {
        doc=(String)e1.getItem();
    if(doc.equals("Rainbow"))
    {
    String datas[][]=new String[Rainbow.nodoc][5];
	for(int i=0;i<Rainbow.nodoc;i++)
	{for(int j=0;j<5;j++)
	        {
               datas[i][j]="--";		
	        }
		
	}
	int i=0,count=0,check=0;
	String str[]=new String[7];
	Calendar calendar = Calendar.getInstance();
	int day = calendar.get(Calendar.DAY_OF_WEEK); 
	switch (day) {
    case Calendar.SUNDAY:
              str[count++]="sunday";
              break;
    case Calendar.MONDAY:
             str[count++]="monday";
             break;
    case Calendar.TUESDAY:
    	    str[count++]="tuesday";
    	    break;
    case Calendar.WEDNESDAY:
    	    str[count++]="wednesday";
    	    break;
    case Calendar.THURSDAY:
    	   str[count++]="thursday";
    	   break;
    case Calendar.FRIDAY:
    	   str[count++]="friday";
    	   break;
    case Calendar.SATURDAY:
    	   str[count++]="saturday";
    	   break;
}
	
	SimpleDateFormat os=new SimpleDateFormat("dd.MM.yyyy");
	for(i=0;i<Rainbow.nodoc;i++) 
	{
	         {datas[i][0]=Rainbow.list[i].dname;
	         datas[i][1]=Rainbow.list[i].specialisation;
	         datas[i][2]=os.format(Calendar.getInstance().getTime());
	         datas[i][3]=Rainbow.list[i].start_timings+"--"+Rainbow.list[i].end_timings;
	         String sts[]=Rainbow.list[i].days;
	         for(String m1:sts)
	         { for(String m2:str)
	                {  if(m1.equals(m2))
	                	  {check++;
	                       break;
	                	  }
	        	 
	                }
	        	 
	         }
	         if(check==0&&Rainbow.list[i].cap<=2) {
	             datas[i][4]="available";
	             avail[i]=1;
	         }
	         else
	        	datas[i][4]="not available";
	        
		
	         }
		
	}
     for(int i1=0;i1<Rainbow.nodoc;i1++)
      {for(int j=0;j<5;j++)
           {
   	       def.setValueAt(datas[i1][j],i1,j);
   	     }
	
      }
   }
 }	 
 }

 public void actionPerformed(ActionEvent e)
 {  int tar=1;
	  String dd=jt.getText();
     for(int i=0;i<Rainbow.nodoc;i++)
     {if(dd.equals(Rainbow.list[i].dname)&&avail[i]==1)
              {  
                   tar=0;
              }
       else
          if(dd.equals(Rainbow.list[i].dname))
        {  tar++;
         }
    	 
     }
     
     if(tar==2)
     {
    	 jj.setText("no more appointments for this doctor");
    	  
     }
     if(tar==1)
     {jj.setText("some fields are empty");
    	 
     }
     if(tar==0)
     {JPanel q=new JPanel();
       Pat p=new Pat(q);
       Jframe.jp.add(q);
      Jframe.jp.remove(p1);
     }
 }
 

}
class Pat extends JPanel implements ActionListener
{  JTextField t[];
int count=0;
JLabel ll=new JLabel();
JPanel panel1,jp1;
JButton bd;
Pat(JPanel pp)
{   JLabel l[]=new JLabel[7];
    t=new JTextField[7];
    panel1=pp;
l[0]=new JLabel("Name:");
l[1]=new JLabel("doctor name");
l[2]=new JLabel("email id");
l[3]=new JLabel("phno");
l[4]=new JLabel("age");
l[5]=new JLabel("Gender");
l[6]=new JLabel("disease");
t[0]=new JTextField(15);
t[1]=new JTextField(15);
t[2]=new JTextField(20);
t[3]=new JTextField(15);
t[4]=new JTextField(20);
t[5]=new JTextField(20);
t[6]=new JTextField(15);
GridBagConstraints c = new GridBagConstraints();
int a,b=0;
for(int i=0;i<7;i++)
{   c.gridx=b;
c.gridy=i;
pp.add(l[i],c);
c.gridx=b+1;
c.gridy=i;
pp.add(t[i],c);

}
JButton bb=new JButton("submit");
pp.add(bb);
pp.add(ll);
for(int i=0;i<7;i++)
{
	t[i].addActionListener(this);
}
   bb.addActionListener(this);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	 int c=0;
	String s[]=new String[7];
	String str1=e.getActionCommand();
	if(str1.equals("submit"))
	{   for(int i=0;i<7;i++)
		{String str=t[i].getText();
		s[i]=str;
		if(str.equals(""))
			c++;
		}

		if(c>=0)
		{ll.setText("some fields are empty");
		}
		if(c==0)
		{Patient p=new Patient();
		try {
			p.set(s[0],s[3],Integer.parseInt(s[4]),s[5],s[6],Gui.ref,s[1]);
			Jframe.p[Jframe.c].pt=p;
		} catch (NumberFormatException | ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ll.setText("");
		p.getappointment();
		JLabel l1=new JLabel("Appointment created Successfully");
		jp1.add(l1);
		}
	}
	
} 
}
class Person implements Serializable 
{ String fname,lname,email,password,ph;
boolean exist=false;
Patient pt;
String list[]=new String[5];
Person(String fnam,String lnam,String mail,String pass,String phn)
{ fname=fnam;
 pt=new Patient();
lname=lnam;
email=mail;
password=pass;
exist=true;
ph=phn;
}
Person()
{
	
}
public String toString()
{
   
	return(fname+lname+email+password+ph);  

}


 void display()
 {
	  System.out.println("name"+fname+"phn"+ph);
 }
}

class Diag extends JPanel
{    Diag(JPanel p)
	 {
	
	 }
	
}
class Entry1 extends JPanel
{   
	Entry1(JPanel p1,JTextField pass,JTextField mail,JLabel j2){
	JPanel pp=new JPanel();
	//p1.setBackground(Color.YELLOW);
	JLabel ma=new JLabel("Mail id");
	Jframe.mail=new JTextField(10); 
	JLabel pa=new JLabel("Password");
	Jframe.pass=new JPasswordField(10);
	JLabel ll=new JLabel("Login as:");
	JComboBox jb=new JComboBox();
	jb.addItem("Patient");
	jb.addItem("Doctor");
	jb.addItem("Clinic");
	JButton b1=new JButton("Login");
	
	JButton b2=new JButton("Create account");
	Jframe.j2=new JLabel(); 
	pp.add(ma);
	pp.add(Jframe.mail);
	pp.add(pa);
	pp.add(Jframe.pass);
	pp.add(ll);
	pp.add(jb);
	pp.add(b1);
	pp.add(b2);
	pp.add(Jframe.j2);
	pp.setSize(new Dimension(500,500));
	pp.setBackground(Color.YELLOW);
	p1.add(pp,BorderLayout.NORTH);
	Jframe.mail.addActionListener(new Jframe());
	Jframe.pass.addActionListener(new Jframe());
	b1.addActionListener(new Jframe());
	b2.addActionListener(new Jframe());
	// bd.addActionListener(this);

}
}

class Createacc extends JPanel implements ActionListener
{   JTextField t[];
int count=0;
JLabel ll=new JLabel();
JTabbedPane pp1;
JPanel panel1,jp1;
JButton bd;
Createacc(JPanel j,JTabbedPane j1,JButton bd)
{   JLabel l[]=new JLabel[6];
t=new JTextField[6];
panel1=j;
this.bd=bd;
pp1=j1;
l[0]=new JLabel("First name:");
l[1]=new JLabel("last name");
l[2]=new JLabel("email id");
l[3]=new JLabel("password");
l[4]=new JLabel("confirm password");
l[5]=new JLabel("phno");
t[0]=new JTextField(15);
t[1]=new JTextField(15);
t[2]=new JTextField(20);
t[3]=new JTextField(15);
t[4]=new JTextField(15);
t[5]=new JTextField(15);
GridBagConstraints c = new GridBagConstraints();
int a,b=0;
for(int i=0;i<6;i++)
{   c.gridx=b;
c.gridy=i;
j.add(l[i],c);
c.gridx=b+1;
c.gridy=i;
j.add(t[i],c);

}
JButton bb=new JButton("submit");
j.add(bb);
j.add(ll);
for(int i=0;i<6;i++)
{
	t[i].addActionListener(this);
}
bb.addActionListener(this);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	 int c=0;
	String s[]=new String[6];
	String str1=e.getActionCommand();
	if(str1.equals("submit"))
	{     String strr= "^[a-zA-Z0-9_+&*-]+(?:\\."+
           "[a-zA-Z0-9_+&*-]+)*@" +
           "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
           "A-Z]{2,7}$";
	     /* Pattern pat=Pattern.compile(strr);
        if(!pat.matcher(s[2]).matches())
        {ll.setText("invalid email address");
         c=-9;
        }*/
		for(int i=0;i<6;i++)
		{String str=t[i].getText();
		s[i]=str;
		if(str.equals(""))
			c++;
		}

		if(c>=0)
		{ll.setText("some fields are empty");
		}

		if(c==0)
		{Jframe.pa=new Person(s[0],s[1],s[2],s[3],s[5]);
		ll.setText("");
		jp1=new JPanel(new GridBagLayout());
		GridBagConstraints cc=new GridBagConstraints();
		cc.gridx=0;
		cc.gridy=0;
		JLabel l1=new JLabel("Account created Successfully");
		JLabel jl=new JLabel("click here to login");
		bd=new JButton("Login here");
		jp1.add(l1,cc);
		cc.gridx=1;
		cc.gridy=0;
		jp1.add(jl,cc);
		jp1.add(bd);
		pp1.remove(panel1);
		pp1.add(jp1);
		bd.addActionListener(this);
		}
	}
	if(str1.equals("Login here"))
	{   pp1.remove(jp1);
	    Jframe.createPanel();
	    
	}
} 
}