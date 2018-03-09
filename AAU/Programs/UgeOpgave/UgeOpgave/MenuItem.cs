using System;
namespace UgeOpgave
{
    class MenuItem
    {
        private string _title;
        public string Title { get { return _title; } }
        private string _content;
        public string Content { get{ return _content; } }
        public MenuItem(string title)
        {
            _title = title;
            _content = "";
        }
        public MenuItem(string title, string content)
        {
            _title = title;
            _content = content;
        }
        public void Print()
        {
            Console.Clear();
            Console.BackgroundColor = ConsoleColor.Black;
            Console.Write("        ");
            Console.WriteLine(_title);
            Console.BackgroundColor = ConsoleColor.DarkBlue;
            Console.WriteLine();
            Console.WriteLine(_content);
            Console.ReadKey();
        }
    }
}