package com.example.csen704.fragment;

import com.example.csen704.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CourseFragment extends Fragment {

	View rootView;
	CourseFragmentPagerAdapter adapter;
	ViewPager pager;

	int courseId;


	public CourseFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		adapter = new CourseFragmentPagerAdapter(getActivity().getSupportFragmentManager(), courseId);
		pager = (ViewPager) rootView.findViewById(R.id.pager);
		pager.setAdapter(adapter);

		courseId = getArguments().getInt("courseId");

		return rootView;
	}
}

class CourseFragmentPagerAdapter extends FragmentStatePagerAdapter {
	int couseId;

    public CourseFragmentPagerAdapter(FragmentManager fm, int courseId) {
        super(fm);
        this.couseId = courseId;
    }

    @Override
    public Fragment getItem(int i) {

    	Fragment f = null;
    	Bundle bundle = new Bundle();
    	bundle.putInt("courseId", couseId);
    	switch(i){
    	case 0:
    		f = new CourseInfoFragment();
    		break;
    	case 1:
    		f = new AnnouncementsFragment();
    		break;
    	case 2:
    		f = new QuestionStreamFragment();
    		break;
    	case 3:
    		f = new RemindersFragment();
    		break;
    	}
    	f.setArguments(bundle);
    	return f;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
    	switch(position){
    	case 0:
    		return "Course Info";
    	case 1:
    		return "Annoucements";
    	case 2:
    		return "Questions";
    	case 3:
    		return "Reminders";
    	}
    	return "";
    }
}