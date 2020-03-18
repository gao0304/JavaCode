public class Simple {
    private void method1(){

    }
}
interface Animal {
    void run ();
    void breather();
}
class Fish implements Animal
{
    public void run ()
    {
        System.out.println("fish is swimming");
    }
    public void breather()
    {
        System.out.println("fish is bubbing");
    }
}