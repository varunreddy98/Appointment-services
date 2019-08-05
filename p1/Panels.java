package p1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
public class Panels {
     Panels()
     {JFrame j=new JFrame();
      j.setLayout(new BorderLayout());
      JPanel p=new JPanel(new GridLayout(2,3));
      JPanel p1=new JPanel();
      final JLabel label = new JLabel("<html><a href=\"" + "\"> ->ONLINE RESULTS : B.E IV Semester (Main.),<br>II Semester(Suppli.) Examinations held in May-2018  "
      		+ "</a></html>");
      ImageIcon ic=new ImageIcon("E:\\java\\appointmnent services\\Appointmnent\\bin\\i1.jpg");
      JLabel j1=new JLabel(ic);
      label.addMouseListener(new MouseAdapter() {
          public void mouseEntered(MouseEvent me) {
             label.setCursor(new Cursor(Cursor.HAND_CURSOR));
          }
          public void mouseExited(MouseEvent me) {
             label.setCursor(Cursor.getDefaultCursor());
          }
          public void mouseClicked(MouseEvent me)
          {
             System.out.println("Clicked on Label...");
             try {
            	 String[] cmd = new String[4];
            	 cmd[0] = "cmd.exe";
            	 cmd[1] = "/C";
            	 cmd[2] = "start";
            	 cmd[3] = "http://vceresults.in/results_be_24/default.aspx";
            	 Process p = Runtime.getRuntime().exec(cmd);
               }
               catch(Exception e) {
                  System.out.println(e);
               }
          }
         });
    
        p1.setBackground(Color.WHITE);
      p1.add(label);
      JPanel p2=new JPanel();
      p2.setBackground(Color.YELLOW);
      p2.add(j1);
      JLabel ll=new JLabel("<html>\r\n" + 
      		"\r\n" + 
      		"      <head>\r\n" + 
      		"         <title>HTML marquee Tag</title>\r\n" + 
      		"      </head>\r\n" + 
      		"   	\r\n" + 
      		"      <body>\r\n" + 
      		"         <marquee direction = \"up\">This text will scroll from bottom to up</marquee>\r\n" + 
      		"      </body>\r\n" + 
      		"   	\r\n" + 
      		"   </html>");
      JPanel p3=new JPanel();
      p3.setBackground(Color.ORANGE);
      p3.add(ll);
      JPanel p4=new JPanel();
      p4.setBackground(Color.BLUE);
      JPanel p5=new JPanel();
      p5.setBackground(Color.RED);
      JPanel p6=new JPanel();
      p6.setBackground(Color.GREEN);
      p.add(p1);
      p.add(p2);
      p.add(p3);
      p.add(p4);
      p.add(p5);
      p.add(p6);
      j.setVisible(true);
      j.add(p,BorderLayout.CENTER);
      JPanel p7=new JPanel(new BorderLayout());
      p7.setBackground(Color.CYAN);
      JLabel l1=new JLabel("Vasavi College Of Engineering(Autonomous)");
      l1.setFont(new Font("verdena",Font.ITALIC,50));
      
      p7.add(l1,BorderLayout.NORTH);
      JMenuBar mb=new JMenuBar();
      JMenu m1=new JMenu("DEPARTMENTS");
      m1.add("A");
      m1.add("B");
      mb.add(m1);
      mb.add(new JMenu("Controller of Examinations"));
      mb.add(new JMenu("Staff"));
      mb.add(new JMenu("Placements"));
      p7.add(mb,BorderLayout.SOUTH);
      j.add(p7,BorderLayout.NORTH);
      
     }
     
     public static void main(String...args)
     {Panels pp=new Panels();
    	 
     }
}
