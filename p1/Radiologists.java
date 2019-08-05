package p1;
class Radiologists
{  String name,specialisation;
   int age;
   void setradiologists(String nam,int ag,String spec)
   {name=nam;
    age=ag;
    specialisation=spec;
   }
   void getrads()
   {System.out.println("name:"+name+"age:"+age+"specialisation:"+specialisation); 
   }
}