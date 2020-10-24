package com.e.mypetskz.main.petshop;

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
import android.widget.Toast;

import com.e.mypetskz.nointernet.NoInternetActivity;
import com.e.mypetskz.onfabclick.FabHomeClickListener;
import com.e.mypetskz.R;
import com.getbase.floatingactionbutton.FloatingActionButton;

public class PetShopActivity extends AppCompatActivity {

    FloatingActionButton fab_home;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_shop);

        initViews();
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

    private void initViews() {
        fab_home = findViewById(R.id.fab_home_petShopA);
        fab_home.setOnClickListener(new FabHomeClickListener());
        webView = findViewById(R.id.webView_petShopA);
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void initWeb() {
        final ConnectivityManager connMgr = (ConnectivityManager) PetShopActivity.this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        final android.net.NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        final android.net.NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifi.isConnected() || mobile.isConnected()) {
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadUrl("http://mypets.kz/petshop-list/");
            webView.setWebViewClient(new WebViewClient());
        }else{
            startActivity(new Intent(PetShopActivity.this, NoInternetActivity.class));
        }
    }
}