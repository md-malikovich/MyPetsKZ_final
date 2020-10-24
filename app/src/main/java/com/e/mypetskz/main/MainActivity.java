package com.e.mypetskz.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import com.e.mypetskz.onfabclick.FabChatClickListener;
import com.e.mypetskz.onfabclick.FabFeedbackClickListener;
import com.e.mypetskz.onfabclick.FabShareClickListener;
import com.e.mypetskz.R;
import com.e.mypetskz.fourth.FourthActivity;
import com.e.mypetskz.main.recycler.Adapter;
import com.e.mypetskz.second.SecondActivity;
import com.e.mypetskz.third.ThirdActivity;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navView;
    FloatingActionButton fab_share, fab_feedback, fab_chat;
    RecyclerView recyclerView;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setBottomNavigationView();
    }

    @Override
    public void onBackPressed() {
        switch (navView.getSelectedItemId()) {
            case R.id.navView_mainA:
                super.onBackPressed();
            case R.id.navView_secondA:
                navView.setSelectedItemId(R.id.navView_mainA);
                break;
            case R.id.navView_thirdA:
            case R.id.navView_fourthA:
                navView.setSelectedItemId(R.id.navView_mainA);
                break;
            default:
                super.onBackPressed();
        }
    }

    public void initViews() {
        fab_share = findViewById(R.id.fab_share_mainA);
        fab_feedback = findViewById(R.id.fab_feedback_mainA);
        fab_chat = findViewById(R.id.fab_chat_mainA);
        fab_share.setOnClickListener(new FabShareClickListener());
        fab_feedback.setOnClickListener(new FabFeedbackClickListener());
        fab_chat.setOnClickListener(new FabChatClickListener());
        navView = findViewById(R.id.navView_mainA);
        navView.setSelectedItemId(R.id.navigation_main);

        cardView = findViewById(R.id.cardView_mainA);
        recyclerView = findViewById(R.id.recycler_mainA);
        Adapter adapter = new Adapter();
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }

    private void setBottomNavigationView() {
        navView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_main:
                    return true;
                case R.id.navigation_second:
                    startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.navigation_third:
                    startActivity(new Intent(getApplicationContext(), ThirdActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.navigation_fourth:
                    startActivity(new Intent(getApplicationContext(), FourthActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });
    }
}