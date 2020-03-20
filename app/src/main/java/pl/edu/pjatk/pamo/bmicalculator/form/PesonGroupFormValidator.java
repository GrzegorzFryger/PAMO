package pl.edu.pjatk.pamo.bmicalculator.form;

import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputLayout;

public class PesonGroupFormValidator {

    private TextInputLayout height;
    private TextInputLayout weight;
    private TextInputLayout age;

    public PesonGroupFormValidator(TextInputLayout height, TextInputLayout weight, TextInputLayout age) {
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    private boolean validateHeight() {
        String heightInput = height.getEditText().getText().toString().trim();

        if (heightInput.isEmpty()) {
            height.setError("Field can't be empty");
            return false;
        } else {
            height.setError(null);
            return true;
        }
    }

    private boolean validateWeight() {
        String weightInput = weight.getEditText().getText().toString().trim();

        if (weightInput.isEmpty()) {
            weight.setError("Field can't be empty");
            return false;
        } else {
            weight.setError(null);
            return true;
        }
    }

    private boolean validateAge() {
        String weightInput = age.getEditText().getText().toString().trim();

        if (weightInput.isEmpty()) {
            age.setError("Field can't be empty");
            return false;
        } else {
            age.setError(null);
            return true;
        }
    }

    public TextWatcher getHeightTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    double value = Double.parseDouble(s.toString());

                    if (value <= 0.0) {
                        height.setError("Wrong input data");
                    } else {
                        height.setError(null);
                    }

                } catch (NumberFormatException e) {
                    height.setError("Wrong input data");
                }



            }
        };
    }

    public TextWatcher getWeightTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    double value = Double.parseDouble(s.toString());
                    if (value <= 0.0) {
                        weight.setError("Wrong input data");
                    } else {
                        weight.setError(null);
                    }

                } catch (NumberFormatException e) {
                    weight.setError("Wrong input data");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    public TextWatcher getAgeTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    double value = Integer.parseInt(s.toString());
                    if (value <= 0 || value > 120) {
                        age.setError("Wrong input data");
                    } else {
                        age.setError(null);
                    }
                } catch (NumberFormatException e) {
                    age.setError("Wrong input data");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }


    public boolean isValid() {
        return validateHeight() | validateWeight() | validateAge();

    }
}
