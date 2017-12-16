package com.example.karthikkribakaran.mypantry;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MetricsMainMenu.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MetricsMainMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MetricsMainMenu extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DBHelper db;
    private OnFragmentInteractionListener mListener;

    //wasted items lists
    private List <String> wastedItems;
    private List <Double> amountWasted;
    private List <Double> moneyWasted;
    private List <String> tags;

    //wasted tags Lists
    private List <String> wastedTags;
    private ArrayList <Float> moneyWastedByTags;

    public MetricsMainMenu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MetricsMainMenu.
     */
    // TODO: Rename and change types and number of parameters
    public static MetricsMainMenu newInstance(String param1, String param2) {
        MetricsMainMenu fragment = new MetricsMainMenu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
        db=new DBHelper(this.getContext());
        getPieChart();
        //PieChart chart = (PieChart) findViewById(R.id.yearlyChart);
    }

    private void updateWastedFoodList(){
        //updates lists by calling DBhelper functions
        //updates tagslists and adds total wasted for each tag
    }

    private void getPieChart(){

        List<PieEntry> pieSlices= new ArrayList<>();
        //get items
        pieSlices.add(new PieEntry(18.5f, "Green"));
        updateWastedFoodList();
        for(int i=0; i<wastedTags.size(); i++){
            pieSlices.add(new PieEntry(moneyWastedByTags.get(i), wastedTags.get(i)));
        }

        PieDataSet dataSet =new PieDataSet(pieSlices, "Monthly Wasted Percentages By Tags");
        PieData data = new PieData(dataSet);

        //PieChart monthlypieChart = (PieChart) findViewById(R.id.monthyPieChart);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_metrics_main_menu, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
