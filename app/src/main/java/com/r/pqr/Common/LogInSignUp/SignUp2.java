package com.r.pqr.Common.LogInSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.r.pqr.R;

import java.util.Calendar;

public class SignUp2 extends AppCompatActivity {

    ImageView bacBtn;
    Button next, login;
    TextView titleText, slideText;
    RadioGroup radioGroup;
    RadioButton selectAge;
    TextInputLayout regName, regUsername, regEmail, regPassword;

    DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_sign_up2);

        bacBtn = findViewById(R.id.signup_back_btn);
        next = findViewById(R.id.btn_next);
        login = findViewById(R.id.login_btn1);
        radioGroup = findViewById(R.id.radio_grp);
        datePicker = findViewById(R.id.date_picker);
        titleText = findViewById(R.id.text_sex);
        slideText = findViewById(R.id.text_age);


        regName = findViewById(R.id.name);
        regEmail = findViewById(R.id.email);
        regUsername = findViewById(R.id.username);
        regPassword = findViewById(R.id.Password1);

        Intent intent = getIntent();
        String nameS = intent.getStringExtra("one");
        String usernameS = intent.getStringExtra("one");
        String emailS = intent.getStringExtra("one");
        String passwordS = intent.getStringExtra("one");

    }

    public void call3rd_sign_up_screen(View view) {
        if (!validateAge() | !validateGender()) {
            return;
        }
        selectAge = findViewById(radioGroup.getCheckedRadioButtonId());
        selectAge.getText();
        String _gender = selectAge.getText().toString();



        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        String Date = day + "/" + month + "/" + year;

//yaha data liya hai
        String nameS = getIntent().getStringExtra("one");
        String emailS = getIntent().getStringExtra("two");
        String usernamS = getIntent().getStringExtra("three");
        String passwordS = getIntent().getStringExtra("four");

        Intent i = new Intent(getApplicationContext(), SignUp3.class);
// yaha data agli activity ko bhej rahe

        i.putExtra("one", nameS);
        i.putExtra("two", emailS);
        i.putExtra("three", usernamS);
        i.putExtra("four", passwordS);
        i.putExtra("five", _gender);
        i.putExtra("six", Date);

        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(findViewById(R.id.signup_back_btn), "animation_back_btn");
        pairs[1] = new Pair<View, String>(findViewById(R.id.btn_next), "animation_next_btn");
        pairs[2] = new Pair<View, String>(findViewById(R.id.login_btn1), "animation_sign_up");
        pairs[3] = new Pair<View, String>(findViewById(R.id.text_view1), "login_signUp_trans");


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SignUp2.this, pairs);
            startActivity(i, activityOptions.toBundle());
        } else {
            startActivity(i);

        }
    }

    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "PLEASE SELECT GENDER", Toast.LENGTH_SHORT).show();
            return false;

        } else {

            return true;
        }

    }

    private boolean validateAge() {
        int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int invalidAge = CurrentYear - userAge;
        if (invalidAge < 9) {
            Toast.makeText(this, "You're Not Eligible", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }

    }
}