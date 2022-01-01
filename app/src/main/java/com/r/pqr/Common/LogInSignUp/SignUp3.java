package com.r.pqr.Common.LogInSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.r.pqr.R;

public class SignUp3 extends AppCompatActivity {

    TextInputLayout phoneNo;
    CountryCodePicker countryCodePicker;
    Button button8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_sign_up3);

        phoneNo = findViewById(R.id.phoneNo);
        button8 =findViewById(R.id.btn_next);


        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatePhoneNo()) {
                    return;
                }

                String nameS = getIntent().getStringExtra("one");
                String emailS = getIntent().getStringExtra("two");
                String usernamS = getIntent().getStringExtra("three");
                String passwordS = getIntent().getStringExtra("four");
                String Date = getIntent().getStringExtra("five");
                String _gender = getIntent().getStringExtra("six");

                String _getUserEnteredPhoneNo = phoneNo.getEditText().getText().toString().trim();
                String _phoneNo = "+" +countryCodePicker.getFullNumber()+ _getUserEnteredPhoneNo;


                Intent i = new Intent(getApplicationContext(), VerifyOTP.class);

                i.putExtra("one", nameS);
                i.putExtra("two", emailS);
                i.putExtra("three", usernamS);
                i.putExtra("four", passwordS);
                i.putExtra("five", _gender);
                i.putExtra("six", Date);
                i.putExtra("seven", _phoneNo);


                startActivity(i);

            }
        });


    }

    private Boolean validatePhoneNo() {
        String val = phoneNo.getEditText().getText().toString();

        if (val.isEmpty()) {
            phoneNo.setError("Field cannot be empty");
            return false;
        } else {
            phoneNo.setError(null);
            phoneNo.setErrorEnabled(false);
            return true;
        }
    }



}