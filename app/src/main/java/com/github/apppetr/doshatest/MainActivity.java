package com.github.apppetr.doshatest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.github.apppetr.doshatest.Fragments.Prakrity_Test;
import com.github.apppetr.doshatest.Fragments.Yoga_Fragment;
import com.github.apppetr.doshatest.Fragments.MusicFragment;
import com.github.apppetr.doshatest.Fragments.Fragment_Results;
import com.github.apppetr.doshatest.RateUs.LoveOurAppRateActivity;

public class MainActivity extends AppCompatActivity{
    private boolean isTransactionSafe;
    public static String PREFERENCE_RESULT_VATA = "result_vata";
    public static int PREFERENCE_RESULT_VATA_DEFAULT = 0;
    public static String PREFERENCE_RESULT_PITTA = "result_pitta";
    public static int PREFERENCE_RESULT_PITTA_DEFAULT = 0;
    public static String PREFERENCE_RESULT_KAPHA = "result_kapha";
    public static int PREFERENCE_RESULT_KAPHA_DEFAULT = 0;
    public static String PREFERENCE_RESULT_MAIN = "result_main";
    public static int PREFERENCE_RESULT_MAIN_DEFAULT = 0;

    //Boolean variable to mark if there is any transaction pending
    private boolean isTransactionPending;
    FrameLayout flContent;
    Fragment fragment = null;
    public static Class fragmentClass;
    public static Handler HomeFragmentHandler;
    SlidingPaneLayout sliding_pane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flContent = (FrameLayout)findViewById(R.id.flContent);

        sliding_pane = (SlidingPaneLayout)findViewById(R.id.sliding_pane);

        sliding_pane.setSliderFadeColor(getResources().getColor(android.R.color.transparent));
        //  sliding_pane.openPane();

        fragmentClass = Prakrity_Test.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(MenuFragment.fragmentMenuBinding != null)
        {
            MenuFragment.fragmentMenuBinding.lilPost.performClick();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        transaction.replace(R.id.flContent, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

        HomeFragmentHandler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 0:
                    {
                        if(isTransactionSafe) {
                            fragmentClass = Prakrity_Test.class;
                            try {
                                fragment = (Fragment) fragmentClass.newInstance();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            FragmentTransaction transaction = fragmentManager.beginTransaction();
                            transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
                            transaction.replace(R.id.flContent, fragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                        else
                        {
                            isTransactionPending=true;
                        }
                        break;
                    }
                    case 1:
                    {
                        if(isTransactionSafe) {
                            fragmentClass = Fragment_Results.class;
                            try {
                                fragment = (Fragment) fragmentClass.newInstance();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            FragmentTransaction transaction = fragmentManager.beginTransaction();
                            transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
                            transaction.replace(R.id.flContent, fragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                        else
                        {
                            isTransactionPending=true;
                        }
                        //  fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
                        //  setListViewHeightBasedOnChildren(fragmentHomeBinding.listView);
                        break;
                    }
                    case 2:
                    {
                        if(isTransactionSafe) {
                            fragmentClass = Yoga_Fragment.class;
                            try {
                                fragment = (Fragment) fragmentClass.newInstance();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            FragmentTransaction transaction = fragmentManager.beginTransaction();
                            transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
                            transaction.replace(R.id.flContent, fragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                        else
                        {
                            isTransactionPending=true;
                        }
                        // fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
                        break;
                    }
                    case 3:
                    {
                        if(isTransactionSafe) {
                            fragmentClass = MusicFragment.class;
                            try {
                                fragment = (Fragment) fragmentClass.newInstance();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            FragmentTransaction transaction = fragmentManager.beginTransaction();
                            transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
                            transaction.replace(R.id.flContent, fragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                        else
                        {
                            isTransactionPending=true;
                        }
                        // fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
                        break;
                    }
                    case 4:
                    {
                        if(isTransactionSafe) {
                         Intent i = new Intent(MainActivity.this, LoveOurAppRateActivity.class);
                         i.putExtra("appPackageName", getApplicationContext().getPackageName());
                            startActivity(i);
                        }
                        else
                        {
                            isTransactionPending=true;
                        };
                        break;
                    }

                }
            }
        };
    }

    public void onPostResume(){
        super.onPostResume();
        isTransactionSafe=true;
    }


    public void onPause(){
        super.onPause();
        isTransactionSafe=false;
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}