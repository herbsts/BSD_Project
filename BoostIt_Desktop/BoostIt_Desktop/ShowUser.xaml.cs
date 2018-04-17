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
    /// Interaction logic for ShowUser.xaml
    /// </summary>
    public partial class ShowUser : Window
    {
        List<User> users;
        public ShowUser(string username)
        {
            InitializeComponent();
            lblLoggedIn.Content = username;
            listUsers.ItemsSource = Database.GetInstance().GetUsers();
            users = listUsers.Items.OfType<User>().ToList<User>();
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
        {
            Dashboard db = new Dashboard(lblLoggedIn.Content.ToString());
            db.Show();
            this.Close();
        }

        private void BtnCreateUser_Click(object sender, RoutedEventArgs e)
        {
            CreateUser cu = new CreateUser(lblLoggedIn.Content.ToString());
            cu.Show();
            this.Close();
        }

        private void BtnShowUser_Click(object sender, RoutedEventArgs e)
        {/*Not necessary here because we are already in ShowUser Window here...*/}

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

        private void BtnDeleteSelectedUser_Click(object sender, RoutedEventArgs e)
        {
            if (listUsers.SelectedItem == null)
            {
                MessageBox.Show("Select a user first.");
            }
            else
            {
                string response = Database.GetInstance().RemoveUser((User)listUsers.SelectedItem);
                listUsers.ItemsSource = null;
                listUsers.ItemsSource = Database.GetInstance().GetUsers();
                MessageBox.Show(response);
            }
        }

        private void BtnSearch_Click(object sender, RoutedEventArgs e)
        {
            if (txtName.Text.ToString().Equals(""))
            {
                listUsers.ItemsSource = users;
            }
            else
            {
                List<User> foundUsers = new List<User>();
                foreach(User u in users)
                {
                    if (u.username.ToLower().Equals(txtName.Text.ToLower()))
                        foundUsers.Add(u);
                }
                listUsers.ItemsSource = foundUsers;
            }
        }

        private void BtnShowUserDetails_Click(object sender, RoutedEventArgs e)
        {
            if (listUsers.SelectedItem == null)
            {
                MessageBox.Show("Select a user first.");
            }
            else
            {
                MessageBox.Show
                (
                    "user_id: " + ((User)listUsers.SelectedItem).user_id + 
                    "\nusername: "+ ((User)listUsers.SelectedItem).username + 
                    "\npassword: "+ ((User)listUsers.SelectedItem).password + 
                    "\nrole: "+ ((User)listUsers.SelectedItem).role,"Details for user '" + ((User)listUsers.SelectedItem).username + "'"
                );
            }
        }
    }
}