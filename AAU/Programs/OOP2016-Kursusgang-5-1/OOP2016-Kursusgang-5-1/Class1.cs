using System;

namespace OOP2016_Kursusgang_5_1
{
    interface IFoo { void FooMethod(); }
    interface IBar { void FooMethod(); }

    public class FooClass : IFoo, IBar
    {
        public void FooMethod()
        {
            Console.WriteLine(this.GetType());
        }

        void IBar.FooMethod()
        {
            Console.WriteLine(this.GetType());
        }
    }
    public class BarClass : IFoo, IBar
    {
        void IFoo.FooMethod()
        {
            Console.WriteLine("Foo: " + this.GetType());
        }

        public void FooMethod()
        {
            Console.WriteLine("Foo: " + this.GetType());
        }
    }

    public class FooBar : IFoo, IBar
    {
        void IFoo.FooMethod()
        {
            Console.WriteLine("FooBar: " + this.GetType());
        }

        void IBar.FooMethod()
        {
            Console.WriteLine("FooBar: " + this.GetType());
        }

        public void FooMethod()
        {
            Console.WriteLine("FooBar: " + this.GetType());
        }
    }
}
