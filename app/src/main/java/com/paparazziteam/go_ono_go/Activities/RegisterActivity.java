package com.paparazziteam.go_ono_go.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.paparazziteam.go_ono_go.Providers.UserProvider;
import com.paparazziteam.go_ono_go.R;
import com.paparazziteam.go_ono_go.models.User;

import java.util.Calendar;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    ImageView imageViewBack;
    ImageView imgCalendar;

    EditText edtEmail, edtPassword, edtFullname, edtDateTime;

    Button btnRegistrar;

    User mUser;
    UserProvider mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        imageViewBack = findViewById(R.id.btnBack_Register);
        imgCalendar = findViewById(R.id.imgCalendar_Register);

        edtDateTime = findViewById(R.id.edtDateTime_Register);
        edtEmail = findViewById(R.id.edtEmail_Register);
        edtFullname = findViewById(R.id.edtFullName_Register);
        edtPassword = findViewById(R.id.edtPassword_Register);

        btnRegistrar = findViewById(R.id.btnRegistrar_Register);

        mUser = new User();
        mAuth = new UserProvider();





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



        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerUser();


            }

        });


    }

    private void registerUser() {

        String email = edtEmail.getText().toString();
        String pass = edtEmail.getText().toString();
        String fullname = edtEmail.getText().toString();
        String date = edtEmail.getText().toString();

        if(email.equals("") || email == null)
        {
            edtEmail.setError("Error");
        }

        if(pass.equals("") || pass == null)
        {
            edtPassword.setError("Error");
        }

        if(fullname.equals("") || fullname == null)
        {
            edtFullname.setError("Error");
        }

        if(date.equals("") || date == null)
        {
            edtDateTime.setError("Error");
        }

        //Save data
        if(!email.equals("") && email != null)
        {

            if(!pass.equals("") && pass != null)
            {

                if(!fullname.equals("") && fullname != null)
                {
                    if(!date.equals("") && date != null)
                    {
                        mUser.setNombre(fullname);
                        mUser.setEmail(email);
                        mUser.setFecha(date);
                        mUser.setPassword(pass);

                        Log.e("","Empieza el registro");

                        //Register
                        mAuth.registerWithEmail(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful())
                                {
                                    Toast.makeText(RegisterActivity.this, "Registro Exitoso!", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(RegisterActivity.this, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                }
            }
        }
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

            //Remove error if edtDateTime have text inside their field
            if(edtDateTime.getText().toString() != null || !edtDateTime.getText().toString() .equals("") )
            {
                edtDateTime.setError(null);
            }

        }, years, months, day);
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        datePickerDialog.show();



    }
}