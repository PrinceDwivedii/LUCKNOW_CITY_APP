package com.r.pqr.Common.LogInSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.r.pqr.R;
import com.r.pqr.User.UserDashboard;

public class UserStartUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_start_up_screen);
    }

    public void callLoginScreen(View view) {
        Intent i = new Intent(getApplicationContext(), Login.class);

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair<View, String>(findViewById(R.id.login_new), "animation_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(UserStartUpScreen.this, pairs);
            startActivity(i, activityOptions.toBundle());
        } else {
            startActivity(i);
        }

    }

    public void callSignUpScreen(View view) {

        Intent i = new Intent(getApplicationContext(), Signup.class);

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair<View, String>(findViewById(R.id.signup_new), "animation_sign_up");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(UserStartUpScreen.this, pairs);
            startActivity(i, activityOptions.toBundle());
        } else {
            startActivity(i);

        }

    }


}