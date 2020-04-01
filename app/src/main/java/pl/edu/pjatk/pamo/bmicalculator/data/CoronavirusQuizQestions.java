package pl.edu.pjatk.pamo.bmicalculator.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pl.edu.pjatk.pamo.bmicalculator.model.QuizQuestion;

public class CoronavirusQuizQestions {

    public static List<QuizQuestion> getQestions() {
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(
                new QuizQuestion("A virus infects a host in order to:",
                        new HashMap<Integer, String>() {{
                            put(1, "Take in nutrients");
                            put(2, "Make the host sick");
                            put(3, "Make copies of itself");
                            put(4, "Destroy the host's cells");
                        }}
                        , 3)
        );
        questions.add(
                new QuizQuestion("The distinguishing feature of a coronavirus is its:",
                        new HashMap<Integer, String>() {{
                            put(1, "Size");
                            put(2, "Mobilty");
                            put(3, "Shape");
                            put(4, "Deadliness");
                        }}
                        , 3)
        );
        questions.add(
                new QuizQuestion("A typical coronavirus infection:",
                        new HashMap<Integer, String>() {{
                            put(1, "Is extremely dangerous");
                            put(2, "Has mild symptoms");
                            put(3, "Cannot spread to humans");
                            put(4, "Is resistant to hand washing");
                        }}
                        , 2)
        );

        questions.add(
                new QuizQuestion("Coronavirus infections are likely to be more serious for:",
                        new HashMap<Integer, String>() {{
                            put(1, "Teens");
                            put(2, "Active adults");
                            put(3, "Frequent Travels");
                            put(4, "People with weakened immune system");
                        }}
                        , 4)
        );

        questions.add(
                new QuizQuestion("An outbreak of a virus occurs when:",
                        new HashMap<Integer, String>() {{
                            put(1, "Symptoms of the virus get worse");
                            put(2, "The virus spreads to more than one organ");
                            put(3, "Someone dies from the virus");
                            put(4, "The virus spreads to more and more hosts");
                        }}
                        , 1)
        );

        questions.add(
                new QuizQuestion("What does it mean when a city is quarantined during a virus outbreak?",
                        new HashMap<Integer, String>() {{
                            put(1, "Everyone in the city is infected");
                            put(2, "No one can enter or leave the city");
                            put(3, "The city’s population is immune to the virus");
                            put(4, "Doctors in the city are developing a cure");
                        }}
                        , 2)
        );


        return questions;
    }
}
