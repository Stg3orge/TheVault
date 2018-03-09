using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LommeregnerTesting
{
    public class Lommeregner
    {
        public int Plus(int dick, int butt)
        {
            int resultat = dick + butt;
            return resultat;
        }

        public int Gange(int dick, int butt)
        {
            int resultat = dick * butt;
            return resultat;
        }

        public string BoobiesOp(string boob, string ies, int xd)
        {
            string sammensat = "Lommeregneren udskriver" + boob + ies;
            Console.WriteLine(sammensat);
            xd.ToString();
            string sammensatPlusXD = sammensat + xd;
            Console.WriteLine(sammensatPlusXD);
            return sammensatPlusXD;
        }
    }
}
