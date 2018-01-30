package bsd.school2017.boost_it.pkgFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bsd.school2017.boost_it.MainActivity;
import bsd.school2017.boost_it.R;
import bsd.school2017.boost_it.pkgData.User;
import bsd.school2017.boost_it.pkgDatabase.Database;
import bsd.school2017.boost_it.pkgEnumerations.enumRole;

public class LoginFragment extends Fragment {

    EditText edtUsername, edtPassword;
    Button btnLogin;
    Database db = new Database();
    static MainActivity main = null;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(MainActivity ma) {
        LoginFragment fragment = new LoginFragment();
        main = ma;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void getAllViews(View layout){
        edtUsername = (EditText)layout.findViewById(R.id.edtUsername);
        edtPassword = (EditText)layout.findViewById(R.id.edtPassword);
        btnLogin = (Button)layout.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    tryLogin();
                } catch(Exception x){
                    Log.e("ERROR", "Error while login");
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_login, container, false);
        getAllViews(layout);
        return layout;
    }

    public void tryLogin() throws Exception{
        boolean ret = false;
        Log.d("INFO", edtUsername.getText().toString() + " " + edtPassword.getText().toString());
        if(db.login(edtUsername.getText().toString(), edtPassword.getText().toString())){
            Toast.makeText(this.getActivity(), "Welcome " + edtUsername.getText().toString(), Toast.LENGTH_LONG).show();
            main.setName(edtUsername.getText().toString());
            db.setLoggedInUser(new User(1, "Sunny", "sunny", enumRole.ADMIN));
            main.changeFragment(PlaceholderFragment.newInstance(0), "home");
        } else {
            Toast.makeText(getContext(), "Error while login, check your credentials", Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }
}
