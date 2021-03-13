package com.github.apppetr.doshatest.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import com.github.apppetr.doshatest.MainActivity;
import com.github.apppetr.doshatest.Yoga.PoseFive;
import com.github.apppetr.doshatest.Yoga.PoseFour;
import com.github.apppetr.doshatest.Yoga.PoseOne;
import com.github.apppetr.doshatest.Yoga.PoseSeven;
import com.github.apppetr.doshatest.Yoga.PoseSix;
import com.github.apppetr.doshatest.Yoga.PoseThree;
import com.github.apppetr.doshatest.Yoga.PoseTwo;
import com.github.apppetr.doshatest.R;

public class Yoga_Fragment extends Fragment {
    View view;
    ListView listView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(super.getContext());
        int main_result = shared.getInt(MainActivity.PREFERENCE_RESULT_MAIN, MainActivity.PREFERENCE_RESULT_MAIN_DEFAULT);
        int vata_result = shared.getInt(MainActivity.PREFERENCE_RESULT_VATA, MainActivity.PREFERENCE_RESULT_VATA_DEFAULT);
        int pitta_result = shared.getInt(MainActivity.PREFERENCE_RESULT_PITTA, MainActivity.PREFERENCE_RESULT_PITTA_DEFAULT);
        int kapha_result = shared.getInt(MainActivity.PREFERENCE_RESULT_KAPHA, MainActivity.PREFERENCE_RESULT_KAPHA_DEFAULT);

        view = inflater.inflate(R.layout.activity_yoga_list, container, false);
        listView = view.findViewById(R.id.listView);
        if (main_result == vata_result) {

            String[] mTitle = {"Поза трупа", "Поза посоха","Поза дерева"};
            int[] images = {R.drawable.corpse, R.drawable.staff, R.drawable.tree};
            String[] mDescription = {"Для расслабления тела", "Для стабильного и здорового тела ", "Для улучшения баланса и внимательности "};

            MyAdapter adapter = new MyAdapter(view.getContext(), mTitle, mDescription, images);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0){
                        Intent intent = new Intent(view.getContext(), PoseOne.class);
                        startActivity(intent);
                    }
                    if (position == 1){
                        Intent intent = new Intent(view.getContext(), PoseTwo.class);
                        startActivity(intent);
                    }
                    if (position == 2){
                        Intent intent = new Intent(view.getContext(), PoseThree.class);
                        startActivity(intent);
                    }
                }
            });

        } else if (main_result == pitta_result) {

            String[] mTitle = {"Поза мост", "Поза ребенка","Поза кобры"};
            int[] images = {R.drawable.bridge, R.drawable.child, R.drawable.cobra};
            String[] mDescription = {"Уменьшает перепады настроения ", "Помогает снять усталость", "Для поднятия настроения"};
            MyAdapter adapter = new MyAdapter(view.getContext(), mTitle, mDescription, images);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0){
                        Intent intent = new Intent(view.getContext(), PoseFour.class);
                        startActivity(intent);
                    }
                    if (position == 1){
                        Intent intent = new Intent(view.getContext(), PoseFive.class);
                        startActivity(intent);
                    }
                    if (position == 2){
                        Intent intent = new Intent(view.getContext(), PoseSix.class);
                        startActivity(intent);
                    }
                }
            });

        } else if (main_result == kapha_result) {

            String[] mTitle = {"Поза воина", "Поза дерева","Поза кобры"};
            int[] images = {R.drawable.warrior, R.drawable.child, R.drawable.cobra};
            String[] mDescription = {"Развивтие концентрации ", "Для улучшения баланса и внимательности ", "Для поднятия настроения"};
            MyAdapter adapter = new MyAdapter(view.getContext(), mTitle, mDescription, images);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0){
                        Intent intent = new Intent(view.getContext(), PoseSeven.class);
                        startActivity(intent);
                    }
                    if (position == 1){
                        Intent intent = new Intent(view.getContext(), PoseThree.class);
                        startActivity(intent);
                    }
                    if (position == 2){
                        Intent intent = new Intent(view.getContext(), PoseSix.class);
                        startActivity(intent);
                    }
                }
            });
        }
        return view;
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String[] rTitle;
        String[] rDescription;
        int[] rImgs;


        MyAdapter (Context c, String[] title, String[] description, int[] imgs) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)Yoga_Fragment.this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            return row;
        }
    }
    public void finish(View view) {

        finish(view);
    }
}
