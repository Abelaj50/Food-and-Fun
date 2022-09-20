package com.example.project3app2;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;

public class TitlesFragment extends ListFragment {
    private ListViewModel model;
    private String activityName;

    public TitlesFragment(String actName) {
        activityName = actName;
    }

    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedState) {

        super.onViewCreated(view, savedState);
        model = new ViewModelProvider(requireActivity()).get(ListViewModel.class);

        /* Set up Adapter for ListView. */
        if(activityName.equals("A")) {
            setListAdapter(new ArrayAdapter<>(getActivity(), R.layout.title, AttractionsActivity.SiteName));
        }
        else if (activityName.equals("R")){
            setListAdapter(new ArrayAdapter<>(getActivity(), R.layout.title, RestaurantsActivity.SiteName));
        }


        /* Set the list choice mode to allow only one selection at a time. */
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    /* Item click handler for Titles. */
    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int pos, long id) {

        /* Mark the item as selected. */
        getListView().setItemChecked(pos, true);

        /* Update the ViewModel with the position of the selected item. */
        model.selectItem(pos);
    }


}