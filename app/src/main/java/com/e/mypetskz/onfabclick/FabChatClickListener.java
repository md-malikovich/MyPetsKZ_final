package com.e.mypetskz.onfabclick;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

public class FabChatClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/FPuslezsVxWF9IIyo2dKje"));
        v.getContext().startActivity(browserIntent);
        Toast.makeText(v.getContext(), "Присоединиться к группе в WhatsApp", Toast.LENGTH_SHORT).show();
    }
}
