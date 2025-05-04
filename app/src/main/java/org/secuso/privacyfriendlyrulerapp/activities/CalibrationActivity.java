package org.secuso.privacyfriendlyrulerapp.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.secuso.privacyfriendlyrulerapp.R;

/**
 * Created by roberts on 21.05.16.
 */
public class CalibrationActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calibration);

//        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setTitle(R.string.calibrate);
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#024265")));

        Button confirmButton = (Button) findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence emptyInputText = getResources().getString(R.string.noInput);
                CharSequence calibrationDoneText = getResources().getString(R.string.calibrationDone);
                int duration = Toast.LENGTH_SHORT;
                Toast emptyInputToast = Toast.makeText(context, emptyInputText, duration);
                Toast calibrationDoneToast = Toast.makeText(context, calibrationDoneText, duration);

                String inputText = ((EditText) findViewById(R.id.input)).getText().toString();

                if (inputText.isEmpty()) {
                    emptyInputToast.show();
                } else {
                    float length = Float.parseFloat(inputText);
                    boolean inchMode = ((RadioButton) findViewById(R.id.inchRadioButton)).isChecked();
                    if (inchMode) {
                        length = (float) (length * 25.4);
                    }
                    length = Math.min(200, Math.max(3, length));
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    float dpmm = 300 / length;
                    prefs.edit().putFloat("dpmm", dpmm).commit();
                    calibrationDoneToast.show();
                    Intent intent = new Intent();
                    intent.setClass(getBaseContext(), RulerActivity.class);
                    startActivityForResult(intent, 0);
                }
            }
        });

    }
}
