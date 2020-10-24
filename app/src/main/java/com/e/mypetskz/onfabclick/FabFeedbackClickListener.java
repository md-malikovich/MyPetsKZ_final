package com.e.mypetskz.onfabclick;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

public class FabFeedbackClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        String[] emails = new String[]{"mypetskz1@gmail.com"};
        String mailSubject = "Отзыв на приложение";
        String mailBody = "Здравствуйте. Я хотел (-а) оставить отзыв на приложение.";
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, emails);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, mailSubject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mailBody);
        emailIntent.setData(Uri.parse("mailto:"));
        if (emailIntent.resolveActivity(v.getContext().getPackageManager()) != null) {
            v.getContext().startActivity(emailIntent);
            Toast.makeText(v.getContext(), "Связаться с администратором приложения", Toast.LENGTH_SHORT).show();
        } else {
            String err;
            err = "У Вас отсутствуют установленные приложения с функцией отправки электронных писем";
            Toast.makeText(v.getContext(), err, Toast.LENGTH_SHORT).show();
        }
    }
}
