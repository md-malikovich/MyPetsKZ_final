package com.e.mypetskz.onfabclick;

import android.content.Intent;
import android.view.View;
import com.e.mypetskz.main.MainActivity;

public class FabHomeClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), MainActivity.class);
        v.getContext().startActivity(intent);
    }
}