package com.e.mypetskz.nointernet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.e.mypetskz.R;
import com.e.mypetskz.onfabclick.FabHomeClickListener;
import com.getbase.floatingactionbutton.FloatingActionButton;

public class NoInternetActivity extends AppCompatActivity {

    FloatingActionButton fab_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);

        initViews();
    }

    private void initViews() {
        fab_home = findViewById(R.id.fab_home_noInternetA);
        fab_home.setOnClickListener(new FabHomeClickListener());
    }
}