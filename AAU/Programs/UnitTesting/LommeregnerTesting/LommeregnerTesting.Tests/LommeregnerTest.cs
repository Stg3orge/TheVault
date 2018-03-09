using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LommeregnerTesting.Tests
{
    [TestClass]
    public class LommeregnerTest
    {
        [TestMethod]
        public void Plus_ReturnElevenWhenPassedWithFiveAndSix()
        {
            // Arranger først testen med en instans af klassen in question
            Lommeregner Lom = new Lommeregner();
            // Udfør med desired testing parametre
            int resultat = Lom.Plus(5, 6);
            // Her undersøger man så om det så kan passe altså assertation af testen
            Assert.AreEqual(11, resultat);
        }

        [TestMethod]
        public void Gange_ReturnThirtyWhenPassedWithFiveAndSix()
        {
            // Arranger
            Lommeregner Lom = new Lommeregner();
            // Action
            int resultat = Lom.Gange(5, 6);
            // Assert
            Assert.AreEqual(30, resultat);
        }

        [TestMethod]
        public void BoobiesOp_MethodShouldReturnAString()
        {
            // Arranger
            Lommeregner Lom = new Lommeregner();
            // Action
            string resultat = Lom.BoobiesOp("gay", "retard", 50);
            // Assert
            Assert.AreEqual("Lommeregneren udskrivergayretard50", resultat);
<<<<<<< HEAD
            //Assert.IsInstanceOfType(Lom, resultat);
=======
          
>>>>>>> 92896fb05e45f08152caca19696b3688ba55cd0a
        }
    }
}
