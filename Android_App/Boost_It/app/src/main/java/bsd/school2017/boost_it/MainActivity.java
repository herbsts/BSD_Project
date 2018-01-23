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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import bsd.school2017.boost_it.pkgDatabase.Database;
import bsd.school2017.boost_it.pkgFragments.LoginFragment;
import bsd.school2017.boost_it.pkgFragments.PlaceholderFragment;
import bsd.school2017.boost_it.pkgFragments.TestFragment;
import bsd.school2017.boost_it.pkgThreads.AsyncTranslation;
import bsd.school2017.boost_it.pkgThreads.IAsyncTaskResponse;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, IAsyncTaskResponse, NavigationView.OnNavigationItemSelectedListener  {

    EditText edtTranslate;
    Button btnTranslate;
    TextView txvOutcome;
    Database db = null;
    private CharSequence mTitle;
    int currentFragment;

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
        TextView txtName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txvUsernameHeader);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnTranslate:
                handleTranslation();
                break;
        }
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

    private void handleTranslation() {
        AsyncTranslation as = new AsyncTranslation();
        as.delegate = this;
        as.execute(configurateTranslation());
    }

    @Override
    public void processFinish(String output){
        txvOutcome.setText(output);
    }

    private String configurateTranslation() {
        final String english = "en";
        final String german = "de";
        final String word = edtTranslate.getText().toString();
        final String word_id = word.toLowerCase(); //word id is case sensitive and lowercase is required
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/" +
                english + "/" + word_id + "/translations=" + german;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment changeFragment = new Fragment();
        switch (item.getItemId()) {
            case R.id.nav_home:
                mTitle = getString(R.string.title_home);
                changeFragment = PlaceholderFragment.newInstance(0);
                break;
            case R.id.nav_units:
                mTitle = "Unit";
                break;
            case R.id.nav_test:
                mTitle = "Test";
                changeFragment = TestFragment.newInstance();
                break;
            case R.id.nav_settings:
                mTitle = "Settings";
                break;
            case R.id.nav_login:
                mTitle = "Login";
                changeFragment = LoginFragment.newInstance();
                break;
        }

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(mTitle);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(currentFragment, changeFragment)
                .commit();
        currentFragment = changeFragment.getId();
        return true;
    }
}
