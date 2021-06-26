package com.example.b93650_labpokedex_if5100;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.b93650_labpokedex_if5100.adapters.ItemPokemonsAdapter;
import com.example.b93650_labpokedex_if5100.adapters.RetrofitAdapter;
import com.example.b93650_labpokedex_if5100.models.Pokedex;
import com.example.b93650_labpokedex_if5100.models.Result;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recPoke;
    private ArrayList<Result> pokemonsList = new ArrayList<>();
    private ItemPokemonsAdapter adapterPokemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recPoke = findViewById(R.id.pokemons);

        getPokemons();
    }


    private void getPokemons(){
        Call<Pokedex> call = RetrofitAdapter.acessar().getPokemons();
        call.enqueue(new Callback<Pokedex>() {
            @Override
            public void onResponse(@NonNull Call<Pokedex> call, @NonNull Response<Pokedex> response) {
                assert response.body() != null;
                pokemonsList.addAll(response.body().getResults());

                Log.e("dee", response.body().getResults().toString());
                adapterPokemons = new ItemPokemonsAdapter(MainActivity.this, pokemonsList, item -> {
                    Log.e("Pokemon CLicado", item.getName());
                    Intent intent = new Intent(MainActivity.this, PokemonDetallesActivity.class);
                    intent.putExtra("op", item);
                    startActivity(intent);
                });

                recPoke.setAdapter(adapterPokemons);
            }

            @Override
            public void onFailure(Call<Pokedex> call, Throwable t) {

            }
        });
    }
}
