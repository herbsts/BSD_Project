package bsd.school2017.boost_it.pkgFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import bsd.school2017.boost_it.R;
import bsd.school2017.boost_it.pkgDatabase.Database;

public class PlaceholderFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */

    EditText edtTranslate;
    TextView txvPartOfFill, txvGermanFill, txvEnglishFill, txvVarietyFill;
    Button btnTranslate;
    ToggleButton toggleLanguage;
    Database db = new Database();

    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.content_main, container, false);
        getAllViews(layout);
        return layout;
    }




    private void getAllViews(View v){
        edtTranslate = (EditText) v.findViewById(R.id.edtTranslate);
        btnTranslate = (Button) v.findViewById(R.id.btnTranslate);
        txvEnglishFill = (TextView) v.findViewById(R.id.txvEnglishFill);
        txvGermanFill = (TextView) v.findViewById(R.id.txvGermanFill);
        txvPartOfFill = (TextView) v.findViewById(R.id.txvPartOfFill);
        txvVarietyFill = (TextView) v.findViewById(R.id.txvVarietyFill);
        toggleLanguage = (ToggleButton) v.findViewById(R.id.toggleLanguage);

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleTranslation();
            }
        });
        toggleLanguage.setTextOff("DE->EN");
        toggleLanguage.setTextOn("EN->DE");
        toggleLanguage.setText("DE->EN");
    }


    private void handleTranslation() {
        try {
            if(toggleLanguage.getText().equals("EN->DE")){
                db.getTranslationEngToGer(edtTranslate.getText().toString());
            } else {
                db.getTranslationGerToEng(edtTranslate.getText().toString());
            }
        } catch(Exception x){

        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int section_number = getArguments().getInt(ARG_SECTION_NUMBER);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int section_number = getArguments().getInt(ARG_SECTION_NUMBER);
    }
}