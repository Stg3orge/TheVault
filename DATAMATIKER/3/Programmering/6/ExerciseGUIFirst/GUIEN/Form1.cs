using Domain;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GUIEN
{
    public partial class Form1 : Form
    {
        List<Person> persons = new List<Person>();

        public Form1()
        {
            InitializeComponent();
        }

        private void ShowLabel_Click(object sender, EventArgs e)
        {
            string name = inputbox.Text;

            Person person = new Person(name);

            persons.Add(person);

            //  string msg = inputbox.Text;
            // Shown.Text = msg;
        }

        private void printPersonList_Click(object sender, EventArgs e)
        {
            shownPersonsBox.DataSource = persons;

        }

        private void shownPersonsBox_SelectedIndexChanged(object sender, EventArgs e)
        {


            Person p = shownPersonsBox.SelectedItem as Person;
            string s = p.Name;
            shownPersonsBox.SelectedValue = s;

            //Form2 form2 = new GUIEN.Form2();
            //form2.Show();

            label1.Text = p.Name;
        }
    }
}
