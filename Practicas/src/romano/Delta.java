package romano;
import griego.*;
public class Delta extends Alpha{
    void unMetodoD(Alpha a, Delta d){
       a.x=10;
       d.x=10;
       a.unMetodoA();
       d.unMetodoA();
     }
}