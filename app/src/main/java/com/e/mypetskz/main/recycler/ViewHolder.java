package com.e.mypetskz.main.recycler;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.e.mypetskz.R;
import com.e.mypetskz.main.groomer.GroomerActivity;
import com.e.mypetskz.main.handler.HandlerActivity;
import com.e.mypetskz.main.hotel.HotelActivity;
import com.e.mypetskz.main.kennel.KennelActivity;
import com.e.mypetskz.main.lost.LostActivity;
import com.e.mypetskz.main.petshop.PetShopActivity;
import com.e.mypetskz.main.shelter.ShelterActivity;
import com.e.mypetskz.main.veterinary.VeterinaryClinicActivity;
import com.e.mypetskz.model.MainModel;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView title;
    private ImageView icon;
    MainModel mainModel;
    CardView cardView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.tvItem_mainA);
        icon = itemView.findViewById(R.id.imgItem_mainA);
        cardView = itemView.findViewById(R.id.cardView_mainA);
        cardView.setOnClickListener(this);
    }

    public void onBind(MainModel mainModel) {
        this.mainModel = mainModel;
        title.setText(mainModel.title);
        icon.setImageResource(mainModel.img);
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        if (position == 0) {
            Intent intent0 = new Intent(v.getContext(), LostActivity.class);
            v.getContext().startActivity(intent0);
        }
        if (position == 1) {
            Intent intent1 = new Intent(v.getContext(), PetShopActivity.class);
            v.getContext().startActivity(intent1);
        }
        if (position == 2) {
            Intent intent2 = new Intent(v.getContext(), VeterinaryClinicActivity.class);
            v.getContext().startActivity(intent2);
        }
        if (position == 3) {
            Intent intent3 = new Intent(v.getContext(), HandlerActivity.class);
            v.getContext().startActivity(intent3);
        }
        if (position == 4) {
            Intent intent4 = new Intent(v.getContext(), KennelActivity.class);
            v.getContext().startActivity(intent4);
        }
        if (position == 5) {
            Intent intent5 = new Intent(v.getContext(), GroomerActivity.class);
            v.getContext().startActivity(intent5);
        }
        if (position == 6) {
            Intent intent6 = new Intent(v.getContext(), HotelActivity.class);
            v.getContext().startActivity(intent6);
        }
        if (position == 7) {
            Intent intent7 = new Intent(v.getContext(), ShelterActivity.class);
            v.getContext().startActivity(intent7);
        }
    }
}