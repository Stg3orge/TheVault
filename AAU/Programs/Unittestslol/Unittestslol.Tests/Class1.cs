using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Unittestslol.Tests
{
    [TestClass]
    public class Class1
    {
        [TestMethod]
        public void Dickbutt_GayShouldReturnElevenWhenPassedWithFivePointFive()
        {
            // Arrange
            Dickbutt dickbutt = new Dickbutt();
            // Act
            double resultat = dickbutt.Gay(5.5, 5.5);
            // Assert
            Assert.AreEqual(11, resultat);
        }

    }
}
