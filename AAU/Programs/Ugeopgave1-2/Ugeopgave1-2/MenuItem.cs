using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ugeopgave1_2
{
    class MenuItem
    {
        public string title { get; }
        public string content { get; }


        public MenuItem(string title)
        {

        }

        public MenuItem(string title, string content) :this(title) // Second cons calling 1st
        {

        }

        public void Select(string _title, string _content)
        {
            _title = title;
            _content = content;

            Console.WriteLine($"_title");
            Console.WriteLine($"_content");

            Console.WriteLine("Press any key to return to menu");
            Console.ReadKey();
        }

    }
}
