using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ugeopgave1_2
{
    class MenuItemContainer
    {
        public MenuItemContainer(MenuItem[] menuitemArray)
        {
            menuitemArray = new MenuItem[5];
        }

        //private MenuItem[] menuitemArray = new MenuItem[5];

        public int Count { get; private set; }

        public void Add(MenuItem item)
        {
            Console.WriteLine("Please enter title of menu item");
            string _title = Console.ReadLine();

           // Console.WriteLine("Please enter content of menu item");
           // string _content = Console.ReadLine();
        
            item = new MenuItem($"{_title}");

           // return item;
        }

        public MenuItem Get(int index)
        {

        }
    }
}
