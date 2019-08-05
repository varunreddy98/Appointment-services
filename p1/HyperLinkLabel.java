package p1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
  
public class HyperLinkLabel extends JFrame
{
  
  public HyperLinkLabel()
  {
    JPanel p = new JPanel();
    final String strURL = "http://www.google.com";
    final JLabel label = new JLabel("<html><a href=\" " + strURL + "\"> click </a></html>");
  
    final JEditorPane htmlPane = new JEditorPane();
  
 
    p.add(label);
  
    getContentPane().add(BorderLayout.NORTH, p);
    getContentPane().add(BorderLayout.CENTER, new JScrollPane(htmlPane));
    setBounds(20,200, 500,500);
  
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
        	  cmd[3] = "http://www.google.com";
        	  Process p = Runtime.getRuntime().exec(cmd);
            }
            catch(Exception e) {
               System.out.println(e);
            }
       }
      });
  
  }
  
 
  
  public static void main(String[] args)
  {
    HyperLinkLabel hll = new HyperLinkLabel();
    hll.show();
  }
}


 