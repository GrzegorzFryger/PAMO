package pl.edu.pjatk.pamo.bmicalculator.model;

import java.util.Map;

public class QuizQuestion {
    private String question;
    private Map<Integer,String> answers;
    private Integer idCorrectAnswer;

    public QuizQuestion(String question, Map<Integer, String> answers, Integer idCorrectAnswer) {
        this.question = question;
        this.answers = answers;
        this.idCorrectAnswer = idCorrectAnswer;
    }

    public QuizQuestion() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, String> answers) {
        this.answers = answers;
    }

    public Integer getIdCorrectAnswer() {
        return idCorrectAnswer;
    }

    public void setIdCorrectAnswer(Integer idCorrectAnswer) {
        this.idCorrectAnswer = idCorrectAnswer;
    }
}
