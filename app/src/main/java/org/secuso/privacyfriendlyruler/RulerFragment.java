package org.secuso.privacyfriendlyruler;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by roberts on 02.06.16.
 */
public class RulerFragment extends Fragment {

    Activity activity;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_ruler, container, false);
        container.removeAllViews();

        RulerView rulerView = new RulerView(activity.getBaseContext(), activity);
        RelativeLayout rulerLayout = (RelativeLayout) rootView.findViewById(R.id.fragment_ruler);
        rulerLayout.addView(rulerView);

        return rootView;
    }


    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

}