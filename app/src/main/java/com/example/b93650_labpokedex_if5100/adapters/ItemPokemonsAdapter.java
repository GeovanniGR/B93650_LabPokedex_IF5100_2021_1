package com.example.b93650_labpokedex_if5100.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.b93650_labpokedex_if5100.R;
import com.example.b93650_labpokedex_if5100.models.Result;

import java.util.ArrayList;


public class ItemPokemonsAdapter extends RecyclerView.Adapter<ItemPokemonsAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Result> resultados;
    private final OnItemClickListener listener;


    public ItemPokemonsAdapter(Context context, ArrayList<Result> resultados, OnItemClickListener listener) {
        this.context = context;
        this.resultados = resultados;
        this.listener = listener;

        Log.e("resultado", resultados.toString());
    }

    public interface OnItemClickListener {
        void onItemClick(Result item);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.pokemonName.setText(resultados.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return resultados.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView pokemonName;

        ViewHolder(final View itemView) {
            super(itemView);
            pokemonName = itemView.findViewById(R.id.nomePokemon);

            itemView.setOnClickListener(v -> {
                listener.onItemClick(resultados.get(getAdapterPosition()));
            });
        }
    }
}
