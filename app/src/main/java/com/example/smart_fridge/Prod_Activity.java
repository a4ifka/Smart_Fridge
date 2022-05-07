package com.example.smart_fridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class Prod_Activity extends AppCompatActivity {

    public String nameProd;
    public String nameProd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod);

        EditText edt = findViewById(R.id.edt);
        Button btn = findViewById(R.id.btnAddDB);

        EditText edt2 = findViewById(R.id.edt2);

        BaseDate database = new BaseDate();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                nameProd = edt.getText().toString();
                nameProd2 = edt2.getText().toString();





                Toast.makeText(Prod_Activity.this, "Успешно", Toast.LENGTH_SHORT).show();

            }
        });


    }
    public void showDialog(View v) {

        CustomDialogFragment dialog = new CustomDialogFragment();
        dialog.show(getSupportFragmentManager(), "custom");
    }
}