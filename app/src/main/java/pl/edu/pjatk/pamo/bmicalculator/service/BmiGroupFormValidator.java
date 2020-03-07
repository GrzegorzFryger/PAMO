package pl.edu.pjatk.pamo.bmicalculator.service;

import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputLayout;

public class BmiGroupFormValidator {

    private TextInputLayout height;
    private TextInputLayout weight;

    public BmiGroupFormValidator(TextInputLayout height, TextInputLayout weight) {
        this.height = height;
        this.weight = weight;
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

    public TextWatcher getHeightTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    double value = Double.parseDouble(s.toString());
                    if(value < 0.0) {
                        height.setError("Wrong input data");
                    }
                } catch (NumberFormatException e) {
                    height.setError("Wrong input data");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

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
                    if(value < 0.0) {
                        weight.setError("Wrong input data");
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

    public boolean isValid() {
        return  validateHeight() | validateWeight();

    }
}
