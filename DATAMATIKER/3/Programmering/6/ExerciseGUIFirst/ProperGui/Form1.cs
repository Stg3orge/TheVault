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
    public partial class Form1 : Form
    {

        List<string> names = new List<string>();
        int selectedIndex;

        public Form1()
        {
            InitializeComponent();

            names.Add("Joey");
            names.Add("Bob");
        }

        private void add_Click(object sender, EventArgs e)
        {
            names.Add(textBox1.Text);
            textBox1.Text = string.Empty;
        }

        private void show_Click(object sender, EventArgs e)
        {
            //listBox1.DataSource = null;
            listBox1.DataSource = names;
            selectedIndex = listBox1.SelectedIndex;
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            label1.Text = listBox1.SelectedItem.ToString();
        }

        private void page2button_Click(object sender, EventArgs e)
        {
            var form = new Form2();
            form.Location = this.Location;
            form.Show();
            this.Hide();
        }
    }
}
