package com.example.b93650_labpokedex_if5100;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.b93650_labpokedex_if5100.adapters.RetrofitAdapter;
import com.example.b93650_labpokedex_if5100.models.Pokemon;
import com.example.b93650_labpokedex_if5100.models.Result;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PokemonDetallesActivity extends AppCompatActivity {
    private Result result;
    private String name;

    private TextView nomPokemontv, alturatv, pesotv, xptv, habilidadtv ;

    private ImageView foto;


    private String peso, urlImagem;
    private String altura;
    private String xp;
    private String habilidad;

    private ArrayList<Pokemon> caracteristicas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detalles);

        nomPokemontv = findViewById(R.id.name);
        alturatv = findViewById(R.id.altura);
        pesotv = findViewById(R.id.peso);
        xptv = findViewById(R.id.xp);
        foto = findViewById(R.id.foto);
        habilidadtv=findViewById(R.id.habilidad);

        result = (Result) getIntent().getSerializableExtra("op");
        name = result.getName();

        nomPokemontv.setText(name);

        getPokemon();
    }


    private void getPokemon(){
        Call<Pokemon> call = RetrofitAdapter.acessar().choosePokemon(name);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(@NonNull Call<Pokemon> call, @NonNull Response<Pokemon> response) {
                assert response.body() != null;
                altura = response.body().getHeight().toString();
                peso = response.body().getWeight().toString();
                xp = response.body().getBaseExperience().toString();
                habilidad=response.body().getAbilities().get(0).getAbility().getName();

                urlImagem = response.body().getSprites().getFrontDefault();

                alturatv.setText(altura);
                pesotv.setText(peso);
                xptv.setText(xp);
                habilidadtv.setText(habilidad);

                Glide.with(PokemonDetallesActivity.this)
                        .load(response.body().getSprites().getFrontDefault())
                        .into(foto);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        });
    }
}
