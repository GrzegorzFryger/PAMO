package pl.edu.pjatk.pamo.bmicalculator;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import pl.edu.pjatk.pamo.bmicalculator.model.Person;

import static pl.edu.pjatk.pamo.bmicalculator.PersonHealthDataFragment.newInstanceStarFragment;
import static pl.edu.pjatk.pamo.bmicalculator.PersonHealthResultFragment.newInstancePersonHealthResult;

public class MainActivity extends AppCompatActivity implements PersonHealthDataFragment.OnStartFragmentInteractionListener, PersonHealthResultFragment.OnPersonHealthResultListener {
    private FragmentManager fragmentManager;

    private Person person = new Person();
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bundle = savedInstanceState;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {

            PersonHealthDataFragment personHealthDataFragment1 = newInstanceStarFragment();
            this.fragmentManager.beginTransaction()
                    .add(R.id.fragment, personHealthDataFragment1).commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
