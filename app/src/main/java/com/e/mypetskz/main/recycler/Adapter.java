package com.e.mypetskz.main.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.e.mypetskz.R;
import com.e.mypetskz.model.MainModel;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private List<MainModel> models;

    public Adapter() {
        models = new ArrayList<>();
        models.add(new MainModel(R.drawable.lost, "Потерянные питомцы - SOS"));
        models.add(new MainModel(R.drawable.petshop, "Зоомагазины"));
        models.add(new MainModel(R.drawable.vet, "Ветеринарные клиники"));
        models.add(new MainModel(R.drawable.handler, "Кинологи и хендлеры"));
        models.add(new MainModel(R.drawable.kennel, "Питомники и заводчики"));
        models.add(new MainModel(R.drawable.grumer, "Грумеры"));
        models.add(new MainModel(R.drawable.hotel, "Гостиницы"));
        models.add(new MainModel(R.drawable.fonds, "Фонды и приюты"));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_holder_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(models.get(position));
        holder.cardView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}