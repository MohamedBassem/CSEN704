package com.example.csen704;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

	View rootView;
	MainFragmentPagerAdapter adapter;
	ViewPager pager;


	public MainFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		adapter = new MainFragmentPagerAdapter(getActivity().getSupportFragmentManager());
		pager = (ViewPager) rootView.findViewById(R.id.pager);
		pager.setAdapter(adapter);

		return rootView;
	}
}

class MainFragmentPagerAdapter extends FragmentStatePagerAdapter {
    public MainFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

    	Fragment f = null;
    	switch(i){
    	case 0:
    		f = new AnnouncementsFragment();
    		break;
    	case 1:
    		f = new QuestionStreamFragment();
    		break;
    	case 2:
    		f = new RemindersFragment();
    		break;
    	}
    	return f;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
    	switch(position){
    	case 0:
    		return "Top Annoucements";
    	case 1:
    		return "Top Questions";
    	case 2:
    		return "Reminders";
    	}
    	return "";
    }
}