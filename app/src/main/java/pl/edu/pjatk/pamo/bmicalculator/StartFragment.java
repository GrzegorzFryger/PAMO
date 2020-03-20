package pl.edu.pjatk.pamo.bmicalculator;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import pl.edu.pjatk.pamo.bmicalculator.form.PersonForm;
import pl.edu.pjatk.pamo.bmicalculator.model.Person;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnStartFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StartFragment#newInstanceStarFragment} factory method to
 * create an instance of this fragment.
 */
public class StartFragment extends Fragment implements View.OnClickListener {
    private PersonForm personFrom;
    private Button button;
    private OnStartFragmentInteractionListener mListener;

    public StartFragment() {
    }

    public static StartFragment newInstanceStarFragment() {
        StartFragment fragment = new StartFragment();
        Bundle args = new Bundle();
        args.putString("one","one");
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
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_start, container, false);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(this);
        personFrom = new PersonForm(view);

        return view;
    }

    @Override
    public void onClick(View v) {
        personFrom.getPersonIfValid().ifPresent(person -> mListener.onStartFragmentInteraction(person));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnStartFragmentInteractionListener) {
            mListener = (OnStartFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnStartFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnStartFragmentInteractionListener {
        void onStartFragmentInteraction(Person person);
    }

}