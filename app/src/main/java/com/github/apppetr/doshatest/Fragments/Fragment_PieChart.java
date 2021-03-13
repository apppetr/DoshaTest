package com.github.apppetr.doshatest.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import com.github.apppetr.doshatest.MainActivity;
import com.github.apppetr.doshatest.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.Arrays;

public class Fragment_PieChart extends Fragment {
    PieChart pieChart;
    ArrayList<Entry> entries;
    ArrayList<String> PieEntryLabels;
    PieDataSet pieDataSet;
    PieData pieData;
    TextView noTest;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(super.getContext());
        int vata_result = shared.getInt(MainActivity.PREFERENCE_RESULT_VATA, MainActivity.PREFERENCE_RESULT_VATA_DEFAULT);
        int pitta_result = shared.getInt(MainActivity.PREFERENCE_RESULT_PITTA, MainActivity.PREFERENCE_RESULT_PITTA_DEFAULT);
        int kapha_result = shared.getInt(MainActivity.PREFERENCE_RESULT_KAPHA, MainActivity.PREFERENCE_RESULT_KAPHA_DEFAULT);
        View view;
        view = inflater.inflate(R.layout.fragment_pie_chart, container, false);
        pieChart = (PieChart) view.findViewById(R.id.result_chart);
        noTest = (TextView) view.findViewById(R.id.textNoTest);


        if(vata_result == 0 && pitta_result == 0 && kapha_result == 0)
            noTest.setVisibility(View.VISIBLE);
        else
            noTest.setVisibility(View.INVISIBLE);

        entries = new ArrayList<>();
        PieEntryLabels = new ArrayList<String>();
        // AddValuesToPIEENTRY
        float rateVata = (float) vata_result * 100 / 38;
        float ratePitta = (float) pitta_result * 100 / 38;
        float rateKapha = (float) kapha_result * 100 / 38;

        entries.add(new BarEntry(rateVata, 0));
        entries.add(new BarEntry(ratePitta, 1));
        entries.add(new BarEntry(rateKapha, 2));

        //AddValuesToPieEntryLabels
        PieEntryLabels.add("Вата");
        PieEntryLabels.add("Питта");
        PieEntryLabels.add("Капха");

        pieDataSet = new PieDataSet(entries, "");

        pieData = new PieData(PieEntryLabels, pieDataSet);

        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        pieChart.setData(pieData);

        pieChart.animateY(3000);

        String prakrity = "";
        int[] resultArray =
                new int[]{vata_result, pitta_result, kapha_result};
        Arrays.sort(resultArray);

        SharedPreferences.Editor editor = shared.edit();
        editor.putInt(MainActivity.PREFERENCE_RESULT_MAIN, resultArray[2]);
        editor.apply();

        if (resultArray[2] == vata_result) {
            if (resultArray[2] > 19)
                prakrity = "Vata.pdf";
            else {
                if (resultArray[1] == pitta_result)
                    prakrity = "Vata_Pitta_Vata.pdf";
                if (resultArray[1] == kapha_result)
                    prakrity = "Vata_Kapha_Vata.pdf";
            }
        } else if (resultArray[2] == pitta_result) {
            if (resultArray[2] > 19)
                prakrity = "Pitta.pdf";
            else {
                if (resultArray[1] == vata_result)
                    prakrity = "Vata_Pitta_Vata.pdf";
                if (resultArray[1] == kapha_result)
                    prakrity = "Pitta_Kapha_Pitta.pdf";
            }
        } else if (resultArray[2] == kapha_result) {
            if (resultArray[2] > 19)
                prakrity = "Kapha.pdf";
            else {
                if (resultArray[1] == vata_result)
                    prakrity = "Vata_Kapha_Vata.pdf";
                if (resultArray[1] == pitta_result)
                    prakrity = "Pitta_Kapha_Pitta.pdf";
            }
        }
        return view;
    }
}
