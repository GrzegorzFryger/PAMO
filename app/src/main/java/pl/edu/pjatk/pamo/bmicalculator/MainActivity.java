package pl.edu.pjatk.pamo.bmicalculator;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import pl.edu.pjatk.pamo.bmicalculator.model.Person;

import static pl.edu.pjatk.pamo.bmicalculator.PersonHealthInfo.newInstancePersonHealthInfo;
import static pl.edu.pjatk.pamo.bmicalculator.StartFragment.newInstanceStarFragment;

public class MainActivity extends AppCompatActivity implements StartFragment.OnStartFragmentInteractionListener, PersonHealthInfo.OnPersonHealthInfoListener {
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

            StartFragment startFragment1 = newInstanceStarFragment();
            this.fragmentManager.beginTransaction()
                    .add(R.id.fragment, startFragment1).commit();
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

        PersonHealthInfo personHealthInfo = newInstancePersonHealthInfo(person);

        this.fragmentManager.beginTransaction()
                .replace(R.id.fragment, personHealthInfo).commit();

    }

    @Override
    public void OnPersonHealthInfoFragmentInteraction(Uri uri) {

    }
}
