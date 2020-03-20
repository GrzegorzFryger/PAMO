package pl.edu.pjatk.pamo.bmicalculator.form;

public class Bmi {
    private Double bmi;
    private String description;

    public Bmi(Double bmi, String description) {
        this.bmi = bmi;
        this.description = description;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Bmi{" +
                "bmi=" + bmi +
                ", description='" + description + '\'' +
                '}';
    }
}
