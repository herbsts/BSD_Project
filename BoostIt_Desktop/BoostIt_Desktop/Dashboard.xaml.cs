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
    /// Interaction logic for Dashboard.xaml
    /// </summary>
    public partial class Dashboard : Window
    {
        public Dashboard(string username)
        {
            InitializeComponent();
            lblLoggedIn.Content = username;
            Database.GetInstance().LoadUsers();
        }

        private void BtnShowReference_Click(object sender, RoutedEventArgs e)
        {
            ShowReference sr = new ShowReference(lblLoggedIn.Content.ToString());
            sr.Show();
            this.Close();
        }

        private void BtnLogout_Click(object sender, RoutedEventArgs e)
        {
            MainWindow mw = new MainWindow();
            mw.Show();
            this.Close();
        }

        private void BtnExit_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void BtnHome_Click(object sender, RoutedEventArgs e)
        {/*Not necessary here because we are already in Dashboard Window here...*/}

        private void BtnCreateUser_Click(object sender, RoutedEventArgs e)
        {
            CreateUser cu = new CreateUser(lblLoggedIn.Content.ToString());
            cu.Show();
            this.Close();
        }

        private void BtnShowUser_Click(object sender, RoutedEventArgs e)
        {
            ShowUser su = new ShowUser(lblLoggedIn.Content.ToString());
            su.Show();
            this.Close();
        }

        private void BtnEditUser_Click(object sender, RoutedEventArgs e)
        {
            EditUser eu = new EditUser(lblLoggedIn.Content.ToString());
            eu.Show();
            this.Close();
        }

        private void BtnCreateGroup_Click(object sender, RoutedEventArgs e)
        {
            CreateGroup cg = new CreateGroup(lblLoggedIn.Content.ToString());
            cg.Show();
            this.Close();
        }

        private void BtnShowGroup_Click(object sender, RoutedEventArgs e)
        {
            ShowGroup sg = new ShowGroup(lblLoggedIn.Content.ToString());
            sg.Show();
            this.Close();
        }

        private void BtnEditGroup_Click(object sender, RoutedEventArgs e)
        {
            EditGroup eg = new EditGroup(lblLoggedIn.Content.ToString());
            eg.Show();
            this.Close();
        }

        private void BtnShowUserStatistic_Click(object sender, RoutedEventArgs e)
        {

        }

        private void BtnShowGroupStatistic_Click(object sender, RoutedEventArgs e)
        {

        }

        private void BtnShowHistory_Click(object sender, RoutedEventArgs e)
        {

        }

        private void BtnShowMessage_Click(object sender, RoutedEventArgs e)
        {

        }
    }
}