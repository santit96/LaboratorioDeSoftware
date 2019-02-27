package com.example.santi.razasypelajestettamanti;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

public class AyudaFragment extends DialogFragment {

    private AlertDialog.Builder builder;
    private int textId;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this.builder = new AlertDialog.Builder(getActivity());
        this.builder.setMessage(this.textId);
        builder.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder.create();
    }

    public void setText(int id){
        this.textId=id;
    }

}
