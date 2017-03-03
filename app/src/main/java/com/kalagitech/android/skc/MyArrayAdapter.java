package com.kalagitech.android.skc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * Created by dell on 21-02-2017.
 */

public class MyArrayAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] names;

    static class ViewHolder {
        public TextView text;
    }

    public MyArrayAdapter(Activity context, String[] names) {
        super(context, R.layout.activity_rowlayout, names);
        this.context = context;
        this.names = names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.activity_rowlayout, null);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.tv_department_id);
            rowView.setTag(viewHolder);
        }
        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        String str = names[position];
        holder.text.setText(str);

        return rowView;
    }
}