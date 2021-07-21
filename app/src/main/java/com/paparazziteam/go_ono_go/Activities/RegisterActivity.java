package com.paparazziteam.go_ono_go.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.paparazziteam.go_ono_go.R;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    ImageView imageViewBack;
    ImageView imgCalendar;

    EditText edtDateTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        imageViewBack = findViewById(R.id.btnBack_Register);
        imgCalendar = findViewById(R.id.imgCalendar_Register);
        edtDateTime = findViewById(R.id.edtDateTime_Register);



        implementClicksListener();
    }

    private void implementClicksListener() {

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


        imgCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dateTimePicker();

            }
        });

        edtDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateTimePicker();
            }
        });




    }

    private void dateTimePicker() {

        Calendar calendar = Calendar.getInstance();
        int years = calendar.get(Calendar.YEAR);
        int months  = calendar.get(Calendar.MONTH);
        int day  = calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog  = new DatePickerDialog(RegisterActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, (view, year, month, dayOfMonth) -> {
            month+=1;

            //Log.e("DATA",""+year+"/"+month+"/"+dayOfMonth);
            //Log.e("DATACALENDAR",""+years+"/"+months+"/"+day);

            String date = dayOfMonth+"/"+month+"/"+year;
            edtDateTime.setText(date);
        }, years, months, day);
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        datePickerDialog.show();



    }
}