package p1;
import java.util.*;
class Sort_patient implements Comparator<Patient>
{       public int compare(Patient p1,Patient p2)
            {return((p1.disease).compareTo(p2.disease));
           }
}              