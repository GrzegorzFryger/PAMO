package pl.edu.pjatk.pamo.bmicalculator;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import pl.edu.pjatk.pamo.bmicalculator.fragments.QuizFragment;

public class QuizActivity extends AppCompatActivity implements QuizFragment.OnFragmentInteractionListener{
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        this.fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {

            QuizFragment quizFragment = QuizFragment.newInstance();
            this.fragmentManager.beginTransaction()
                    .add(R.id.fragment, quizFragment).commit();
        }
    }

    @Override
    public void onQuizFragmentInteraction(Uri uri) {

    }
}
