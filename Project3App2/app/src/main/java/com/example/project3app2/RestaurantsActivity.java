package com.example.project3app2;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

public class RestaurantsActivity extends FragmentActivity {

    public static String[] SiteName;
    public static String[] SiteWebsite;
    private final WebViewerFragment WebsiteFragment = new WebViewerFragment("R");
    private FragmentManager theFragmentManager;
    private FrameLayout TitleFrameLayout, WebFrameLayout;
    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
    private boolean itemSelected = false;   //NOTE: Added 09/19/2022

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        IntentFilter intentFilter1 = new IntentFilter("com.abelabraham.broadcast1attractions");
        AttractionsReceiver attRec = new AttractionsReceiver();
        registerReceiver(attRec, intentFilter1);

        IntentFilter intentFilter2 = new IntentFilter("com.abelabraham.broadcast2restaurants");
        RestaurantsReceiver resRec = new RestaurantsReceiver();
        registerReceiver(resRec, intentFilter2);

        /* Sets the contents of the arrays to their required values. */
        SiteName = getResources().getStringArray(R.array.RestaurantArray);
        SiteWebsite = getResources().getStringArray(R.array.RestaurantWebsites);

        /* Get references to the titleFrag and the webFrag. */
        TitleFrameLayout = (FrameLayout) findViewById(R.id.titleFrag);
        WebFrameLayout = (FrameLayout) findViewById(R.id.webFrag);

        /* Create and add in a new instance of a TitlesFragment. */
        theFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = theFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.titleFrag, new TitlesFragment("R"));
        fragmentTransaction.commit();
        theFragmentManager.executePendingTransactions();

        /* Set the OnBackStackChangedListener to reset the layout when the backstack changes. */
        theFragmentManager.addOnBackStackChangedListener(this::setLayout);

        /* Create a ViewModel & set the observer to handle WebViewerFragment creation/deletion. */
        ListViewModel theViewModel = new ViewModelProvider(this).get(ListViewModel.class);

        theViewModel.getSelectedItem().observe(this, item -> {
            if (!WebsiteFragment.isAdded()) {
                FragmentTransaction fragmentTransaction2 = theFragmentManager.beginTransaction() ;
                fragmentTransaction2.add(R.id.webFrag, WebsiteFragment);    //May need to change to replace
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
                theFragmentManager.executePendingTransactions();
            }
        });

        setLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.attractions:
                intent = new Intent(this, AttractionsActivity.class);
                startActivity(intent);
                return true;
            case R.id.restaurants:
                intent = new Intent(this, RestaurantsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* This method will dynamically resize the Fragment views based on  */
    private void setLayout() {

        /* If the WebsiteFragment has not been added to the activity yet (Title not clicked)
            OR the user presses the back button (to reset the original title-only view). */
        if (!WebsiteFragment.isAdded()) {
            TitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));
            WebFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT));

            // NOTE: Added following code 09/19/2022
            /* This body of code will be executed when an item has been previously selected and the
                user presses the back button, in order to clear the selected item. */
            if(itemSelected) {
                TitlesFragment clearFrag = (TitlesFragment) theFragmentManager.findFragmentById(R.id.titleFrag);
                if(clearFrag != null && clearFrag.getListView().getCheckedItemCount() > 0) {
                    clearFrag.getListView().clearChoices();
                    itemSelected = false;
                }
            }
        }

        /* If a title has been selected, and the WebsiteFragment has been added to the activity. */
        else {
            TitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT, 1f));
            WebFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT, 2f));
            itemSelected = true;    //NOTE: Added 09/19/2022
        }
    }

}