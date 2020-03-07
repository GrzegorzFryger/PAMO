package pl.edu.pjatk.pamo.bmicalculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.TreeMap;

public class BmiCalculator {
    private final TreeMap<Double, String> tmp = new TreeMap<Double, String>();

    public BmiCalculator() {
        onInit();
    }

    public Map.Entry<Double, String> calculateBmiWithCategory(Double height, Double weight) {
        return tmp.floorEntry(calculateBmi(height,weight));
    }

    public Double calculateBmi(Double height, Double weight) {
        return round(
                weight / (height / 100 * height / 100)
        );
    }

    public String getCategory(Double bmi) {
       return tmp.floorEntry(bmi).getValue();
    }

    private Double round(Double val){
        return new BigDecimal(val).setScale(2, RoundingMode.FLOOR).doubleValue();
    }

    private void onInit(){
        tmp.put(0.0,"Severe Thinness");
        tmp.put(15.99,"Severe Thinness");
        tmp.put(16.00,"Moderate Thinness");
        tmp.put(17.01,"Mild Thinness");
        tmp.put(18.50,"Normal");
        tmp.put(25.01,"Overweight");
        tmp.put(30.01,"Obese Class I");
        tmp.put(35.01,"Obese Class II");
        tmp.put(40.01,"Obese Class III");
    }
}
