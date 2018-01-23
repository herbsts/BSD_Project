package bsd.school2017.boost_it.pkgFragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import bsd.school2017.boost_it.R;
import bsd.school2017.boost_it.pkgAdapter.DataModel;
import bsd.school2017.boost_it.pkgAdapter.TestArrayAdapter;

public class TestFragment extends ListFragment {
    private ArrayList<DataModel> lstDataModel;
    private ListView lsvTest;

    private static TestArrayAdapter adapter;

    public TestFragment() {
        // Required empty public constructor
    }

    public static TestFragment newInstance() {
        TestFragment fragment = new TestFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        lstDataModel = new ArrayList<>();
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

                    DataModel dataModel= lstDataModel.get(position);

                    Snackbar.make(view, dataModel.getName()+"\n"+dataModel.getDescription()+" Diff:"+dataModel.getDiff_number(), Snackbar.LENGTH_LONG)
                            .setAction("No action", null).show();
                }
            });
        }catch(Exception e){
            Toast.makeText(this.getActivity(), "exception in frag test: " + e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
        return view;
    }

    private void fillDataModel(){
        lstDataModel.add(new DataModel("Phrases", "basic Phrases", "1", "Basic Phrases to learn"));
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onDetach() {super.onDetach();}
}
