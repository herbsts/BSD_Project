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
    /// Interaction logic for ShowGroup.xaml
    /// </summary>
    public partial class ShowGroup : Window
    {
        List<ClassMember> members;
        public ShowGroup(string username)
        {
            InitializeComponent();
            lblLoggedIn.Content = username;
            listGroups.ItemsSource = Database.GetInstance().GetGroups();
            members = (List<ClassMember>)listGroups.ItemsSource;
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
        {/*Not necessary here because we are already in ShowUser Window here...*/}

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

        private void BtnSearch_Click(object sender, RoutedEventArgs e)
        {
            if (txtName.Text.ToString().Equals(""))
            {
                listGroups.ItemsSource = members;
            }
            else
            {
                List<ClassMember> foundMembers = new List<ClassMember>();
                foreach (ClassMember m in members)
                {
                    if (m.classDescription.Equals(txtName.Text))
                    {
                        foundMembers.Add(m);
                    }

                }
                listGroups.ItemsSource = foundMembers;
            }
        }

        private void BtnShowUserDetails_Click(object sender, RoutedEventArgs e)
        {
            if (listGroups.SelectedItem == null)
            {
                MessageBox.Show("Select a group first.");
            }
            else
            {
                MessageBox.Show
                (
                    "Class: " + ((ClassMember)listGroups.SelectedItem).classDescription +
                    "\nTeacher: " + ((ClassMember)listGroups.SelectedItem).teacher +
                    "\nStudent: " + ((ClassMember)listGroups.SelectedItem).student + "'"
                );
            }
        }

        private void BtnDeleteGroup_Click(object sender, RoutedEventArgs e)
        {
            if (listGroups.SelectedItem == null)
            {
                MessageBox.Show("Select a group first.");
            }
            else
            {
                Database.GetInstance().RemoveGroup((ClassMember)listGroups.SelectedItem);
                listGroups.ItemsSource = Database.GetInstance().GetGroups();
            }
        }
    }
}
