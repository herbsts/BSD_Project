package bsd.school2017.boost_it.pkgFragments;

/**
 * Created by Martin on 20.10.2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import bsd.school2017.boost_it.R;
import bsd.school2017.boost_it.pkgThreads.AsyncTranslation;

public class MainFragment extends Fragment implements View.OnClickListener{

    EditText edtTranslate;
    Button btnTranslate;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.main_fragment, container, false);
        getAllViews(rootView);
        registrateEventHandlers();
        return rootView;
    }

    private void getAllViews(View view) {
        edtTranslate = (EditText) view.findViewById(R.id.edtTranslate);
        btnTranslate = (Button) view.findViewById(R.id.btnTranslate);
    }

    private void registrateEventHandlers(){
        btnTranslate.setOnClickListener(this);
    }

    private String configurateTranslation(){
        final String english = "en";
        final String german = "de";
        final String word = edtTranslate.getText().toString();
        final String word_id = word.toLowerCase(); //word id is case sensitive and lowercase is required
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/" +
                english + "/" + word_id + "/translations=" + german;
    }

    private void handleTranslation(){
        new AsyncTranslation().execute(configurateTranslation());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnTranslate:
                handleTranslation();
                break;
        }
    }
}