package com.kalagitech.android.skc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by dell on 22-02-2017.
 */

public class DepartmentProfileFragment extends Fragment {

    ListView mListView;
    String[] values = new String[] {
            "Dept. of English",
            "Dept. of Kannada",
            "Dept. of Economics",
            "Dept. of Political Science",
            "Dept. of History",
            "Dept. of Sociology",
            "Dept. of Commerce",
            "Dept. of Statistics",
            "Dept. of Library",
            "Dept. of Sports" };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dep_profile, container, false);
        mListView = (ListView) view.findViewById(R.id.list_department_profile_id);
        MyArrayAdapter myArrayAdapter = new MyArrayAdapter(getActivity(), values);
        mListView.setAdapter(myArrayAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        getActivity().setTitle("Home");
    }
}
