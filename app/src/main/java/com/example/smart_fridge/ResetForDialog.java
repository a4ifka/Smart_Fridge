package com.example.smart_fridge;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.sql.SQLException;

public class ResetForDialog extends CustomDialogFragment{

    BaseDate database = new BaseDate();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textView = (TextView) getView().findViewById(R.id.textViewName);
        textView2 = (TextView) getView().findViewById(R.id.textViewDescription);



    }

}
