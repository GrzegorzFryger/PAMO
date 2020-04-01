package pl.edu.pjatk.pamo.bmicalculator;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import pl.edu.pjatk.pamo.bmicalculator.fragments.ChartFragment;

public class ChartActivity extends AppCompatActivity implements ChartFragment.OnFragmentInteractionListener{

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        this.fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {

            ChartFragment personHealthDataFragment1 = ChartFragment.newInstance();
            this.fragmentManager.beginTransaction()
                    .add(R.id.fragment, personHealthDataFragment1).commit();
        }
    }

    @Override
    public void onChartFragmentInteraction(Uri uri) {

    }
}
