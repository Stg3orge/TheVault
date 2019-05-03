using System;
using System.Collections.Generic;

namespace DNDNew.Models
{
    public partial class Item
    {
        public int Id { get; set; }
        public int? InventoryId { get; set; }
        public string Name { get; set; }
        public decimal Weight { get; set; }
        public bool Equipped { get; set; }

        public virtual Inventory Inventory { get; set; }
        public virtual Armor Armor { get; set; }
        public virtual Potion Potion { get; set; }
        public virtual Scroll Scroll { get; set; }
        public virtual Weapon Weapon { get; set; }
    }
}
