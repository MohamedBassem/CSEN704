package com.example.csen704.fragment;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.example.csen704.R;
import com.example.csen704.base.BasePrivateActivity;
import com.example.csen704.model.Course;
import com.example.csen704.util.ApiRouter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CourseFragment extends Fragment {

	View rootView;
	CourseFragmentPagerAdapter adapter;
	ViewPager pager;
	

	long courseId;


	public CourseFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		
		courseId = getArguments().getLong("courseId");
		adapter = new CourseFragmentPagerAdapter((BasePrivateActivity) getActivity(), courseId);
		pager = (ViewPager) rootView.findViewById(R.id.pager);
		pager.setAdapter(adapter);
		

		return rootView;
	}
}

class CourseFragmentPagerAdapter extends FragmentStatePagerAdapter {
	long courseId;
	Course course;
	BasePrivateActivity activity;
	Fragment currentFragment;

    public CourseFragmentPagerAdapter(BasePrivateActivity activity, long courseId) {
        super(activity.getSupportFragmentManager());
        this.courseId = courseId;
        this.activity = activity;
   
        
    }
    
    @Override
    public Fragment getItem(int i) {

    	
    	Bundle bundle = new Bundle();
    	bundle.putLong("courseId", courseId);
    	switch(i){
    	case 0:
    		currentFragment = new CourseInfoFragment();
    		break;
    	case 1:
    		currentFragment = new AnnouncementsFragment();
    		break;
    	case 2:
    		currentFragment = new QuestionStreamFragment();
    		break;
    	case 3:
    		currentFragment = new RemindersFragment();
    		break;
    	}
    	currentFragment.setArguments(bundle);
    	return currentFragment;
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