package pl.edu.pjatk.pamo.bmicalculator.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.List;

import pl.edu.pjatk.pamo.bmicalculator.R;
import pl.edu.pjatk.pamo.bmicalculator.data.CoronavirusQuizQestions;
import pl.edu.pjatk.pamo.bmicalculator.form.QuizFromControl;
import pl.edu.pjatk.pamo.bmicalculator.model.QuizQuestion;
import pl.edu.pjatk.pamo.bmicalculator.service.QuizService;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuizFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private List<QuizQuestion> quizQuestions;
    private QuizService quizService;

    private CardView answer1;
    private CardView answer2;
    private CardView answer3;
    private CardView answer4;

    private Button nextButton;
    private Button backButton;
    private Button resetButton;


    public QuizFragment() {
        // Required empty public constructor
    }


    public static QuizFragment newInstance() {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.quizQuestions = CoronavirusQuizQestions.getQestions();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        this.answer1 = view.findViewById(R.id.card1);
        this.answer2 = view.findViewById(R.id.card2);
        this.answer3 = view.findViewById(R.id.card3);
        this.answer4 = view.findViewById(R.id.card4);

        this.nextButton = view.findViewById(R.id.next_button);
        this.backButton = view.findViewById(R.id.back_button);
        this.resetButton = view.findViewById(R.id.reset_button);

        this.answer1.setOnClickListener(this.answer1Listener());
        this.answer2.setOnClickListener(this.answer2Listener());
        this.answer3.setOnClickListener(this.answer3Listener());
        this.answer4.setOnClickListener(this.answer4Listener());

        this.nextButton.setOnClickListener(this.nextButtonListener());
        this.backButton.setOnClickListener(this.backButtonListener());
        this.resetButton.setOnClickListener(this.resetButtonListener());


        this.quizService = new QuizService(new QuizFromControl(view), this.quizQuestions);
        this.quizService.displayQuestion();

        return view;
    }

    private View.OnClickListener resetButtonListener() {
        return v -> {
            this.quizService.reset();
            this.quizService.displayQuestion();
        };
    }

    private View.OnClickListener backButtonListener() {
        return v -> {
            this.quizService.back();
            this.quizService.displayQuestion();
        };
    }

    private View.OnClickListener nextButtonListener() {
        return v -> {
            this.quizService.next();
            this.quizService.displayQuestion();
        };
    }

    private View.OnClickListener answer4Listener() {
        return v -> this.quizService.checkAnswer(4);
    }

    private View.OnClickListener answer3Listener() {
        return v -> this.quizService.checkAnswer(3);
    }

    private View.OnClickListener answer2Listener() {
        return v -> this.quizService.checkAnswer(2);
    }

    private View.OnClickListener answer1Listener() {
        return v -> this.quizService.checkAnswer(1);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onQuizFragmentInteraction(Uri uri);
    }
}
