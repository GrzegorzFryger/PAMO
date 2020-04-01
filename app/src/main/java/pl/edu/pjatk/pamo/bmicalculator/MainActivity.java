package pl.edu.pjatk.pamo.bmicalculator;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import pl.edu.pjatk.pamo.bmicalculator.bmi.BmiActivity;
import pl.edu.pjatk.pamo.bmicalculator.quiz.QuizActivity;


public class MainActivity extends AppCompatActivity implements AppMenuFragment.OnAppMenuFragmentInteractionListener {
    private Bundle bundle;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bundle = savedInstanceState;
        setContentView(R.layout.activity_main);


        this.fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {

            AppMenuFragment personHealthDataFragment1 = AppMenuFragment.newInstance();
            this.fragmentManager.beginTransaction()
                    .add(R.id.fragment, personHealthDataFragment1).commit();
        }
    }

    @Override
    public void onAppMenuInteraction(AppMenuFragment.Menu selected) {

        switch (selected) {
            case HEALTH:
                Intent i = new Intent(getBaseContext(), BmiActivity.class);
                startActivity(i);
                break;
            case QUIZ:
                Intent quiz = new Intent(getBaseContext(), QuizActivity.class);
                startActivity(quiz);
                break;
            case CHART:
                Intent ii = new Intent(getBaseContext(), BmiActivity.class);
                startActivity(ii);
                break;

        }


    }
}
