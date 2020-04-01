package pl.edu.pjatk.pamo.bmicalculator.quiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import pl.edu.pjatk.pamo.bmicalculator.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnQuizStartFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuizStartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizStartFragment extends Fragment {

    private OnQuizStartFragmentInteractionListener mListener;

    public QuizStartFragment() {
        // Required empty public constructor
    }

    public static QuizStartFragment newInstance() {
        QuizStartFragment fragment = new QuizStartFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_start_fragemnt, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnQuizStartFragmentInteractionListener) {
            mListener = (OnQuizStartFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnQuizStartFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnQuizStartFragmentInteractionListener {
        // TODO: Update argument type and name
        void onQuizStartFragmentInteraction(Uri uri);
    }
}
