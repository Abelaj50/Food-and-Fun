package com.example.project3app2;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class WebViewerFragment extends Fragment {

    private WebView theWebView = null;
    private int currIndex = -1;
    private int websiteArraySize;
    private String activityName;

    public WebViewerFragment(String actName) {
        //super() ;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.webview, container, false);
    }

    @Override
    public void onViewCreated (@NonNull View view, Bundle savedInstanceState){

        super.onViewCreated(view,savedInstanceState);

        /* Get reference to the WebView. */
        theWebView = (WebView) getActivity().findViewById(R.id.webView);
        theWebView.getSettings().setJavaScriptEnabled(true);    //NOTE: Added 09/19/2022
        theWebView.setWebViewClient(new WebViewClient());       //NOTE: Added 09/19/2022

        if(activityName.equals("A")) {
            websiteArraySize = AttractionsActivity.SiteWebsite.length;
        }
        else if (activityName.equals("R")){
            websiteArraySize = RestaurantsActivity.SiteWebsite.length;
        }

        /* Create a ViewModel & set the observer to handle website loading. */
        ListViewModel model = new ViewModelProvider(requireActivity()).get(ListViewModel.class);

        model.getSelectedItem().observe(getViewLifecycleOwner(), item -> {
            /* We will load the website if a valid selection has been made. */
            if(item >= 0 && item < websiteArraySize /*&& item != currIndex*/) {
                currIndex = item;

                if(activityName.equals("A")) {
                    theWebView.loadUrl(AttractionsActivity.SiteWebsite[currIndex]);
                }
                else if (activityName.equals("R")){
                    theWebView.loadUrl(RestaurantsActivity.SiteWebsite[currIndex]);
                }
            }
        });
    }

}
