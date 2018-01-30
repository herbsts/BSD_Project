using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace BoostIt_Desktop
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            txtUsername.Text = "Herbot";
            txtPassword.Password = "herbot";
        }

        private void OnBtnLoginClick(object sender, RoutedEventArgs e)
        {
            if(txtUsername.Text.Length > 0 && txtUsername.Text.Length > 0)
            {
                bool retVal = Database.GetInstance().ChkLogin(txtUsername.Text, txtPassword.Password);
                if(retVal)
                {
                    Database.GetInstance().SetUser(txtUsername.Text, txtPassword.Password);
                    Dashboard d = new Dashboard(txtUsername.Text);
                    d.Show();
                    this.Close();
                }
                else
                {
                    MessageBox.Show("Error: No user '" + txtUsername.Text + "' found!");
                }
                /*Dashboard d = new Dashboard("Herbot");
                d.Show();
                this.Close();*/
            }
            else
            {
                MessageBox.Show("Enter a username and password to continue!");
            }
        }
    }
}
