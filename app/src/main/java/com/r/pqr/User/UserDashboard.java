package com.r.pqr.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.r.pqr.Common.LogInSignUp.UserStartUpScreen;
import com.r.pqr.HelperClasses.homeAdapter.CategoryHelperClass;
import com.r.pqr.HelperClasses.homeAdapter.CatogeryAdapter;
import com.r.pqr.HelperClasses.homeAdapter.FeaturedAdapter;
import com.r.pqr.HelperClasses.homeAdapter.FeaturedHelperClass;
import com.r.pqr.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView, recyclerView2, recyclerView3;
    RecyclerView.Adapter adapter;
    ImageView mainMenu;
    TextView ct_view;
    static final float END_SCALE = 0.7f;
    LinearLayout contentView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        recyclerView = findViewById(R.id.featured_reacycler);
        recyclerView2 = findViewById(R.id.featured_reacycler2);
        recyclerView3 = findViewById(R.id.categery_slide);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nev_layout);
        mainMenu = findViewById(R.id.main_menu);
        contentView = findViewById(R.id.contentView);
        ct_view =findViewById(R.id.dash_ct_all_view);

        ct_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserDashboard.this,AllCategories.class);
                startActivity(i);
            }
        });

        navigationView();
        recyclerView();
        recyclerView2();
        recyclerView3();

    }

    private void navigationView() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.menu_icon);

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.transparent));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.categories_icon:
                Intent intent = new Intent(getApplicationContext(), AllCategories.class);
                startActivity(intent);
                break;
        }

        switch (item.getItemId()) {
            case R.id.profile_icon:
                Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                startActivity(intent);
                break;
        }

        switch (item.getItemId()) {
            case R.id.menu_icon:
                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    private void recyclerView3() {
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoryHelperClass> categoryLocation = new ArrayList<>();
        categoryLocation.add(new CategoryHelperClass(R.drawable.city1, "city1", "dsmajhafkbksudgifajkghkjf0"));
        categoryLocation.add(new CategoryHelperClass(R.drawable.city2, "city2", "dsmajhafksudgifajkghkjf0"));
        categoryLocation.add(new CategoryHelperClass(R.drawable.city3, "city3", "dsmajhaflmkbksudgifajkghkjf0"));

        adapter = new CatogeryAdapter(categoryLocation);
        recyclerView3.setAdapter(adapter);
    }

    private void recyclerView2() {

        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocation = new ArrayList<>();
        featuredLocation.add(new FeaturedHelperClass(R.drawable.city1, "city1", "dsmajhafkbksudgifajkghkjf0"));
        featuredLocation.add(new FeaturedHelperClass(R.drawable.city2, "city2", "dsmajhafksudgifajkghkjf0"));
        featuredLocation.add(new FeaturedHelperClass(R.drawable.city3, "city3", "dsmajhaflmkbksudgifajkghkjf0"));

        adapter = new FeaturedAdapter(featuredLocation);
        recyclerView2.setAdapter(adapter);
    }

    private void recyclerView() {

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocation = new ArrayList<>();
        featuredLocation.add(new FeaturedHelperClass(R.drawable.city1, "city1", "dsmajhafkbksudgifajkghkjf0"));
        featuredLocation.add(new FeaturedHelperClass(R.drawable.city2, "city2", "dsmajhafksudgifajkghkjf0"));
        featuredLocation.add(new FeaturedHelperClass(R.drawable.city3, "city3", "dsmajhaflmkbksudgifajkghkjf0"));

        adapter = new FeaturedAdapter(featuredLocation);
        recyclerView.setAdapter(adapter);

    }

    public void CallWelcomeScreen(View view) {
        startActivity(new Intent(getApplicationContext(), UserStartUpScreen.class));

    }


}