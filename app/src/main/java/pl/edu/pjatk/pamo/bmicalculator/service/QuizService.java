package pl.edu.pjatk.pamo.bmicalculator.service;

import java.util.List;

import pl.edu.pjatk.pamo.bmicalculator.form.QuizFromControl;
import pl.edu.pjatk.pamo.bmicalculator.model.QuizQuestion;

public class QuizService {
    private QuizFromControl quizFromControl;

    private List<QuizQuestion> quizQuestions;
    private Integer userScore;
    private Integer numberQuestions;
    private Integer currentQuestion;


    public QuizService(QuizFromControl quizFromControl, List<QuizQuestion> quizQuestions) {
        this.quizFromControl = quizFromControl;
        this.quizQuestions = quizQuestions;
        this.currentQuestion = 0;
        this.numberQuestions = quizQuestions.size();
        this.userScore = 0;
    }

    public void displayQuestion() {
        if (this.currentQuestion < this.quizQuestions.size()) {
            this.quizFromControl.displayQuizQuestion(
                    this.quizQuestions.get(this.currentQuestion)
            );
        } else this.quizFromControl.displayResult(userScore, this.quizQuestions.size());
    }


    public void next() {
        if (this.currentQuestion < this.quizQuestions.size()) {
            this.quizFromControl.clearColor();
            this.currentQuestion++;
        }
    }

    public void back() {
        if (this.currentQuestion >= 0) {
            this.userScore--;
            this.currentQuestion--;
        }
    }

    public Integer getCurrentQestion() {
        return this.currentQuestion;
    }

    public void reset() {
        this.userScore = 0;
        this.currentQuestion = 0;
    }

    public void checkAnswer(Integer answer) {
        if (this.currentQuestion < this.quizQuestions.size()) {

            if (this.quizQuestions.get(this.currentQuestion).getIdCorrectAnswer().equals(answer)) {
                this.userScore++;
            }
            this.quizFromControl.displayCorrectAnswer(this.quizQuestions.get(this.currentQuestion));
        }

    }


}
