package bsd.school2017.boost_it.pkgFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import bsd.school2017.boost_it.MainActivity;
import bsd.school2017.boost_it.R;
import bsd.school2017.boost_it.pkgAdapter.DataModel;
import bsd.school2017.boost_it.pkgAdapter.TestArrayAdapter;
import bsd.school2017.boost_it.pkgEnumerations.enumLanguage;

public class TestFragment extends Fragment {
    private ArrayList<DataModel> lstDataModel;
    private ListView lsvTest;
    private FrameLayout testList;
    private static MainActivity main;

    private static TestArrayAdapter adapter;

    public TestFragment() {
        // Required empty public constructor
    }

    public static TestFragment newInstance(MainActivity ma) {
        TestFragment fragment = new TestFragment();
        main = ma;
        return fragment;
    }

    private void getAllViews(View v){
        testList = (FrameLayout) v.findViewById(R.id.testList);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        lstDataModel = new ArrayList<>();
        getAllViews(inflater.inflate(R.layout.fragment_test, container, false));
        fillDataModel();
        // Set the adapter
        try{
            view = inflater.inflate(R.layout.fragment_test, container, false);
            lsvTest = (ListView)view.findViewById(R.id.lsvTests);
            adapter = new TestArrayAdapter(lstDataModel, this.getContext());
            lsvTest.setAdapter(adapter);
            lsvTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    main.changeFragment(VocabTestFragment.newInstance(main, lstDataModel.get(position).getDiff_number()), "Test");
                }
            });
        }catch(Exception e){
            Toast.makeText(this.getActivity(), "exception in frag test: " + e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
        return view;
    }

    private void fillDataModel(){
        lstDataModel.add(new DataModel("Simple Words", "basic words", enumLanguage.ENtoGER.name(), "if you have problems here, go hard or go home"));
        lstDataModel.add(new DataModel("Laggers Fav Words", "nobody knows", enumLanguage.GERtoEN.name(), "ask lagger, nobody else knows smt here"));
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onDetach() {super.onDetach();}
}
