package bsd.school2017.boost_it.pkgFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import bsd.school2017.boost_it.MainActivity;
import bsd.school2017.boost_it.R;
import bsd.school2017.boost_it.pkgAdapter.TestArrayAdapter;

public class ResultFragment extends Fragment {

    private TextView txvNumberOfVocabsFill;
    private TextView txvCorrectVocabsFill;
    private TextView txvWrongVocabsFill;
    private TextView txvPercentageVocabsFill;

    private static float wrongAnswers;
    private static float countAnswers;
    private static MainActivity main;

    private Button btnFinish;

    private static TestArrayAdapter adapter;

    public ResultFragment() {
        // Required empty public constructor
    }

    public static ResultFragment newInstance(MainActivity ma, float _wrongAnswers, float _countAnwers) {
        ResultFragment fragment = new ResultFragment();
        main = ma;
        wrongAnswers = _wrongAnswers;
        countAnswers = _countAnwers;
        return fragment;
    }

    private void getAllViews(View v){
        txvNumberOfVocabsFill = (TextView) v.findViewById(R.id.txvNumberOfVocabsFill);
        txvNumberOfVocabsFill.setText(String.valueOf(countAnswers));

        txvCorrectVocabsFill = (TextView) v.findViewById(R.id.txvCorrectVocabsFill);
        txvCorrectVocabsFill.setText(String.valueOf(countAnswers-wrongAnswers));

        txvWrongVocabsFill = (TextView) v.findViewById(R.id.txvWrongVocabsFill);
        txvWrongVocabsFill.setText(String.valueOf(wrongAnswers));

        txvPercentageVocabsFill = (TextView) v.findViewById(R.id.txvPercentVocabsFill);
        Log.d("INFO", countAnswers + " - " + wrongAnswers + "/" + countAnswers);
        float percentage = (countAnswers-wrongAnswers)/countAnswers*100;
        txvPercentageVocabsFill.setText(String.valueOf(percentage + "%"));

        if(percentage > 50)txvPercentageVocabsFill.setTextColor(getResources().getColor(R.color.correct_answer));
        else txvPercentageVocabsFill.setTextColor(getResources().getColor(R.color.wrong_answer));

        btnFinish = (Button) v.findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.changeFragment(PlaceholderFragment.newInstance(0), "Home");
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        getAllViews(view);
        return view;
    }


    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onDetach() {super.onDetach();}
}
