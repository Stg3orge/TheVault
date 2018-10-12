using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameLogic.model
{
    public abstract class Weapon : Item
    {
        public Weapon(string title) : base(title)
        {
        }

        public abstract void Attack(Player playerToAttack);

    }
}
