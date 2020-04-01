package pl.edu.pjatk.pamo.bmicalculator.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import pl.edu.pjatk.pamo.bmicalculator.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChartFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ChartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChartFragment extends Fragment {
    private static String HTTP_ADDRESS = "https://www.statista.com/statistics/1043366/novel-coronavirus-2019ncov-cases-worldwide-by-country/?fbclid=IwAR12z_y6B_oMoUd2tBeAePKpWVAkMbjxSg3Eh26ecidPbVJ2D00_G5cbCeU";
    private WebView webview;
    private OnFragmentInteractionListener mListener;

    public ChartFragment() {
        // Required empty public constructor
    }

    public static ChartFragment newInstance() {
        ChartFragment fragment = new ChartFragment();
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

        View view = inflater.inflate(R.layout.fragment_chart, container, false);


        webview =view.findViewById(R.id.webView1);

        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webview.loadUrl(HTTP_ADDRESS);

        return view;
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
        void onChartFragmentInteraction(Uri uri);
    }
}
