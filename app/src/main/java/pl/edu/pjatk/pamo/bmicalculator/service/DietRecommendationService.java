package pl.edu.pjatk.pamo.bmicalculator.service;

public class DietRecommendationService {
    private static double NORMAL_DOWN_VALUE = 17.2;
    private static double NORMAL_TOP_VALUE = 30.0;

    public DietRecommendationService() {
    }

    public String recommendedDish(double bmi) {
        if (bmi < NORMAL_DOWN_VALUE) {
            return "Eat more pizza";
        } else if (NORMAL_DOWN_VALUE > bmi && bmi > NORMAL_TOP_VALUE) {
            return "Eat pizza and vegetables";
        } else {
            return "Eat vegetables";
        }
    }

}
