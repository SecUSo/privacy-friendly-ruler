package org.secuso.privacyfriendlyrulerapp.helpers;

import android.content.Context;

import org.secuso.privacyfriendlyrulerapp.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Class structure taken from tutorial at http://www.journaldev.com/9942/android-expandablelistview-example-tutorial
 * last access 27th October 2016
 */

public class HelpDataDump {

    private Context context;

    public HelpDataDump(Context context) {
        this.context = context;
    }

    public LinkedHashMap<String, List<String>> getDataGeneral() {
        LinkedHashMap<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();

        List<String> general = new ArrayList<String>();
        general.add(context.getResources().getString(R.string.help_intro));
        general.add(context.getResources().getString(R.string.pref_units_summary));
        general.add(context.getResources().getString(R.string.pref_angles_summary));
        expandableListDetail.put(context.getResources().getString(R.string.help_overview_heading), general);


        List<String> calibration = new ArrayList<String>();
        calibration.add(context.getResources().getString(R.string.pref_calibration_summary));
        expandableListDetail.put(context.getResources().getString(R.string.help_calibration), calibration);

        List<String> privacy = new ArrayList<String>();
        privacy.add(context.getResources().getString(R.string.help_permissions_description));
        expandableListDetail.put(context.getResources().getString(R.string.help_permissions_heading), privacy);

        List<String> disclaimer = new ArrayList<String>();
        disclaimer.add(context.getResources().getString(R.string.disclaimer));
        expandableListDetail.put(context.getResources().getString(R.string.help_disclaimer), disclaimer);


        return expandableListDetail;
    }

}
