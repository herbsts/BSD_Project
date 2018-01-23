package bsd.school2017.boost_it.pkgFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bsd.school2017.boost_it.R;

public class LoginFragment extends Fragment implements View.OnClickListener{

    EditText edtUsername, edtPassword;
    Button btnLogin;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = null;
        try{
            layout = inflater.inflate(R.layout.fragment_login, container, false);
            getAllViews(layout);
            registrateEventHandlers();
        } catch(Exception x){
            Toast.makeText(this.getActivity(), "exception in fragment owner: " + x.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }

        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    private void registrateEventHandlers(){
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btnLogin.getId()){
            Toast.makeText(this.getActivity(), "btnLogin clicked", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
