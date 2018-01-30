package bsd.school2017.boost_it.pkgFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import bsd.school2017.boost_it.MainActivity;
import bsd.school2017.boost_it.R;
import bsd.school2017.boost_it.pkgData.Word;
import bsd.school2017.boost_it.pkgEnumerations.enumLanguage;

public class VocabTestFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";

    private String testType;
    private EditText edtTranslation;
    private TextView edtToTranslate;
    private Button btnNext;
    private ArrayList<Word> wordList = new ArrayList<>();
    static private enumLanguage language;
    private int countAnswers = 0;
    private ArrayList<Word> wrongList = new ArrayList<>();
    static private MainActivity main = null;

    public VocabTestFragment() {
    }

    public static VocabTestFragment newInstance(MainActivity ma,  String lang) {
        VocabTestFragment fragment = new VocabTestFragment();
        language = enumLanguage.valueOf(lang);
        main = ma;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            testType = getArguments().getString(ARG_PARAM1);
        }
    }

    private void getAllViews(View v){
        edtToTranslate = (TextView) v.findViewById(R.id.edtToTranslate);
        edtTranslation = (EditText) v.findViewById(R.id.edtTranslation);
        btnNext = (Button) v.findViewById(R.id.btnNext);

        btnNext.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_vocab_test, container, false);
        getAllViews(layout);
        getTestList();
        if(language.equals(enumLanguage.ENtoGER))
            edtToTranslate.setText(wordList.get(0).gettEnglish());
        else {
            edtToTranslate.setText(wordList.get(0).gettGerman() + " (" + wordList.get(0).getVarietyOfEnglish() + ")");
        }
        return layout;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnNext:
                if(countAnswers >= wordList.size()){
                    finishTest();
                } else checkAnswer();
                break;
        }
    }

    private void getTestList(){
        wordList.add(new Word(1, "Baum", "tree", "GB", "Noun", "no specified usage"));
        wordList.add(new Word(2, "Katze", "cat", "GB", "Noun", "no specified usage"));
        wordList.add(new Word(3, "Lehrer", "teacher", "GB", "Noun", "no specified usage"));
        wordList.add(new Word(4, "Farbe", "color", "US", "Noun", "no specified usage"));
    }

    private void finishTest(){
        float wrongAnswers = wordList.size() - wrongList.size();
        main.changeFragment(ResultFragment.newInstance(main, wrongAnswers, (float) wordList.size()), "Results");
    }

    private void checkAnswer(){
        if(language.equals(enumLanguage.ENtoGER)){
            if(edtTranslation.getText().toString().toLowerCase().equals(wordList.get(countAnswers).gettGerman().toLowerCase())){
                wrongList.add(wordList.get(countAnswers));
            }
            countAnswers++;
            if(countAnswers >= wordList.size()){
                finishTest();
            } else {
                edtTranslation.setText("");
                edtToTranslate.setText(wordList.get(countAnswers).gettEnglish());
            }
        } else {
            if(edtTranslation.getText().toString().toLowerCase().equals(wordList.get(countAnswers).gettEnglish().toLowerCase())){
                wrongList.add(wordList.get(countAnswers));
            }
            countAnswers++;
            if(countAnswers >= wordList.size()){
                finishTest();
            } else {
                edtTranslation.setText("");
                edtToTranslate.setText(wordList.get(countAnswers).gettGerman() + " (" + wordList.get(countAnswers).getVarietyOfEnglish() + ")");
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
