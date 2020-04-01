package pl.edu.pjatk.pamo.bmicalculator.form;

import android.view.View;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Optional;

import pl.edu.pjatk.pamo.bmicalculator.R;
import pl.edu.pjatk.pamo.bmicalculator.model.Gender;
import pl.edu.pjatk.pamo.bmicalculator.model.Person;

public class PersonFormControl {
    private View view;
    private TextInputLayout height;
    private TextInputLayout weight;
    private TextInputLayout age;
    private RadioGroup grender;

    private PesonGroupFormValidator pesonGroupFormValidator;

    public PersonFormControl(View view) {
        initLayoutObject(view);
        addListener();
    }

    private void initLayoutObject(View view) {
        this.view = view;
        height = view.findViewById(R.id.height);
        weight = view.findViewById(R.id.weight);
        grender = view.findViewById(R.id.gender);
        age = view.findViewById(R.id.age);


        this.pesonGroupFormValidator = new PesonGroupFormValidator(height,weight,age);
    }

    private void addListener() {
        height.getEditText().addTextChangedListener(this.pesonGroupFormValidator.getHeightTextWatcher());
        weight.getEditText().addTextChangedListener(this.pesonGroupFormValidator.getWeightTextWatcher());
        age.getEditText().addTextChangedListener(this.pesonGroupFormValidator.getAgeTextWatcher());
    }

    public PesonGroupFormValidator getPesonGroupFormValidator() {
        return pesonGroupFormValidator;
    }

    public void setPesonGroupFormValidator(PesonGroupFormValidator pesonGroupFormValidator) {
        this.pesonGroupFormValidator = pesonGroupFormValidator;
    }

    public Optional<Person> getPersonIfValid() {
        return Optional.ofNullable(createPerson());
    }

    private Person createPerson() {
        try {
            double weightInput = Double.parseDouble(weight.getEditText().getText().toString().trim());
            double heightInput = Double.parseDouble(height.getEditText().getText().toString().trim());
            int saInput = Integer.parseInt(age.getEditText().getText().toString().trim());
            Gender gender = createGenderFromField();
            return new Person(saInput, heightInput, weightInput, gender);
        } catch (NumberFormatException e) {
            weight.setError("Wrong input data");
            return null;
        }
    }

    private Gender createGenderFromField() {
        int selectedIndex = this.grender.indexOfChild(
                view.findViewById(this.grender.getCheckedRadioButtonId())
        );
        if (selectedIndex == 1) {
            return Gender.WOMAN;
        } else return Gender.MAN;
    }

}
