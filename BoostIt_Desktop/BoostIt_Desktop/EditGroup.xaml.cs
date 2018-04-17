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
    /// Interaction logic for EditGroup.xaml
    /// </summary>
    public partial class EditGroup : Window
    {
        List<User> allStudents = new List<User>();
        List<User> studentsAvailable = new List<User>();
        List<User> studentsAssigned = new List<User>();
        public EditGroup(string username)
        {
            InitializeComponent();
            lblLoggedIn.Content = username;
            cbGroup.ItemsSource = Database.GetInstance().GetClassDescriptions();
            cbTeacher.ItemsSource = Database.GetInstance().GetTeachers();
            studentsAvailable = (List<User>)Database.GetInstance().GetStudents();
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
        {
            ShowGroup sg = new ShowGroup(lblLoggedIn.Content.ToString());
            sg.Show();
            this.Close();
        }

        private void BtnEditGroup_Click(object sender, RoutedEventArgs e)
        {/*Not necessary here because we are already in Dashboard Window here...*/}

        private void BtnShowUserStatistic_Click(object sender, RoutedEventArgs e)
        {

        }

        private void BtnShowGroupStatistic_Click(object sender, RoutedEventArgs e)
        {

        }

        private void CbGroup_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            string classDescription = cbGroup.SelectedItem.ToString();
            User teacher = Database.GetInstance().GetTeacherForClass(classDescription);
            cbTeacher.SelectedItem = teacher;
            assignedStudents.ItemsSource = Database.GetInstance().GetStudentsForClass(classDescription);
            allStudents = (List<User>)Database.GetInstance().GetStudents();
            foreach(User u in assignedStudents.ItemsSource)
            {
                allStudents.Remove(u);
            }
            availableStudents.ItemsSource = allStudents;
        }

        private void BtnRightToLeft_Click(object sender, RoutedEventArgs e)
        {
            if (availableStudents.SelectedItem != null)
            {
                User u = (User)availableStudents.SelectedItem;
                studentsAssigned.Add(u);
                studentsAvailable.Remove(u);
                assignedStudents.ItemsSource = null;
                availableStudents.ItemsSource = null;
                assignedStudents.ItemsSource = studentsAssigned;
                availableStudents.ItemsSource = studentsAvailable;
                assignedStudents.SelectedItem = null;
                availableStudents.SelectedItem = null;
            }
            else
            {
                MessageBox.Show("No Student to assign selected.");
            }
        }

        private void BtnLeftToRight_Click(object sender, RoutedEventArgs e)
        {
            if (assignedStudents.SelectedItem != null)
            {
                User u = (User)assignedStudents.SelectedItem;
                studentsAvailable.Add(u);
                studentsAssigned.Remove(u);
                assignedStudents.ItemsSource = null;
                availableStudents.ItemsSource = null;
                assignedStudents.ItemsSource = studentsAssigned;
                availableStudents.ItemsSource = studentsAvailable;
                assignedStudents.SelectedItem = null;
                availableStudents.SelectedItem = null;
            }
            else
            {
                MessageBox.Show("No Student to unassign selected.");
            }
        }

        private void BtnCancel_Click(object sender, RoutedEventArgs e)
        {
            cbGroup.SelectedItem = null;
            cbTeacher.SelectedItem = null;
            assignedStudents.SelectedItem = null;
            availableStudents.SelectedItem = null;
            assignedStudents.ItemsSource = null;
            availableStudents.ItemsSource = null;
        }

        private void BtnSavechanges_Click(object sender, RoutedEventArgs e)
        {
            ClassMember cm;
            if (cbGroup.SelectedItem.ToString().Length > 0 && cbTeacher.SelectedItem != null && studentsAssigned.Count > 0)
            {
                Database.GetInstance().RemoveAllMembersForClass(cbGroup.SelectedItem.ToString());
                foreach (User u in studentsAssigned)
                {
                    cm = new ClassMember((User)cbTeacher.SelectedItem, u, cbGroup.SelectedItem.ToString());
                    Database.GetInstance().InsertClassMember(cm);
                }
            }
        }
    }
}
