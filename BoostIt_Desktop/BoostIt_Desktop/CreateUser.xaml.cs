﻿using System;
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
    /// Interaction logic for CreateUser.xaml
    /// </summary>
    public partial class CreateUser : Window
    {
        public CreateUser(string username)
        {
            InitializeComponent();
            lblLoggedIn.Content = username;
            var dataSource = new List<string>
            {
                "Student",
                "Teacher"
            };
            cbRole.ItemsSource = dataSource;
        }

        public CreateUser()
        {
            InitializeComponent();
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
        {/*Not necessary here because we are already in CreateUser Window here...*/}

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

        private void BtnAddUser_Click(object sender, RoutedEventArgs e)
        {
            if(txtName.Text.Length <= 0 || txtPassword.Password.Length <= 0 || txtPasswordRepeat.Password.Length <= 0 || cbRole.SelectedItem == null)
            {
                MessageBox.Show("Please enter a Username, Password, repeat your Password and select a role!");
            }
            else if (!txtPassword.Password.Equals(txtPasswordRepeat.Password))
            {
                MessageBox.Show("You entered two different passwords, please try again!");
            }
            else
            {
                User usrToInsert = new User(-1, txtName.Text, txtPassword.Password, (EnumRoles)Enum.Parse(typeof(EnumRoles),cbRole.SelectedItem.ToString()));
                Console.WriteLine(usrToInsert);
                string response = Database.GetInstance().InsertUser(usrToInsert);
                MessageBox.Show(response,"Status of user insert");
            }
        }

        private void BtnCancel_Click(object sender, RoutedEventArgs e)
        {
            txtName.Text = "";
            txtPassword.Password = "";
            txtPasswordRepeat.Password = "";
            cbRole.SelectedItem = null;
        }
    }
}
