using System;
using GameLogic.model;
using GameLogic.model.Interfaces;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using GameLogic;

namespace InheritanceGame
{
    class Program
    {
        static void Main(string[] args)
        {
            Bread bread = new Bread("Bread");
            Bread stalebread = new Bread("Stale Bread");
            Juice juice = new Juice("Juice");
            GoldSword goldsword = new GoldSword("Gold Sword");

            Player player = new Player(60);
            Player player2 = new Player(40);

            player.PlayerInventory.Items.Add(bread);
            player.PlayerInventory.Items.Add(stalebread);
            player.PlayerInventory.Items.Add(juice);
            player.PlayerInventory.Items.Add(goldsword);

            Console.WriteLine($"Player hitpoints: {player.Hitpoints}");

            Console.WriteLine("Player Inventory: ");
            Console.WriteLine("--------------------");

            for (int i = 0; i < player.PlayerInventory.Items.Count; i++)
            {

                if (player.PlayerInventory.Items[i] is Juice)
                {
                    Console.Write(player.PlayerInventory.Items[i].Title + " - ");
                    ((Juice)player.PlayerInventory.Items[i]).Consume(player);
                }
                if (player.PlayerInventory.Items[i] is GoldSword)
                {
                    Console.WriteLine("Player attacked player2 with: " + player.PlayerInventory.Items[i].Title);
                    Console.WriteLine("player2 hitpoints before attack: " + player2.Hitpoints);
                    ((GoldSword)player.PlayerInventory.Items[i]).Attack(player2);
                    Console.WriteLine("player2 hitpoints after attack: " + player2.Hitpoints);
                }
                else
                {
                    Console.WriteLine(player.PlayerInventory.Items[i].Title);
                }
            }

            Console.ReadKey();

        }
    }
}
