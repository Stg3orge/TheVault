using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProperGui
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void page1button_Click(object sender, EventArgs e)
        {
            var form = new Form1();
            form.Location = this.Location;
            form.Show();
            this.Hide();
        }
    }
}
