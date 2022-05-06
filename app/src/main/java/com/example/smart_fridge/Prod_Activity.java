package com.example.smart_fridge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class Prod_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod);

        EditText edt = findViewById(R.id.edt);
        Button btn = findViewById(R.id.btnAddDB);

        EditText edt2 = findViewById(R.id.edt2);
        Button btn2 = findViewById(R.id.btnAddDB2);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameProd;

                nameProd = edt.getText().toString();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameProd2;

                nameProd2 = edt2.getText().toString();

            }
        });

    }
    public void showDialog(View v) {

        CustomDialogFragment dialog = new CustomDialogFragment();
        dialog.show(getSupportFragmentManager(), "custom");
    }
}