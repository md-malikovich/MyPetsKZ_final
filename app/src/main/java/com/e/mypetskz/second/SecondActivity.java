package com.e.mypetskz.second;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.e.mypetskz.nointernet.NoInternetActivity;
import com.e.mypetskz.onfabclick.FabChatClickListener;
import com.e.mypetskz.onfabclick.FabFeedbackClickListener;
import com.e.mypetskz.onfabclick.FabShareClickListener;
import com.e.mypetskz.R;
import com.e.mypetskz.fourth.FourthActivity;
import com.e.mypetskz.main.MainActivity;
import com.e.mypetskz.third.ThirdActivity;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondActivity extends AppCompatActivity {

    BottomNavigationView navView;
    FloatingActionButton fab_share, fab_feedback, fab_chat;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initViews();
        setBottomNavigationView();
        initWeb();

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("mailto:") || url.startsWith("tel:") || url.startsWith("whatsapp:")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }

    public void initViews() {
        fab_share = findViewById(R.id.fab_share_secondA);
        fab_feedback = findViewById(R.id.fab_feedback_secondA);
        fab_chat = findViewById(R.id.fab_chat_secondA);
        fab_share.setOnClickListener(new FabShareClickListener());
        fab_feedback.setOnClickListener(new FabFeedbackClickListener());
        fab_chat.setOnClickListener(new FabChatClickListener());
        navView = findViewById(R.id.navView_secondA);
        navView.setSelectedItemId(R.id.navigation_second);
        webView = findViewById(R.id.webView_secondA);
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void initWeb() {
        final ConnectivityManager connMgr = (ConnectivityManager) SecondActivity.this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        final android.net.NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        final android.net.NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifi.isConnected() || mobile.isConnected()) {
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadUrl("http://mypets.kz/promotions/");
            webView.setWebViewClient(new WebViewClient());
        }else{
            startActivity(new Intent(SecondActivity.this, NoInternetActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        }
        else
            super.onBackPressed();
    }

    private void setBottomNavigationView() {
        navView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_main:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.navigation_second:
                    return true;
                case R.id.navigation_third:
                    startActivity(new Intent(getApplicationContext(), ThirdActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.navigation_fourth:
                    startActivity(new Intent(getApplicationContext(), FourthActivity.class));
                    overridePendingTransition(0, 0);
                    return false;
            }
            return false;
        });
    }
}