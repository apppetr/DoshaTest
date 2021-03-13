package com.github.apppetr.doshatest.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.github.apppetr.doshatest.DBHelper;
import com.github.apppetr.doshatest.MainActivity;
import com.github.apppetr.doshatest.Question;
import com.github.apppetr.doshatest.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import java.util.ArrayList;
import java.util.List;

public class Prakrity_Test extends Fragment {
    List<Question> quesList;
    int vata = 0;
    int pitta = 0;
    int kapha = 0;
    int qid = 0;

    Question currentQ;
    TextView txtQuestion;
    TextView textResult;
    RadioButton rda, rdb, rdc;
    Button butNext;
    Button butRestart;
    PieChart pieChart;
    ArrayList<Entry> entries;
    ArrayList<String> PieEntryLabels;
    PieDataSet pieDataSet;
    PieData pieData;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(super.getContext());
        int vata_result = shared.getInt(MainActivity.PREFERENCE_RESULT_VATA, MainActivity.PREFERENCE_RESULT_VATA_DEFAULT);
        int pitta_result = shared.getInt(MainActivity.PREFERENCE_RESULT_PITTA, MainActivity.PREFERENCE_RESULT_PITTA_DEFAULT);
        int kapha_result = shared.getInt(MainActivity.PREFERENCE_RESULT_KAPHA, MainActivity.PREFERENCE_RESULT_KAPHA_DEFAULT);
        View view;

        if ((vata_result == 0) || (kapha_result == 0) || (pitta_result == 0)) {
            view = inflater.inflate(R.layout.fragment_quiz, container, false);
            DBHelper db = new DBHelper(super.getContext());
            quesList = db.getAllQuestions();
            currentQ = quesList.get(qid);
            txtQuestion = (TextView) view.findViewById(R.id.textView1);
            rda = (RadioButton) view.findViewById(R.id.radio0);
            rdb = (RadioButton) view.findViewById(R.id.radio1);
            rdc = (RadioButton) view.findViewById(R.id.radio2);
            butNext = (Button) view.findViewById(R.id.button1);
            setQuestionView();

            butNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        RadioGroup grp = (RadioGroup) view.findViewById(R.id.radioGroup1);
                        RadioButton answer = (RadioButton) view.findViewById(grp.getCheckedRadioButtonId());
                        Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());

                        if (currentQ.getOPTA().equals(answer.getText())) {
                            vata++;
                            Log.d("vata", "Your vata" + vata);
                        }

                        if (currentQ.getOPTB().equals(answer.getText())) {
                            pitta++;
                            Log.d("pita", "Your pitta" + pitta);
                        }

                        if (currentQ.getOPTC().equals(answer.getText())) {
                            kapha++;
                            Log.d("kapha", "Your kapha" + kapha);
                        }

                    if (qid < 38) {
                        currentQ = quesList.get(qid);
                        setQuestionView();
                    } else {
                        Bundle b = new Bundle();
                        b.putInt("vata", vata); //Your vata
                        b.putInt("pitta", pitta); //Your pitta
                        b.putInt("kapha", kapha); //Your kapha

                        SharedPreferences.Editor editor = shared.edit();
                        editor.putInt(MainActivity.PREFERENCE_RESULT_VATA, vata);
                        editor.putInt(MainActivity.PREFERENCE_RESULT_PITTA, pitta);
                        editor.putInt(MainActivity.PREFERENCE_RESULT_KAPHA, kapha);

                        butNext.setEnabled(false);
                        butNext.setText(R.string.str_test_finished);
                        editor.apply();
                        return;
                    }
                }
            });
        } else {
            view = inflater.inflate(R.layout.fragment_quiz, container, false);
            TextView textResult = view.findViewById(R.id.textView1);
            textResult.setText("Вы успешно прошли тест!");
            rda = (RadioButton) view.findViewById(R.id.radio0);
            rdb = (RadioButton) view.findViewById(R.id.radio1);
            rdc = (RadioButton) view.findViewById(R.id.radio2);
            rda.setVisibility(View.INVISIBLE);
            rdb.setVisibility(View.INVISIBLE);
            rdc.setVisibility(View.INVISIBLE);

            butNext = (Button) view.findViewById(R.id.button1);
            butNext.setText(R.string.str_restart);
            butNext.setOnClickListener(new View.OnClickListener() {
                @Override
               public void onClick(View v) {
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putInt(MainActivity.PREFERENCE_RESULT_VATA, 0);
                    editor.putInt(MainActivity.PREFERENCE_RESULT_PITTA, 0);
                    editor.putInt(MainActivity.PREFERENCE_RESULT_KAPHA, 0);
                    editor.apply();
                   }
        });
        }

        return view;
    }

    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
    }
}
