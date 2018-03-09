using System;
namespace UgeOpgave
{
    class MenuItemContainer
    {
        private int _count;
        public int Count { get{ return _count; } }
        private MenuItem[] _container;
        public MenuItemContainer()
        {
            _count = 0;
            _container = new MenuItem[10];
        }
        public MenuItem GetMenuItem(int index)
        {
            return _container[index];
        }
        public void AddMenuItem(MenuItem item)
        {
            try
            {
                _container[_count] = item;
                _count++;
            }
            catch (IndexOutOfRangeException)
            {
                IncreaseContainerSize();
                _container[_count] = item;
                _count++;
            }
        }
        private void IncreaseContainerSize()
        {
            int size = _count + 10;
            Array.Resize(ref _container, size);
        }
    }
}