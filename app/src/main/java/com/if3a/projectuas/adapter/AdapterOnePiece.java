package com.if3a.projectuas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if3a.projectuas.R;
import com.if3a.projectuas.model.RootOnePiece;

import java.util.ArrayList;
import java.util.List;

public class AdapterOnePiece extends RecyclerView.Adapter<AdapterOnePiece.HolderData>{
    private List<RootOnePiece> listOnePiece = new ArrayList<>();

    public AdapterOnePiece(List<RootOnePiece> listOnePiece){
        this.listOnePiece = listOnePiece;
    }

    @NonNull
    @Override
    public AdapterOnePiece.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_one_piece, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterOnePiece.HolderData holder, int position) {
        RootOnePiece QM = listOnePiece.get(position);

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
        return listOnePiece.size();
    }

    public static class HolderData extends RecyclerView.ViewHolder {
        TextView tvAnime, tvName, tvQuote;
        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvAnime = itemView.findViewById(R.id.tv_anime2);
            tvName = itemView.findViewById(R.id.tv_character2);
            tvQuote = itemView.findViewById(R.id.tv_quote2);

        }
    }
}
