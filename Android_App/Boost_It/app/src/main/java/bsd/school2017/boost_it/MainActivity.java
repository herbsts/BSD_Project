package bsd.school2017.boost_it;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import bsd.school2017.boost_it.pkgDatabase.Database;
import bsd.school2017.boost_it.pkgFragments.LoginFragment;
import bsd.school2017.boost_it.pkgFragments.PlaceholderFragment;
import bsd.school2017.boost_it.pkgFragments.TestFragment;
import bsd.school2017.boost_it.pkgFragments.UnitFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {


    Database db = new Database();
    private CharSequence mTitle;
    TextView txtName = null;
    int currentFragment;

    public static MainActivity newInstance() {
        MainActivity ma = new MainActivity();
        return ma;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        txtName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txvUsernameHeader);
        txtName.setText("Guest");
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(1))
                .commit();

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(getResources().getString(R.string.title_home));
        mTitle = getTitle();
        currentFragment = R.id.container;

        try {
            db.loadAllUsers();
        } catch (Exception x){
            Toast.makeText(this, "Error while loading all Users", Toast.LENGTH_LONG).show();
        }

    }


    public void setName(String n){
        txtName.setText(n);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                changeFragment(PlaceholderFragment.newInstance(0), "Home");
                break;
            case R.id.nav_units:
                changeFragment(UnitFragment.newInstance(), "Unit");
                break;
            case R.id.nav_test:
                changeFragment(TestFragment.newInstance(this), "Test");
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_login:
                changeFragment(LoginFragment.newInstance(this), "Login");
                break;
        }
        return true;
    }

    public void changeFragment(Fragment f, String title){
        mTitle = title;
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(mTitle);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(currentFragment, f)
                .commit();
        currentFragment = f.getId();
    }
}
