package com.r.pqr.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.r.pqr.R;
import com.r.pqr.User.UserDashboard;


public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 4000;
    ImageView iv1;
    TextView tv1, tv2;
    Animation topAnim, bottomAnim, sideAnim;
    SharedPreferences onBoardingScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        iv1 = findViewById(R.id.backgroundImage);
        tv1 = findViewById(R.id.powered_by);
        tv2 = findViewById(R.id.slogan);


        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_animation);

        iv1.setAnimation(topAnim);
        tv2.setAnimation(bottomAnim);
        tv1.setAnimation(sideAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoardingScreen= getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirsTime = onBoardingScreen.getBoolean("FirstTime",true);

                if (isFirsTime){
                    SharedPreferences.Editor editor =onBoardingScreen.edit();
                    editor.putBoolean("FirstTime",false);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), OnBoarding.class);
                    startActivity(intent);
                    finish();

                }

                else {
                    Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                    startActivity(intent);
                    finish();

                }



            }
        }, SPLASH_SCREEN);
    }

}