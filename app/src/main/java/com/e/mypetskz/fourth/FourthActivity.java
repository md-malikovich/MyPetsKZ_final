package com.e.mypetskz.fourth;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.e.mypetskz.nointernet.NoInternetActivity;
import com.e.mypetskz.onfabclick.FabChatClickListener;
import com.e.mypetskz.onfabclick.FabFeedbackClickListener;
import com.e.mypetskz.onfabclick.FabShareClickListener;
import com.e.mypetskz.R;
import com.e.mypetskz.main.MainActivity;
import com.e.mypetskz.second.SecondActivity;
import com.e.mypetskz.third.ThirdActivity;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FourthActivity extends AppCompatActivity {

    BottomNavigationView navView;
    FloatingActionButton fab_share, fab_feedback, fab_chat;
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        AlertDialog.Builder builder = new AlertDialog.Builder(FourthActivity.this);
        View view = LayoutInflater.from(FourthActivity.this).inflate(R.layout.view_alert_dialog_fourth, null);

        builder.setPositiveButton("Посмотреть собак", (dialogInterface, i) -> {
            final ConnectivityManager connMgr = (ConnectivityManager) FourthActivity.this
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            final android.net.NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            final android.net.NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (wifi.isConnected() || mobile.isConnected()) {
                WebSettings webSettingsDog = webView.getSettings();
                webSettingsDog.setJavaScriptEnabled(true);
                webView.loadUrl("http://mypets.kz/dog-list");
                webView.setWebViewClient(new WebViewClient());
            }else{
                startActivity(new Intent(FourthActivity.this, NoInternetActivity.class));
            }
        });

        builder.setNegativeButton("Посмотреть кошек", (dialogInterface, i) -> {
            final ConnectivityManager connMgr = (ConnectivityManager) FourthActivity.this
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            final android.net.NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            final android.net.NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (wifi.isConnected() || mobile.isConnected()) {
                WebSettings webSettingsCat = webView.getSettings();
                webSettingsCat.setJavaScriptEnabled(true);
                webView.loadUrl("http://mypets.kz/kitten-list");
                webView.setWebViewClient(new WebViewClient());
            }else{
                startActivity(new Intent(FourthActivity.this, NoInternetActivity.class));
            }
        });
        builder.setCancelable(false);
        builder.setView(view);
        builder.show();

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
        fab_share = findViewById(R.id.fab_share_fourthA);
        fab_feedback = findViewById(R.id.fab_feedback_fourthA);
        fab_chat = findViewById(R.id.fab_chat_fourthA);
        fab_share.setOnClickListener(new FabShareClickListener());
        fab_feedback.setOnClickListener(new FabFeedbackClickListener());
        fab_chat.setOnClickListener(new FabChatClickListener());
        navView = findViewById(R.id.navView_fourthA);
        navView.setSelectedItemId(R.id.navigation_fourth);
        webView = findViewById(R.id.webView_fourthA);
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void initWeb() {
        final ConnectivityManager connMgr = (ConnectivityManager) FourthActivity.this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        final android.net.NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        final android.net.NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifi.isConnected() || mobile.isConnected()) {
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadUrl("http://mypets.kz");
            webView.setWebViewClient(new WebViewClient());
        }else{
            startActivity(new Intent(FourthActivity.this, NoInternetActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
            webView.goBack();
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
                    startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.navigation_third:
                    startActivity(new Intent(getApplicationContext(), ThirdActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.navigation_fourth:
                    return true;
            }
            return false;
        });
    }
}