package bsd.school2017.boost_it.pkgFragments;

import android.os.Bundle;
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
import bsd.school2017.boost_it.pkgData.Unit;
import bsd.school2017.boost_it.pkgDatabase.Database;

public class UnitFragment extends ListFragment {
    private ArrayList<DataModel> lstDataModel;
    private ListView lsvTest;
    private Database db;

    private static TestArrayAdapter adapter;

    public UnitFragment() {
        // Required empty public constructor
    }

    public static UnitFragment newInstance() {
        UnitFragment fragment = new UnitFragment();
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
        db = new Database();

        View view = null;
        lstDataModel = new ArrayList<>();

        // Set the adapter
        try {
            fillDataModel();
            view = inflater.inflate(R.layout.fragment_test, container, false);
            lsvTest = (ListView) view.findViewById(R.id.lsvTests);
            adapter = new TestArrayAdapter(lstDataModel, this.getContext());
            lsvTest.setAdapter(adapter);
            lsvTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    DataModel dataModel = lstDataModel.get(position);
                    Toast.makeText(view.getContext(), dataModel.getName() + "\n" + dataModel.getDescription() + " Diff:" + dataModel.getDiff_number(), Toast.LENGTH_LONG)
                            .show();
                }
            });
        } catch (Exception e) {
            Toast.makeText(this.getActivity(), "exception in frag unit: " + e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
        return view;
    }

    private void fillDataModel() throws Exception {
        ArrayList<Unit> allUnits = db.getUnits();
        for(Unit u : allUnits){
            lstDataModel.add(new DataModel(String.valueOf(u.getId()), u.getDescription(), "", u.getCreator().getUsername()));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}