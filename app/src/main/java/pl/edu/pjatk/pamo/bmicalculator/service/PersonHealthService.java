package pl.edu.pjatk.pamo.bmicalculator.service;

import java.util.Map;

import pl.edu.pjatk.pamo.bmicalculator.model.Bmi;
import pl.edu.pjatk.pamo.bmicalculator.model.Person;

public class PersonHealthService {
    private BmiCalculator bmiCalculator;
    private CaloriesCalculator caloriesCalculator;
    private DietRecommendationService dietRecommendationService;

    public PersonHealthService() {
        this.dietRecommendationService = new DietRecommendationService();
        this.bmiCalculator = new BmiCalculator();
        this.caloriesCalculator = new BenedictHarrisCalculator();
    }

    public Bmi calculateBmwForPerson(Person person) {
        Map.Entry<Double, String> result =
                this.bmiCalculator.calculateBmiWithCategory(person.getHeight(), person.getWeight());

        return new Bmi(result.getKey(), result.getValue());
    }

    public double calculateCalForPerson(Person person) {
       return this.caloriesCalculator.calculateBasicMetabolism(
                person.getWeight(), person.getHeight(), person.getAge(), person.getGender()
        );
    }

    public String getDishRecommendations(Person person) {
      return dietRecommendationService.recommendedDish(calculateBmwForPerson(person).getBmi());
    }

}
