package pl.edu.pjatk.pamo.bmicalculator.service;

import pl.edu.pjatk.pamo.bmicalculator.model.Gender;

public interface CaloriesCalculator {
    double calculateBasicMetabolism(double weight, double height, double age, Gender gender);
}
