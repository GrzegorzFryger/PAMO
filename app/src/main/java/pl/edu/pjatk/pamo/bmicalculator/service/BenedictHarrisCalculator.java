package pl.edu.pjatk.pamo.bmicalculator.service;

import pl.edu.pjatk.pamo.bmicalculator.model.Gender;

public class BenedictHarrisCalculator implements CaloriesCalculator {
    @Override
    public double calculateBasicMetabolism(double weight, double height, double age, Gender gender) {
        double result;
        if (Gender.MAN.equals(gender)) {
            result = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);
        } else {
            result = 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
        }
        return result;
    }
}
