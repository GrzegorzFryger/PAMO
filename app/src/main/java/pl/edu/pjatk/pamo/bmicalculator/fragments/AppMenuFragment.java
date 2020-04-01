package pl.edu.pjatk.pamo.bmicalculator.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import pl.edu.pjatk.pamo.bmicalculator.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AppMenuFragment.OnAppMenuFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AppMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppMenuFragment extends Fragment {
    private CardView personalHealthCardView;
    private CardView quizCardView;
    private CardView chartCardView;

    private OnAppMenuFragmentInteractionListener mListener;

    public AppMenuFragment() {
        // Required empty public constructor
    }

    public static AppMenuFragment newInstance() {
        AppMenuFragment fragment = new AppMenuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_app_menu, container, false);

        this.personalHealthCardView = view.findViewById(R.id.personal_health);
        this.quizCardView = view.findViewById(R.id.quiz);
        this.chartCardView = view.findViewById(R.id.charts);


        this.personalHealthCardView.setOnClickListener(this.personHealthListener());
        this.quizCardView.setOnClickListener(this.quizListener());
        this.chartCardView.setOnClickListener(this.chartListener());

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAppMenuFragmentInteractionListener) {
            mListener = (OnAppMenuFragmentInteractionListener) context;
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

    public interface OnAppMenuFragmentInteractionListener {
        void onAppMenuInteraction(Menu selected);
    }

    public enum Menu {
        HEALTH,QUIZ,CHART
    }

    private View.OnClickListener personHealthListener() {
        return v -> this.mListener.onAppMenuInteraction(Menu.HEALTH);
    }

    private View.OnClickListener quizListener() {
        return v -> this.mListener.onAppMenuInteraction(Menu.QUIZ);
    }

    private View.OnClickListener chartListener() {
        return v -> this.mListener.onAppMenuInteraction(Menu.CHART);
    }
}
