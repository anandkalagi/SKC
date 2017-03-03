package com.kalagitech.android.skc;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


/**
 * Created by dell on 22-02-2017.
 */

public class CoursesFragment extends Fragment {
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    static TableLayout tlTableheader;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_courses, container, false);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) rootView.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        getActivity().setTitle("Home");
    }




    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "B.A";
                case 1:
                    return "B.COM";
            }
            return null;
        }
    }


    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_ba_courses, container, false);
            tlTableheader = (TableLayout) rootView.findViewById(R.id.table_header_id);
            writeTableColumn(getContext(),"1","Kannada","Pol.Science","Sociology");
            writeTableColumn(getContext(),"2","Kannada","Pol.Science","History");
            writeTableColumn(getContext(),"3","Kannada","History","Economics");
            writeTableColumn(getContext(),"4","English","Pol.Science","History");
            writeTableColumn(getContext(),"5","English","Pol.Science","Sociology");
            writeTableColumn(getContext(),"6","Economics","Applied Statistics","Science");
            writeTableColumn(getContext(),"7","Applied Statistics","Pol.Science","Sociology");

            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    public static void writeTableColumn(Context context, String sinum,String sub1,String sub2,String sub3) {
        TableRow tr_head = new TableRow(context);
        tr_head.setId(10);
        tr_head.setLayoutParams(new TableRow.LayoutParams(0,
                TableRow.LayoutParams.WRAP_CONTENT,1.0f));

//        tr_head.setBackgroundColor(getResources().getColor(R.color.light_blue));

        TextView label_sinum = new TextView(context);
        label_sinum.setId(20);
        label_sinum.setTextSize(12f);
        label_sinum.setText(sinum);
        label_sinum.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT,0.1f));
        label_sinum.setGravity(Gravity.CENTER);
        label_sinum.setPadding(2, 0, 5, 0);
        tr_head.addView(label_sinum);

//        getVerticalLine(tr_head);

        TextView label_sub1 = new TextView(context);
        label_sub1.setId(21);
        label_sub1.setTextSize(15f);
        label_sub1.setText(sub1);
        label_sub1.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.3f));
        label_sub1.setPadding(2, 0, 5, 0);
        label_sub1.setGravity(Gravity.CENTER);
        tr_head.addView(label_sub1);

//        getVerticalLine(tr_head);

        TextView label_sub2 = new TextView(context);
        label_sub2.setId(22);
        label_sub2.setTextSize(15f);
        label_sub2.setText(sub2);
        label_sub2.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.3f));
        label_sub2.setPadding(2, 0, 5, 0);
        label_sub2.setGravity(Gravity.CENTER);
        tr_head.addView(label_sub2);

//        getVerticalLine(tr_head);

        TextView label_sub3 = new TextView(context);
        label_sub3.setId(22);
        label_sub3.setTextSize(15f);
        label_sub3.setText(sub3);
        label_sub3.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.3f));
        label_sub3.setPadding(2, 0, 5, 0);
        label_sub3.setGravity(Gravity.CENTER);
        tr_head.addView(label_sub3);

        tlTableheader.addView(tr_head, new TableLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        getHerizontalLine(context,tlTableheader);
    }

    public static void getHerizontalLine(Context context,TableLayout tableLayout){
        View v = new View(context);
        v.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1));
        v.setBackgroundColor(Color.BLACK);
        tableLayout.addView(v);
    }
    public void getVerticalLine(TableRow tablerow){
        View v = new View(getContext());
        v.setLayoutParams(new TableRow.LayoutParams(1,TableRow.LayoutParams.MATCH_PARENT));
        v.setBackgroundColor(Color.BLACK);
        tablerow.addView(v);
    }

}
