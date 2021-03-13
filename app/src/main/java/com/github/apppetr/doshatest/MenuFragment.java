package com.github.apppetr.doshatest;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.apppetr.doshatest.databinding.FragmentMenuBinding;

public class MenuFragment extends Fragment {


    public static FragmentMenuBinding fragmentMenuBinding;

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentMenuBinding = FragmentMenuBinding.inflate(inflater, container, false);
//        getActivity().getActionBar().hide();
        return fragmentMenuBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        fragmentMenuBinding.lilPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.HomeFragmentHandler != null)
                {
                    MainActivity.HomeFragmentHandler.sendEmptyMessage(0);
                }
                fragmentMenuBinding.iconPost.setImageResource(R.drawable.tests);
                fragmentMenuBinding.iconAccounts.setImageResource(R.drawable.results);
                fragmentMenuBinding.iconHistory.setImageResource(R.drawable.yoga);
                fragmentMenuBinding.iconSettings.setImageResource(R.drawable.music);
                fragmentMenuBinding.iconRateus.setImageResource(R.drawable.rate);
                fragmentMenuBinding.textPost.setTextColor(getResources().getColor(R.color.azure));
                fragmentMenuBinding.textAccounts.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textHistory.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textSettings.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textRateus.setTextColor(getResources().getColor(R.color.black));
            }
        });

        fragmentMenuBinding.lilAccounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.HomeFragmentHandler != null)
                {
                    MainActivity.HomeFragmentHandler.sendEmptyMessage(1);
                }

                fragmentMenuBinding.iconPost.setImageResource(R.drawable.tests);
                fragmentMenuBinding.iconAccounts.setImageResource(R.drawable.results);
                fragmentMenuBinding.iconHistory.setImageResource(R.drawable.yoga);
                fragmentMenuBinding.iconSettings.setImageResource(R.drawable.music);
                fragmentMenuBinding.iconRateus.setImageResource(R.drawable.rate);
                fragmentMenuBinding.textPost.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textAccounts.setTextColor(getResources().getColor(R.color.azure));
                fragmentMenuBinding.textHistory.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textSettings.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textRateus.setTextColor(getResources().getColor(R.color.black));
            }
        });
        fragmentMenuBinding.lilHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.HomeFragmentHandler != null)
                {
                    MainActivity.HomeFragmentHandler.sendEmptyMessage(2);
                }

                fragmentMenuBinding.iconPost.setImageResource(R.drawable.tests);
                fragmentMenuBinding.iconAccounts.setImageResource(R.drawable.results);
                fragmentMenuBinding.iconHistory.setImageResource(R.drawable.yoga);
                fragmentMenuBinding.iconSettings.setImageResource(R.drawable.music);
                fragmentMenuBinding.iconRateus.setImageResource(R.drawable.rate);
                fragmentMenuBinding.textPost.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textAccounts.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textHistory.setTextColor(getResources().getColor(R.color.azure));
                fragmentMenuBinding.textSettings.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textRateus.setTextColor(getResources().getColor(R.color.black));
            }
        });

        fragmentMenuBinding.lilSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.HomeFragmentHandler != null)
                {
                    MainActivity.HomeFragmentHandler.sendEmptyMessage(3);
                }

                fragmentMenuBinding.iconPost.setImageResource(R.drawable.tests);
                fragmentMenuBinding.iconAccounts.setImageResource(R.drawable.results);
                fragmentMenuBinding.iconHistory.setImageResource(R.drawable.yoga);
                fragmentMenuBinding.iconSettings.setImageResource(R.drawable.music);
                fragmentMenuBinding.iconRateus.setImageResource(R.drawable.rate);
                fragmentMenuBinding.textPost.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textAccounts.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textHistory.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textSettings.setTextColor(getResources().getColor(R.color.azure));
                fragmentMenuBinding.textRateus.setTextColor(getResources().getColor(R.color.black));
            }
        });

        fragmentMenuBinding.lilRateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.HomeFragmentHandler != null)
                {
                    MainActivity.HomeFragmentHandler.sendEmptyMessage(4);
                }
                fragmentMenuBinding.iconPost.setImageResource(R.drawable.tests);
                fragmentMenuBinding.iconAccounts.setImageResource(R.drawable.results);
                fragmentMenuBinding.iconHistory.setImageResource(R.drawable.yoga);
                fragmentMenuBinding.iconSettings.setImageResource(R.drawable.music);
                fragmentMenuBinding.iconRateus.setImageResource(R.drawable.rate);
                fragmentMenuBinding.textPost.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textAccounts.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textHistory.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textSettings.setTextColor(getResources().getColor(R.color.black));
                fragmentMenuBinding.textRateus.setTextColor(getResources().getColor(R.color.azure));
            }
        });
    }
}

