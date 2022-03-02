package com.shuro.smokinghealer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.shuro.smokinghealer.fragment.CalendarFragment;
import com.shuro.smokinghealer.fragment.HealthMainFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFragment;
    private BottomNavigationView mNavi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initBottomNavi();


    }

    public void initView(){
        mFragment = (FrameLayout) findViewById(R.id.fragment);
    }

    public void initBottomNavi(){
        mNavi = (BottomNavigationView) findViewById(R.id.bottom_navi);
        mNavi.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_1:
                    {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment, new HealthMainFragment())
                                .commit();
                        return true;
                    }
                    case R.id.page_2:
                    {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment, new CalendarFragment())
                                .commit();
                        return true;
                    }
                    case R.id.page_3:
                    {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment, new HealthMainFragment())
                                .commit();
                        return true;
                    }
                }
                return false;
            }
        });
        mNavi.setSelectedItemId(R.id.page_1);
    }
}