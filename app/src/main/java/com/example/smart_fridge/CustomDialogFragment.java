package com.example.smart_fridge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.annotation.NonNull;
import android.os.Bundle;

public class CustomDialogFragment extends DialogFragment {

        @NonNull
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
            return builder .setTitle("Диалоговое окно")
                    .setTitle("Диалоговое окно")
                    .setView(R.layout.activity_custom_dialog_fragment)
                    .setPositiveButton("OK", null)
                    .setNegativeButton("Отмена", null)
                    .create();
        }



}