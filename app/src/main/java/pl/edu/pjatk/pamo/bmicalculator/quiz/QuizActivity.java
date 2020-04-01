package pl.edu.pjatk.pamo.bmicalculator.quiz;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import pl.edu.pjatk.pamo.bmicalculator.R;

public class QuizActivity extends AppCompatActivity implements QuizFragment.OnFragmentInteractionListener, QuizStartFragment.OnQuizStartFragmentInteractionListener {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        this.fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {

            QuizFragment personHealthDataFragment1 = QuizFragment.newInstance();
            this.fragmentManager.beginTransaction()
                    .add(R.id.fragment, personHealthDataFragment1).commit();
        }


    }

    @Override
    public void onQuizStartFragmentInteraction(Uri uri) {

    }

    @Override
    public void onQuizFragmentInteraction(Uri uri) {

    }
}
