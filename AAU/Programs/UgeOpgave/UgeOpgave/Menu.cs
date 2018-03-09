using System;
namespace UgeOpgave
{
    class Menu
    {
        private string _title;
        public string Title { get { return _title; } set { _title = value; } }
        private bool _running;
        private int _currentMenuItem;
        MenuItemContainer _container;
        public Menu(string title)
        {
            _title = title;
            _running = false;
            _currentMenuItem = 0;
            _container = new MenuItemContainer();
        }
        public void AddMenuItem(MenuItem item)
        {
            _container.AddMenuItem(item);
        }
        public void Start()
        {
            _running = true;
            do
            {
                DrawMenu();
                HandleInput();
            } while (_running);
        }
        private void DrawMenu()
        {
            Console.BackgroundColor = ConsoleColor.DarkBlue;
            Console.Clear();
            Console.BackgroundColor = ConsoleColor.Black;
            Console.Write("        ");
            Console.WriteLine(_title);
            Console.BackgroundColor = ConsoleColor.DarkBlue;
            Console.WriteLine();
            for (int i = 0; i < _container.Count; i++)
            {
                if (i == _currentMenuItem)
                {
                    Console.BackgroundColor = ConsoleColor.White;
                    Console.ForegroundColor = ConsoleColor.Black;
                    Console.Write("  ");
                    Console.WriteLine(GetCurrentTitle(i));
                    Console.BackgroundColor = ConsoleColor.DarkBlue;
                    Console.ForegroundColor = ConsoleColor.White;
                }
                else
                {
                    Console.Write("  ");
                    Console.WriteLine(GetCurrentTitle(i));
                }
            }
        }
        private string GetCurrentTitle(int index)
        {
            MenuItem current = _container.GetMenuItem(index);
            return current.Title;
        }
        private void PrintCurrentContent(int index)
        {
            MenuItem current = _container.GetMenuItem(index);
            current.Print();
        }
        private void HandleInput()
        {
            ConsoleKeyInfo cki = Console.ReadKey();
            switch (cki.Key)
            {
                case ConsoleKey.Backspace:
                case ConsoleKey.Escape:
                    _running = false;
                    break;
                case ConsoleKey.UpArrow:
                    MoveUp();
                    break;
                case ConsoleKey.DownArrow:
                    MoveDown();
                    break;
                case ConsoleKey.Enter:
                    PrintCurrentContent(_currentMenuItem);
                    break;
                default:
                    break;
            }
        }
        private void MoveUp()
        {
            if (_currentMenuItem > 0)
            {
                _currentMenuItem = _currentMenuItem - 1;
            }
        }
        private void MoveDown()
        {
            if (_currentMenuItem < _container.Count - 1)
            {
                _currentMenuItem = _currentMenuItem + 1;
            }
        }
    }
}