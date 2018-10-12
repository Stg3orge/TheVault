using System;
using System.Windows.Forms;

namespace DbConnectionBetter {
    class StartPoint {
        [STAThread]
        static void Main() {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new JustConnect());
        }
    }
}
