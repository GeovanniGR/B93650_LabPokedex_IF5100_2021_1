package com.example.b93650_labpokedex_if5100.interfaces;

import com.example.b93650_labpokedex_if5100.models.Pokedex;
import com.example.b93650_labpokedex_if5100.models.Pokemon;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonServicios {
    @GET("pokemon")
    Call<Pokedex> getPokemons();

    @GET("pokemon/{id}")
    Call<Pokemon> choosePokemon (@Path("id") String nome);
}
