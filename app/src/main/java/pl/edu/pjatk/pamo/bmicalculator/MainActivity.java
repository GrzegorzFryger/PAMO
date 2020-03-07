package pl.edu.pjatk.pamo.bmicalculator;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

import pl.edu.pjatk.pamo.bmicalculator.model.Person;
import pl.edu.pjatk.pamo.bmicalculator.service.BmiCalculator;
import pl.edu.pjatk.pamo.bmicalculator.service.BmiGroupFormValidator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private BmiCalculator bmiCalculator;
    private BmiGroupFormValidator bmiGroupFormValidator;

    private TextInputLayout height;
    private TextInputLayout weight;
    private Button button;
    private TextView ouput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initLayoutObject();
        initObject();
        addListener();
    }

    private void initLayoutObject(){
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        button = findViewById(R.id.button);
        ouput = findViewById(R.id.output);
    }

    private void initObject() {
        bmiGroupFormValidator = new BmiGroupFormValidator(height,weight);
        bmiCalculator = new BmiCalculator();
    }

    private void addListener() {
        height.getEditText().addTextChangedListener(bmiGroupFormValidator.getHeightTextWatcher());
        weight.getEditText().addTextChangedListener(bmiGroupFormValidator.getWeightTextWatcher());
        button.setOnClickListener(this);
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
    public void onClick(View v) {
        if(!bmiGroupFormValidator.isValid()) {
            return;
        }

        Person person = createPerson();

        Map.Entry<Double,String> bmi = bmiCalculator.calculateBmiWithCategory(
                        person.getHeight(),
                        person.getWeight()
                );

        ouput.setText("Your bmi is : " + bmi.getKey()+ " : " + bmi.getValue() );
    }

    private Person createPerson() {
        try {
            double weightInput = Double.parseDouble(weight.getEditText().getText().toString().trim());
            double heightInput = Double.parseDouble(height.getEditText().getText().toString().trim());
            return new Person(heightInput, weightInput);
        } catch (NumberFormatException e) {
            weight.setError("Wrong input data");
            return null;
        }

    }




}
