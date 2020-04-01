package pl.edu.pjatk.pamo.bmicalculator;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import pl.edu.pjatk.pamo.bmicalculator.fragments.PersonHealthDataFragment;
import pl.edu.pjatk.pamo.bmicalculator.fragments.PersonHealthResultFragment;
import pl.edu.pjatk.pamo.bmicalculator.model.Person;

import static pl.edu.pjatk.pamo.bmicalculator.fragments.PersonHealthDataFragment.newInstanceStarFragment;
import static pl.edu.pjatk.pamo.bmicalculator.fragments.PersonHealthResultFragment.newInstancePersonHealthResult;

public class BmiActivity extends AppCompatActivity implements PersonHealthDataFragment.OnStartFragmentInteractionListener, PersonHealthResultFragment.OnPersonHealthResultListener {
    private FragmentManager fragmentManager;

    private Person person = new Person();
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);


        this.fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {

            PersonHealthDataFragment personHealthDataFragment1 = newInstanceStarFragment();
            this.fragmentManager.beginTransaction()
                    .add(R.id.fragment, personHealthDataFragment1).commit();
        }

    }

    @Override
    public void onStartFragmentInteraction(Person person) {
        this.person = person;

        PersonHealthResultFragment personHealthResultFragment = newInstancePersonHealthResult(person);

        this.fragmentManager.beginTransaction()
                .replace(R.id.fragment, personHealthResultFragment).commit();

    }


    @Override
    public void OnPersonHealthResultFragmentInteraction(Uri uri) {

    }

}
