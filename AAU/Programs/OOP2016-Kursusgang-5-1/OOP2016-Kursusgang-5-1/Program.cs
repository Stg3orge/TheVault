namespace OOP2016_Kursusgang_5_1
{
    class Program
    {
        static void Main(string[] args)
        {
            FooClass fooClass = new FooClass();
            fooClass.FooMethod();
            ((IFoo)fooClass).FooMethod();
            ((IBar)fooClass).FooMethod();
            BarClass barClass = new BarClass();
            barClass.FooMethod();
            ((IFoo)barClass).FooMethod();
            ((IBar)barClass).FooMethod();
            FooBar foobar = new FooBar();
            foobar.FooMethod();
            ((IFoo)foobar).FooMethod();
            ((IBar)foobar).FooMethod();

            System.Console.ReadKey();
        }
    }
}
