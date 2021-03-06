package com.justgraduationproject.android.recommenderapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //coloring Hint Text with HTML Tag
        EditText search = (EditText) findViewById(R.id.search);
        search.setHint(Html.fromHtml("<font color = '#000000'> Search </font>"));
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNaviHelper.disableShiftMode(navigation);


        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
    }
    public void Navigation(int X)
    {
        if (X == R.id.navigation_home)
        {
            Intent I = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(I);

        } else if (X == R.id.navigation_community)
        {
            Intent I = new Intent(MainActivity.this, MainActivity.class);
            startActivity(I);
        }
        else if (X == R.id.navigation_messaging)
        {
            Intent I = new Intent(MainActivity.this, MainActivity.class);
            startActivity(I);
        }
        else if (X == R.id.navigation_notifications)
        {
            Intent I = new Intent(MainActivity.this, NotificationsActivity.class);
            startActivity(I);
        }
        else if (X == R.id.navigation_profile)
        {
            Intent I = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(I);
        }

    }

    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()
    {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            switch (item.getItemId()) {
                case R.id.navigation_home: {
                    Navigation(R.id.navigation_home);
                    return true;
                }
                case R.id.navigation_messaging:{
                    Navigation(R.id.navigation_messaging);
                    return true;
                }
                case R.id.navigation_notifications: {
                    Navigation(R.id.navigation_notifications);
                    return true;
                }
                case R.id.navigation_profile: {
                    Navigation(R.id.navigation_profile);
                    return true;
                }
                case R.id.navigation_community: {
                    Navigation(R.id.navigation_community);
                    return true;
                }
            }
            return false;
        }
    };
}