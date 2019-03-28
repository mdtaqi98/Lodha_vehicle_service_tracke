package com.lodhahonda.lodhahonda;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class StatusActivity extends AppCompatActivity {


    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private StatusFragment statusFragment;
    private TipsFragment tipsFragment;
    private ServiceFragment serviceFragment;


    public void feedbackmt(View view){
        Intent intent = new Intent(getApplicationContext(), FeedbackActivity.class);

        startActivity(intent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        statusFragment = new StatusFragment();
        serviceFragment = new ServiceFragment();
        tipsFragment = new TipsFragment();

        setFragment(statusFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.nav_service :

                        setFragment(serviceFragment);
                        return true;


                    case R.id.nav_tips :

                        setFragment(tipsFragment);
                        return true;

                    default:
                        return false;
                }
            }
        });

    }
    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();


    }


}
