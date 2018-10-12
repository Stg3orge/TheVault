using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameLogic.model
{
    public class GoldSword : Weapon
    {
        int damage;

        public GoldSword(string title) : base(title)
        {
            damage = 10;
        }

        public override void Attack(Player playerToAttack)
        {
            playerToAttack.Hitpoints -= damage;
        }
    }
}
