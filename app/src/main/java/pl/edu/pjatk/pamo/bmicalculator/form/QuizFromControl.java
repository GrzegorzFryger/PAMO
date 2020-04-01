package pl.edu.pjatk.pamo.bmicalculator.form;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import pl.edu.pjatk.pamo.bmicalculator.R;
import pl.edu.pjatk.pamo.bmicalculator.model.QuizQuestion;

public class QuizFromControl {
    //view control text
    private View view;
    private TextView question;
    private TextView answer1;
    private TextView answer2;
    private TextView answer3;
    private TextView answer4;
    //view control card
    private CardView answerCard1;
    private CardView answerCard2;
    private CardView answerCard3;
    private CardView answerCard4;

    public QuizFromControl(View view) {
        this.view = view;
        this.onCreateView();
    }

    private void onCreateView() {
        this.question = this.view.findViewById(R.id.question);
        this.answer1 = this.view.findViewById(R.id.answer1);
        this.answer2 = this.view.findViewById(R.id.answer2);
        this.answer3 = this.view.findViewById(R.id.answer3);
        this.answer4 = this.view.findViewById(R.id.answer4);

        this.answerCard1 = view.findViewById(R.id.card1);
        this.answerCard2 = view.findViewById(R.id.card2);
        this.answerCard3 = view.findViewById(R.id.card3);
        this.answerCard4 = view.findViewById(R.id.card4);
    }

    public void displayQuizQuestion(QuizQuestion quizQuestion) {
        question.setText(quizQuestion.getQuestion());
        answer1.setText(quizQuestion.getAnswers().get(1));
        answer2.setText(quizQuestion.getAnswers().get(2));
        answer3.setText(quizQuestion.getAnswers().get(3));
        answer4.setText(quizQuestion.getAnswers().get(4));
    }

    public void displayCorrectAnswer(QuizQuestion quizQuestion) {

        Integer correctAnswer = quizQuestion.getIdCorrectAnswer();

        switch (correctAnswer) {
            case 1:
                answerCard1.setBackgroundResource(R.color.colorPrimaryDark);
                break;
            case 2:
                answerCard2.setBackgroundResource(R.color.colorPrimaryDark);
                break;
            case 3:
                answerCard3.setBackgroundResource(R.color.colorPrimaryDark);
                break;
            case 4:
                answerCard4.setBackgroundResource(R.color.colorPrimaryDark);
                break;
        }
    }


    public void clearColor() {
        answerCard1.setBackgroundResource(R.color.white);
        answerCard2.setBackgroundResource(R.color.white);
        answerCard3.setBackgroundResource(R.color.white);
        answerCard4.setBackgroundResource(R.color.white);
    }

    public void displayResult(int result, int numberOfQuestions) {
        String resultString = "End, Your quiz Result is " + result + "/" + numberOfQuestions;
        this.question.setText(resultString);
    }


}
