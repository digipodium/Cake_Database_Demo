package com.example.cakedatabasedemo.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cakedatabasedemo.Cake;
import com.example.cakedatabasedemo.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class CakeListAdapter extends RecyclerView.Adapter<CakeListAdapter.Holder> {


    private LayoutInflater inflater;
    private Context c;
    private List<Cake> cakes;
    private int layout;

    public CakeListAdapter(Context c, int layout) {
        this.c = c;
        this.layout = layout;
        inflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(layout, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if (cakes != null) {
            Cake cake = cakes.get(position);
            holder.tvName.setText(cake.getName());
        } else {
            holder.tvName.setText("No Cakes Available");
        }
    }

    @Override
    public int getItemCount() {
        if (cakes != null) {
            return cakes.size();
        }
        return 0;
    }

    public void setCakes(List<Cake> cakes) {
        this.cakes = cakes;
        notifyDataSetChanged();
    }


    public class Holder extends RecyclerView.ViewHolder {

        MaterialCardView card;
        TextView tvName;

        public Holder(@NonNull View v) {
            super(v);
            card = v.findViewById(R.id.card);
            tvName = v.findViewById(R.id.tvName);
        }
    }
}
