package com.example.csen704.tools;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.csen704.R;

public class SidebarListAdapter extends ArrayAdapter<CourseWrapper> {

	private final Context context;
	private final CourseWrapper[] values;

	public SidebarListAdapter(Context context, CourseWrapper[] values) {
	    super(context, R.layout.course_list_item, values);
	    this.context = context;
	    this.values = values;
	}

	 @Override
	public View getView(int position, View convertView, ViewGroup parent) {
	 	View v = convertView;

	    if (v == null) {
	        LayoutInflater vi;
	        vi = LayoutInflater.from(getContext());
	        v = vi.inflate(R.layout.course_list_item, null);
	    }

		TextView textView = (TextView) v.findViewById(R.id.course_name);
		textView.setText(values[position].toString());
		textView.setTextColor(Color.rgb(255, 255, 255));
		return v;
	 }
}
