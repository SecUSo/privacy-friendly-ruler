package org.secuso.privacyfriendlyrulerapp.activities;

import android.os.Bundle;
import android.widget.ExpandableListView;

import org.secuso.privacyfriendlyrulerapp.R;
import org.secuso.privacyfriendlyrulerapp.helpers.ExpandableListAdapter;
import org.secuso.privacyfriendlyrulerapp.helpers.HelpDataDump;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Class structure taken from tutorial at http://www.journaldev.com/9942/android-expandablelistview-example-tutorial
 * last access 27th October 2016
 */

public class HelpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        ExpandableListAdapter expandableListAdapter;
        HelpDataDump helpDataDump = new HelpDataDump(this);

        ExpandableListView generalExpandableListView = (ExpandableListView) findViewById(R.id.generalExpandableListView);

        LinkedHashMap<String, List<String>> expandableListDetail = helpDataDump.getDataGeneral();
        List<String> expandableListTitleGeneral = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new ExpandableListAdapter(this, expandableListTitleGeneral, expandableListDetail);
        generalExpandableListView.setAdapter(expandableListAdapter);

        overridePendingTransition(0, 0);
    }

    protected int getNavigationDrawerID() {
        return R.id.nav_help;
    }

}