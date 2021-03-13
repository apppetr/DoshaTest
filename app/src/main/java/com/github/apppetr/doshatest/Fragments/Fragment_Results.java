package com.github.apppetr.doshatest.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.github.apppetr.doshatest.Fragments.food.DoshaDescr;
import com.github.apppetr.doshatest.Fragments.food.DoshaDiff;
import com.github.apppetr.doshatest.Fragments.food.Food;
import com.github.apppetr.doshatest.Fragments.food.Taste;
import com.github.apppetr.doshatest.R;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class Fragment_Results extends Fragment {
    private TabLayout mTablayout;
    private ViewPager mViewPager;
    View view;
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //  View view = inflater.inflate(R.layout.fragment1, container);
        view = inflater.inflate(R.layout.fragment_result_tabs, container, false);
        // setListAdapter(new MenuListAdapter(R.layout.row_menu_action_item, getActivity(), MenuActionItem.values()));
        mTablayout = view.findViewById(R.id.tabLayout);
        mViewPager = view.findViewById(R.id.viewPager);
        setupViewPager(mViewPager);
        mTablayout.setupWithViewPager(mViewPager);
        return view;
    }

    private void setupViewPager(ViewPager viewPager){
       viewPagerAdapter adapter = new viewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Fragment_PieChart(),"Доши");
        adapter.addFragment(new DoshaDescr(),"Описание");
        adapter.addFragment(new DoshaDiff(),"Отличия");
        adapter.addFragment(new Food(),"Питание");
        adapter.addFragment(new Taste(),"Вкусы");
        viewPager.setAdapter(adapter);
    }

    class viewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTittleList = new ArrayList<>();

        public viewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment (Fragment fragment, String tittle){
            mFragmentList.add(fragment);
            mFragmentTittleList.add(tittle);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTittleList.get(position);
        }
    }
}
