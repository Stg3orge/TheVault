using System;
using GameLogic.model;
using GameLogic.model.Interfaces;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InheritanceGame
{
    class Program
    {
        static void Main(string[] args)
        {
            Bread bread = new Bread("Bread");
            Bread stalebread = new Bread("Stale Bread");
            Juice juice = new Juice("Juice");

            Player player = new Player(60);

            player.PlayerInventory.Items.Add(bread);
            player.PlayerInventory.Items.Add(stalebread);
            player.PlayerInventory.Items.Add(juice);

            for (int i = 0; i < player.PlayerInventory.Items.Count; i++)
            {
                Console.WriteLine(player.PlayerInventory.Items[i].Title);
            }

            Console.ReadKey();

        }
    }
}
