package org.secuso.privacyfriendlyruler.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import org.secuso.privacyfriendlyruler.R;

public class WelcomeDialog extends DialogFragment {

    boolean closeDialog = false;
    Activity activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View rootView = inflater.inflate(R.layout.welcome_dialog, null);
        builder.setView(rootView);

        builder.setIcon(R.mipmap.icon_drawer);
        builder.setTitle(getActivity().getString(R.string.welcome));

        final View rootViewFinal = rootView;

        Button okayButton = (Button) rootView.findViewById(R.id.okayButton);
        Button helpButton = (Button) rootView.findViewById(R.id.helpButton);

        okayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox readCheckBox = (CheckBox) rootViewFinal.findViewById(R.id.readCheckBox);
                if (!readCheckBox.isChecked()) {
                    Toast.makeText(activity.getBaseContext(), getString(R.string.disclaimer_check_toast), Toast.LENGTH_LONG).show();
                } else {
                   dismiss();
                }
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox readCheckBox = (CheckBox) rootViewFinal.findViewById(R.id.readCheckBox);
                if (!readCheckBox.isChecked()) {
                    Toast.makeText(activity.getBaseContext(), getString(R.string.disclaimer_check_toast), Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(getActivity(), HelpActivity.class);
                    getActivity().startActivity(i);
                    dismiss();
                }
            }
        });

//        builder.setPositiveButton(getActivity().getString(R.string.okay), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                CheckBox readCheckBox = (CheckBox) rootViewFinal.findViewById(R.id.readCheckBox);
//                if (!readCheckBox.isChecked()) {
//                    Toast.makeText(activity.getBaseContext(), getString(R.string.disclaimer_check_toast), Toast.LENGTH_LONG).show();
//                    //closeDialog = false;
//                } else {
//                    //closeDialog = true;
//                }
//            }
//        });
//        builder.setNegativeButton(getActivity().getString(R.string.viewhelp), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                CheckBox readCheckBox = (CheckBox) rootViewFinal.findViewById(R.id.readCheckBox);
//                if (!readCheckBox.isChecked()) {
//                    Toast.makeText(activity.getBaseContext(), getString(R.string.disclaimer_check_toast), Toast.LENGTH_LONG).show();
//                } else {
//                    Intent i = new Intent(getActivity(), HelpActivity.class);
//                    getActivity().startActivity(i);
//                    //closeDialog=true;
//                    dialog.cancel();
//                }
//            }
//        });

        return builder.create();
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        AlertDialog dialog = (AlertDialog) getDialog();
//        if (dialog != null) {
//            Button positiveButton = dialog.getButton(Dialog.BUTTON_POSITIVE);
//            positiveButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (closeDialog) {
//                        dismiss();
//                    }
//
//                }
//            });
//
//            Button negativeButton = dialog.getButton(Dialog.BUTTON_NEGATIVE);
//            negativeButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (closeDialog) {
//                        dismiss();
//                    }
//
//                }
//            });
//        }
//    }
}

