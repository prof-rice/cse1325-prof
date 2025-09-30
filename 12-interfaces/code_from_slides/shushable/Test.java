// From https://coderanch.com/t/635541/java/Pass-ArrayList-Class-Implementing-Interface
import java.util.ArrayList;
 
public class Test
{
    public static void main(String[] args)
    {
        ArrayList<C> alc = new ArrayList<>();
 
        m1(new C());
        m2(alc);     // THIS WORKS NOW
    }
 
    private static void m1(I p)
    {
    }
     
    private static void m2(ArrayList<? extends I> ali)
    {
    }
}
 
interface I
{
}
 
class C implements I
{
}
