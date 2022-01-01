package com.r.pqr.Common.LogInSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.r.pqr.R;

public class SetNewPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);
    }
    public void COnformationPage(){
        Intent i = new Intent(getApplicationContext(),ForegetPasswordSuccessMassage.class);
        startActivity(i);
    }
}