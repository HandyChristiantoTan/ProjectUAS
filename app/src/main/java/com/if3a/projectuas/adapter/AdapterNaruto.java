package com.if3a.projectuas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if3a.projectuas.R;
import com.if3a.projectuas.model.RootNaruto;

import java.util.ArrayList;
import java.util.List;

public class AdapterNaruto extends RecyclerView.Adapter<AdapterNaruto.HolderData> {
    private List<RootNaruto> listNaruto = new ArrayList<>();

    public AdapterNaruto(List<RootNaruto> listNaruto){
        this.listNaruto = listNaruto;
    }

    @NonNull
    @Override
    public AdapterNaruto.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_naruto, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNaruto.HolderData holder, int position) {
        RootNaruto QM = listNaruto.get(position);

        holder.tvAnime.setText(QM.getAnime());
        holder.tvName.setText(QM.getCharacter());
        holder.tvQuote.setText(QM.getQuote());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), "Anime : " + QM.getAnime(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listNaruto.size();
    }

    public static class HolderData extends RecyclerView.ViewHolder {
        TextView tvAnime, tvName, tvQuote;
        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvAnime = itemView.findViewById(R.id.tv_anime1);
            tvName = itemView.findViewById(R.id.tv_character1);
            tvQuote = itemView.findViewById(R.id.tv_quote1);

        }
    }

}
