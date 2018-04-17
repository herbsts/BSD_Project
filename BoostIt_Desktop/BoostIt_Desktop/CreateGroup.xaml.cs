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
    /// Interaction logic for CreateGroup.xaml
    /// </summary>
    public partial class CreateGroup : Window
    {
        List<User> studentsAvailable = new List<User>();
        List<User> studentsAssigned = new List<User>();
        public CreateGroup(string username)
        {
            InitializeComponent();
            lblLoggedIn.Content = username;
            cbTeacher.ItemsSource = Database.GetInstance().GetTeachers();
            studentsAvailable = (List<User>)Database.GetInstance().GetStudents();
            listStudents.ItemsSource = studentsAvailable;
            listAssigned.ItemsSource = studentsAssigned;
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
        {/*Not necessary here because we are already in CreateGroup Window here...*/}

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

        private void BtnRightToLeft_Click(object sender, RoutedEventArgs e)
        {
            if(listStudents.SelectedItem != null)
            {
                User u = (User)listStudents.SelectedItem;
                studentsAssigned.Add(u);
                studentsAvailable.Remove(u);
                listAssigned.ItemsSource = null;
                listStudents.ItemsSource = null;
                listAssigned.ItemsSource = studentsAssigned;
                listStudents.ItemsSource = studentsAvailable;
                listAssigned.SelectedItem = null;
                listStudents.SelectedItem = null;
            }
            else
            {
                MessageBox.Show("No Student to assign selected.");
            }
        }

        private void BtnLeftToRight_Click(object sender, RoutedEventArgs e)
        {
            if (listAssigned.SelectedItem != null)
            {
                User u = (User)listAssigned.SelectedItem;
                studentsAvailable.Add(u);
                studentsAssigned.Remove(u);
                listAssigned.ItemsSource = null;
                listStudents.ItemsSource = null;
                listAssigned.ItemsSource = studentsAssigned;
                listStudents.ItemsSource = studentsAvailable;
                listAssigned.SelectedItem = null;
                listStudents.SelectedItem = null;
            }
            else
            {
                MessageBox.Show("No Student to unassign selected.");
            }
        }

        private void BtnCancel_Click(object sender, RoutedEventArgs e)
        {
            txtName.Text = "";
            cbTeacher.SelectedItem = null;
            foreach (User u in studentsAssigned)
            {
                studentsAvailable.Add(u);
            }
            studentsAssigned.Clear();
            listAssigned.ItemsSource = null;
            listStudents.ItemsSource = null;
            listAssigned.ItemsSource = studentsAssigned;
            listStudents.ItemsSource = studentsAvailable;
            listAssigned.SelectedItem = null;
            listStudents.SelectedItem = null;
        }

        private void BtnAddGroup_Click(object sender, RoutedEventArgs e)
        {
            ClassMember cm;
            if(txtName.Text.Length > 0 && cbTeacher.SelectedItem != null && studentsAssigned.Count > 0)
            {
                foreach (User u in studentsAssigned)
                {
                    cm = new ClassMember((User)cbTeacher.SelectedItem, u, txtName.Text);
                    Database.GetInstance().InsertClassMember(cm);
                }
            }
            
        }
    }
}
