using System;
namespace UgeOpgave
{
    class Program
    {
        static void Main(string[] args)
        {
            Menu();
        }
        static void Menu()
        {
            Console.Title = "Uge Opgave 01";
            Menu mainMenu = new Menu("Main Menu");
            mainMenu.AddMenuItem(new MenuItem("Java", "Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible."));
            mainMenu.AddMenuItem(new MenuItem("C", "C is a general-purpose, imperative computer programming language, supporting structured programming, lexical variable scope and recursion, while a static type system prevents many unintended operations."));
            mainMenu.AddMenuItem(new MenuItem("C++", "C++ is a general-purpose programming language. It has imperative, object-oriented and generic programming features, while also providing facilities for low-level memory manipulation."));
            mainMenu.AddMenuItem(new MenuItem("C#", "C# is a multi-paradigm programming language encompassing strong typing, imperative, declarative, functional, generic, object-oriented (class-based), and component-oriented programming disciplines."));
            mainMenu.AddMenuItem(new MenuItem("Python", "Python is a widely used general-purpose, high-level programming language."));
            mainMenu.AddMenuItem(new MenuItem("PHP", "PHP is a server-side scripting language designed for web development but also used as a general-purpose programming language."));
            mainMenu.AddMenuItem(new MenuItem("Visual Basic .NET", "Visual Basic .NET is a multi-paradigm, low level programming language, implemented on the .NET Framework."));
            mainMenu.AddMenuItem(new MenuItem("Perl", "Perl is a family of high-level, general-purpose, interpreted, dynamic programming languages."));
            mainMenu.AddMenuItem(new MenuItem("JavaScript", "JavaScript is a high-level, dynamic, untyped, and interpreted programming language."));
            mainMenu.AddMenuItem(new MenuItem("Delphi / Object Pascal", "Embarcadero Delphi is an integrated development environment (IDE) for console, desktop graphical, web, and mobile applications."));
            mainMenu.AddMenuItem(new MenuItem("Ruby", "Ruby is a dynamic, reflective, object-oriented, general-purpose programming language."));
            mainMenu.AddMenuItem(new MenuItem("Visual Basic", "Visual Basic is a third-generation event-driven programming language and integrated development environment (IDE) from Microsoft for its COM programming model first released in 1991 and declared legacy in 2008."));
            mainMenu.AddMenuItem(new MenuItem("Assembly Language", "An assembly language is a low-level programming language for a computer, or other programmable device, in which there is a very strong correspondence between the language and the architecture's machine code instructions."));
            mainMenu.AddMenuItem(new MenuItem("Objective-C", "Objective-C is a general-purpose, object-oriented programming language that adds Smalltalk-style messaging to the C programming language."));
            mainMenu.AddMenuItem(new MenuItem("D", "The D programming language is an object-oriented, imperative, multi-paradigm system programming language created by Walter Bright of Digital Mars and released in 2001."));
            mainMenu.Start();
        }
    }
}