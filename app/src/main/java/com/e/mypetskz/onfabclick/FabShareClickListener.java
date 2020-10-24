package com.e.mypetskz.onfabclick;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.e.mypetskz.BuildConfig;

public class FabShareClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Вы можете скачать приложение MyPets по ссылке: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
        sendIntent.setType("text/plain");
        v.getContext().startActivity(sendIntent);
        Toast.makeText(v.getContext(), "Поделиться приложением", Toast.LENGTH_SHORT).show();
    }
}
